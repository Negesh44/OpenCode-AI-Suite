package com.oaes.editor.service;

import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.agent.service.LlmService;
import com.oaes.editor.dto.EditRequest;
import com.oaes.editor.prompt.EditorPrompt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeEditorService {

    private final LlmService llmService;

    public String edit(EditRequest request) {

        String prompt =
                EditorPrompt.build(request);

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