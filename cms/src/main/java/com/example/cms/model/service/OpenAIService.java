package com.example.cms.model.service;

import okhttp3.*;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OpenAIService {

    private static final String API_KEY = "YOUR KEY HERE";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    private final OkHttpClient client = new OkHttpClient();

    public String extractJsonResponse(String userQuery, String SYSTEM_PROMPT) throws IOException {
        JsonObject payload = new JsonObject();
        payload.addProperty("model", "gpt-4");

        JsonArray messages = new JsonArray();

        JsonObject system = new JsonObject();
        system.addProperty("role", "system");
        system.addProperty("content", SYSTEM_PROMPT);

        JsonObject user = new JsonObject();
        user.addProperty("role", "user");
        user.addProperty("content", userQuery);

        messages.add(system);
        messages.add(user);

        payload.add("messages", messages);

        RequestBody body = RequestBody.create(payload.toString(), MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("OpenAI call failed: " + response.body().string());
            }

            String responseBody = response.body().string();

            // Get the JSON string from inside the assistant's message
            return JsonParser.parseString(responseBody)
                    .getAsJsonObject()
                    .getAsJsonArray("choices")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content")
                    .getAsString();
        }
    }
}

