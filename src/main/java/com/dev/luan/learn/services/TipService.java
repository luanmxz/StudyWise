package com.dev.luan.learn.services;

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

import com.dev.luan.learn.AppEnvironment;
import com.dev.luan.learn.dto.create_tag.Content;
import com.dev.luan.learn.dto.create_tag.Message;
import com.dev.luan.learn.dto.create_tag.Messages;
import com.dev.luan.learn.dto.create_tip.response.CreateTipResponse;
import com.google.gson.Gson;

@Service
public class TipService {

    @Autowired
    private AppEnvironment appEnvironment;

    private String createTagPrompt(String tag) {

        List<Message> messages = new ArrayList<Message>();
        Message message = new Message();
        message.setRole("user");
        List<Content> content = new ArrayList<Content>();
        content.add(new Content("text",
                String.format(appEnvironment.getPromptToCreateTip(), tag)));
        message.setContent(content);
        messages.add(message);

        Messages messagesObj = new Messages(messages, Integer.parseInt(appEnvironment.getMaxTokensToGenerateText()),
                appEnvironment.getGenerativeIaModel(), false);

        Gson gson = new Gson();

        String json = gson.toJson(messagesObj);

        return json;
    }

    public CreateTipResponse createTip(String tag) throws URISyntaxException, IOException, InterruptedException {

        String jsonTagPrompt = this.createTagPrompt(tag);

        HttpRequest request = HttpRequest
                .newBuilder(new URI(appEnvironment.getHuggingFaceUrl()))
                .header("Authorization", "Bearer " + appEnvironment.getHuggingFaceApiKey())
                .header("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(30))
                .POST(HttpRequest.BodyPublishers.ofString(jsonTagPrompt))
                .build();
        ;

        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());

        Gson gson = new Gson();

        CreateTipResponse createdTipResponse = gson.fromJson(response.body(), CreateTipResponse.class);

        return createdTipResponse;
    }
}
