package com.oaes.agent.provider;

import com.oaes.agent.client.OllamaClient;
import com.oaes.agent.config.OllamaProperties;
import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaRequest;
import com.oaes.agent.model.OllamaResponse;
import com.oaes.agent.model.OllamaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OllamaProvider implements LlmProvider {

    private final OllamaClient ollamaClient;
    private final OllamaProperties properties;

    public ChatResponse chat(List<OllamaMessage> messages) {

        OllamaRequest request = new OllamaRequest();

        request.setModel(properties.getModel());
        request.setMessages(messages);
        request.setStream(false);

        OllamaResponse response = ollamaClient.chat(request);

        if (response == null ||
                response.getMessage() == null ||
                response.getMessage().getContent() == null) {

            return new ChatResponse("No response from Ollama.");
        }

        return new ChatResponse(
                response.getMessage().getContent()
        );
    }
}