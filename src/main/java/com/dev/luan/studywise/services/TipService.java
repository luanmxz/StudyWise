package com.dev.luan.studywise.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.luan.studywise.AppEnvironment;
import com.dev.luan.studywise.dto.create_tag.Content;
import com.dev.luan.studywise.dto.create_tag.Message;
import com.dev.luan.studywise.dto.create_tag.Messages;
import com.dev.luan.studywise.dto.create_tip.response.CreateTipResponse;
import com.dev.luan.studywise.model.Tip;
import com.google.gson.Gson;

@Service
public class TipService {

    @Autowired
    private AppEnvironment appEnvironment;

    private String createTagPrompt(String tag, String difficulty) throws IOException {

        List<Message> messages = new ArrayList<Message>();
        Message message = new Message();
        message.setRole("user");
        List<Content> content = new ArrayList<Content>();
        content.add(new Content("text",
                String.format(appEnvironment.getPromptToCreateTip(), tag, difficulty)));
        message.setContent(content);
        messages.add(message);

        Messages messagesObj = new Messages(messages, Integer.parseInt(appEnvironment.getMaxTokensToGenerateText()),
                appEnvironment.getGenerativeIaModel(), false);

        Gson gson = new Gson();

        String json = gson.toJson(messagesObj);

        return json;
    }

    public Tip createTip(String tag, String difficulty) throws URISyntaxException, IOException, InterruptedException {

        if (difficulty == null || difficulty.isEmpty()) {
            difficulty = "easy";
        }

        String jsonTagPrompt = this.createTagPrompt(tag, difficulty);

        HttpRequest request = HttpRequest
                .newBuilder(new URI(appEnvironment.getHuggingFaceUrl()))
                .header("Authorization", "Bearer " + appEnvironment.getHuggingFaceApiKey())
                .header("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(30))
                .POST(HttpRequest.BodyPublishers.ofString(jsonTagPrompt))
                .build();
        ;

        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
        System.out.println("Response Body: " + response.body()); // Debug

        Gson gson = new Gson();

        // 1. Parseia o JSON externo com choices/message/content (string)
        CreateTipResponse createdTipResponse = gson.fromJson(response.body(), CreateTipResponse.class);

        // 2. Pega o conteúdo gerado (ainda em forma de string JSON)
        String contentJson = createdTipResponse.choices().get(0).getMessage().getContent();

        String cleanedJson = contentJson
                .replaceAll("(?s)^```json\\s*", "") // tira a fence de abertura
                .replaceAll("\\s*```$", ""); // tira a fence de fechamento

        // Tip tip1 = new Gson().fromJson(cleanedJson, new TypeToken<Tip>() {
        // }.getType());

        Tip tip = gson.fromJson(cleanedJson, Tip.class);

        return tip;
    }
}
