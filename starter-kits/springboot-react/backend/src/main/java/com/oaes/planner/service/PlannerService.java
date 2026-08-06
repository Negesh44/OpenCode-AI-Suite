package com.oaes.planner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaes.llm.service.LlmService;
import com.oaes.planner.dto.PlannerRequest;
import com.oaes.planner.model.PlannerResult;
import org.springframework.stereotype.Service;

@Service
public class PlannerService {

    private final LlmService llmService;
    private final ObjectMapper objectMapper;

    public PlannerService(LlmService llmService) {
        this.llmService = llmService;
        this.objectMapper = new ObjectMapper();
    }

    public PlannerResult createPlan(PlannerRequest request) {

        String prompt = """
You are an expert software architect.

Generate ONLY valid JSON.

Do NOT include markdown.
Do NOT include ```json.
Do NOT include explanations.

Return EXACTLY this structure:

{
  "goal": "string",
  "tasks": [
    {
      "step": 1,
      "description": "string",
      "tool": "FILE",
      "action": "CREATE",
      "path": "README.md",
      "content": "optional",
      "command": "",
      "instruction": ""
    }
  ]
}

Available tool values:
FILE
TERMINAL
GIT
BROWSER

Goal:
%s
""".formatted(request.getGoal());

        try {

            String response = llmService.generate(prompt);

            System.out.println("========== GEMINI RESPONSE ==========");
            System.out.println(response);
            System.out.println("=====================================");

            return objectMapper.readValue(
                    response,
                    PlannerResult.class
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}