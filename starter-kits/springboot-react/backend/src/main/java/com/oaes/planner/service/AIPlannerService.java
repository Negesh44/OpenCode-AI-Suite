package com.oaes.planner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.agent.service.LlmService;
import com.oaes.planner.model.PlannerResult;
import com.oaes.planner.prompt.PromptTemplates;
import com.oaes.planner.util.JsonExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIPlannerService {

    private final LlmService llmService;
    private final ObjectMapper objectMapper;

    public PlannerResult createPlan(String goal) {

        try {

            String prompt = PromptTemplates.plannerPrompt(goal);

            OllamaMessage message = new OllamaMessage(
                    "user",
                    prompt
            );

            ChatResponse response =
                    llmService.chat(List.of(message));

            String json =
                    JsonExtractor.extract(
                            response.getResponse()
                    );

            return objectMapper.readValue(
                    json,
                    PlannerResult.class
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to generate AI plan.",
                    e
            );

        }

    }

}