package com.oaes.llm.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LlmServiceImpl implements LlmService {

    private final Client client;

    @Value("${gemini.model}")
    private String model;

    public LlmServiceImpl(
            @Value("${gemini.api-key}") String apiKey
    ) {
        this.client = Client.builder()
                .apiKey(apiKey)
                .build();
    }

    @Override
    public String generate(String prompt) {

        GenerateContentResponse response =
                client.models.generateContent(
                        model,
                        prompt,
                        null
                );

        return response.text();
    }
}