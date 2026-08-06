package com.oaes.agent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.agent.provider.LlmProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LlmService {

    private final LlmProvider llmProvider;

    public ChatResponse chat(List<OllamaMessage> messages) {
        return llmProvider.chat(messages);
    }
}