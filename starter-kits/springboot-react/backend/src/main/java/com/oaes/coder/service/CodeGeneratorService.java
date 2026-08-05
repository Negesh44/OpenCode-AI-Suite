package com.oaes.coder.service;

import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.agent.service.LlmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeGeneratorService {

    private final LlmService llmService;

    public String generateCode(String prompt) {

        ChatResponse response = llmService.chat(
                List.of(
                        new OllamaMessage(
                                "user",
                                prompt
                        )
                )
        );

        return response.getResponse();
    }

}