package com.dev.luan.studywise.application.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.luan.studywise.adapters.dto.create_revision_unit.request.CreateRevisionUnitRequest;
import com.dev.luan.studywise.adapters.dto.create_revision_unit.response.CreateTipResponse;
import com.dev.luan.studywise.adapters.dto.create_tag.Content;
import com.dev.luan.studywise.adapters.dto.create_tag.Message;
import com.dev.luan.studywise.adapters.dto.create_tag.Messages;
import com.dev.luan.studywise.domain.model.RevisionUnit;
import com.dev.luan.studywise.infrastructure.environment.AppEnvironment;
import com.google.gson.JsonDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class RevisionUnitService {

        @Autowired
        private AppEnvironment appEnvironment;

        private String createRevisionUnitPrompt(String subject, String subtopic)
                        throws IOException {

                List<Message> messages = new ArrayList<Message>();
                Message message = new Message();
                message.setRole("user");
                List<Content> content = new ArrayList<Content>();
                content.add(new Content("text",
                                String.format(appEnvironment.getPromptToCreateTip(), subject, subtopic)));
                message.setContent(content);
                messages.add(message);

                Messages messagesObj = new Messages(messages,
                                Integer.parseInt(appEnvironment.getMaxTokensToGenerateText()),
                                appEnvironment.getGenerativeIaModel(), false);

                Gson gson = new Gson();

                String json = gson.toJson(messagesObj);

                return json;
        }

        public RevisionUnit createRevisionUnit(CreateRevisionUnitRequest createRevisionUnitRequestDTO)
                        throws URISyntaxException, IOException, InterruptedException {

                String jsonTagPrompt = this.createRevisionUnitPrompt(createRevisionUnitRequestDTO.subjectDTO().name(),
                                createRevisionUnitRequestDTO.subtopicDTO().name());

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

                Gson gson = new GsonBuilder()
                                .registerTypeAdapter(OffsetDateTime.class,
                                                (JsonDeserializer<OffsetDateTime>) (json, typeOfT,
                                                                context) -> OffsetDateTime.parse(json.getAsString()))
                                .create();

                // 1. Parseia o JSON externo com choices/message/content (string)
                CreateTipResponse createdTipResponse = gson.fromJson(response.body(), CreateTipResponse.class);

                // 2. Pega o conteúdo gerado (ainda em forma de string JSON)
                String contentJson = createdTipResponse.choices().get(0).getMessage().getContent();

                String cleanedJson = contentJson
                                .replaceAll("(?s)^```json\\s*", "") // tira a fence de abertura
                                .replaceAll("\\s*```$", ""); // tira a fence de fechamento

                // Tip tip1 = new Gson().fromJson(cleanedJson, new TypeToken<Tip>() {
                // }.getType());

                RevisionUnit tip = gson.fromJson(cleanedJson, RevisionUnit.class);

                return tip;
        }
}
