package com.oaes.reviewer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.agent.service.LlmService;
import com.oaes.context.model.ProjectContext;
import com.oaes.memory.model.ProjectFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final LlmService llmService;

    public String review(
            String fileName,
            String code,
            ProjectContext context,
            List<String> relevantFiles,
            List<ProjectFile> memory
    ) {

        try {

            StringBuilder memoryText = new StringBuilder();

            for (ProjectFile file : memory) {

                memoryText.append("File: ")
                        .append(file.getPath())
                        .append("\n");

                memoryText.append(file.getContent());

                memoryText.append("\n\n-----------------------------\n\n");
            }

            String prompt = """
You are a senior software engineer and code reviewer.

Review the following code.

Project Name:
%s

Package:
%s

Controllers:
%s

Services:
%s

Repositories:
%s

Entities:
%s

DTOs:
%s

Configs:
%s

Existing Files:
%s

Relevant Files:
%s

Relevant Project Code:

%s

Rules:

- Fix bugs.
- Improve readability.
- Improve performance where appropriate.
- Keep compatibility with the existing project.
- Reuse existing classes whenever possible.
- Do not create duplicate code.
- Return ONLY the source code.
- Do NOT explain.
- Do NOT use markdown.

Target File:
%s

Code:

%s
""".formatted(
                    context.getProjectName(),
                    context.getPackageName(),
                    context.getControllers(),
                    context.getServices(),
                    context.getRepositories(),
                    context.getEntities(),
                    context.getDtos(),
                    context.getConfigs(),
                    context.getFiles(),
                    relevantFiles,
                    memoryText.toString(),
                    fileName,
                    code
            );
                System.out.println("Review Memory:");
memory.forEach(file -> System.out.println(file.getPath()));
            ChatResponse response =
                    llmService.chat(
                            List.of(
                                    new OllamaMessage(
                                            "user",
                                            prompt
                                    )
                            )
                    );

            return response.getResponse()
                    .replace("```java", "")
                    .replace("```", "")
                    .trim();

        } catch (Exception e) {

            e.printStackTrace();

            return code;

        }
    }
}