package com.oaes.coder.service;

import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.agent.service.LlmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeGenerationService {

    private final LlmService llmService;

    public String generate(String filePath,
                           String description) {

        String prompt = """
You are a senior software engineer.

Generate ONLY the contents of the requested file.

Do not use markdown.
Do not explain.

File:

%s

Description:

%s
""".formatted(filePath, description);

        ChatResponse response =
                llmService.chat(
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