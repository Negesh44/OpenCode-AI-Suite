package com.oaes.agent.provider;

import com.oaes.agent.dto.ChatRequest;
import com.oaes.agent.dto.ChatResponse;
import org.springframework.stereotype.Component;

@Component
public class OllamaProvider implements LlmProvider {

    @Override
    public ChatResponse chat(ChatRequest request) {

        return new ChatResponse("Hello from OAES AI!");

    }
}