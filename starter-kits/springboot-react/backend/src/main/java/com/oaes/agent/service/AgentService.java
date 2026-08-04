package com.oaes.agent.service;

import com.oaes.agent.dto.ChatRequest;
import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.provider.LlmProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final LlmProvider llmProvider;

    public ChatResponse chat(ChatRequest request) {
        return llmProvider.chat(request);
    }
}