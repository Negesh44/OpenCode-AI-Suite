package com.oaes.agent.provider;

import com.oaes.agent.client.OllamaClient;
import com.oaes.agent.config.OllamaProperties;
import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.agent.model.OllamaRequest;
import com.oaes.agent.model.OllamaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OllamaProvider implements LlmProvider {

    private final OllamaClient ollamaClient;
    private final OllamaProperties properties;

    @Override
    public ChatResponse chat(List<OllamaMessage> messages) {

        OllamaRequest request = new OllamaRequest();

        request.setModel(properties.getModel());
        request.setMessages(messages);
        request.setStream(false);

        System.out.println("\n========== OLLAMA REQUEST ==========");
        System.out.println("URL      : " + properties.getUrl());
        System.out.println("Model    : " + request.getModel());
        System.out.println("Stream   : " + request.isStream());

        System.out.println("\nMessages:");

        for (OllamaMessage message : request.getMessages()) {

            System.out.println("--------------------------------");
            System.out.println("Role:");
            System.out.println(message.getRole());

            System.out.println("\nContent:");
            System.out.println(message.getContent());

        }

        System.out.println("===================================\n");

        OllamaResponse response = ollamaClient.chat(request);

        System.out.println("\n========== OLLAMA RESPONSE ==========");

        if (response == null) {

            System.out.println("Response is NULL");

            return new ChatResponse("No response from Ollama.");

        }

        System.out.println(response);

        System.out.println("=====================================\n");

        if (response.getMessage() == null ||
                response.getMessage().getContent() == null) {

            return new ChatResponse("No response from Ollama.");

        }

        return new ChatResponse(
                response.getMessage().getContent()
        );

    }

}