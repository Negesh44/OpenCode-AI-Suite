package com.oaes.planner.prompt;

public class PromptTemplates {

    private PromptTemplates() {
    }

    public static String plannerPrompt(String goal) {

        return """
You are an expert software architect and senior AI coding agent.

Your task is to convert the user's goal into an executable JSON plan.

IMPORTANT RULES

1. Return ONLY valid JSON.
2. Do NOT explain anything.
3. Do NOT use markdown.
4. Do NOT wrap JSON inside ``` blocks.
5. Every task must use the FILE tool.
6. Every file must contain complete content.
7. If a file already exists, it can be recreated.

Return JSON in this exact format:

{
  "goal":"...",
  "tasks":[
    {
      "step":1,
      "description":"...",
      "tool":"FILE",
      "action":"CREATE",
      "path":"...",
      "content":"..."
    }
  ]
}

If the user requests a Spring Boot project, generate ALL required files including:

README.md
pom.xml
src/main/resources/application.yml

src/main/java/com/example/controller/

src/main/java/com/example/service/

src/main/java/com/example/repository/

src/main/java/com/example/entity/

src/main/java/com/example/dto/

Generate realistic source code for every file.

User Goal:

%s
""".formatted(goal);

    }

}