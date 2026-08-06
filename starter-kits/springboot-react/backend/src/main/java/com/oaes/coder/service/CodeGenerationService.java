package com.oaes.coder.service;

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
public class CodeGenerationService {

    private final LlmService llmService;

    public String generate(
    String filePath,
    String description,
    ProjectContext context,
    List<String> relevantFiles,
    List<ProjectFile> memory
) {
StringBuilder memoryText = new StringBuilder();

for (ProjectFile file : memory) {

    memoryText.append("File: ")
            .append(file.getPath())
            .append("\n");

    memoryText.append(file.getContent());

    memoryText.append("\n\n-----------------------------\n\n");
}
        String prompt = """
You are a senior software engineer.

You are working inside an existing Spring Boot project.

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

Generate ONLY the requested file.

Rules:
- Follow the existing architecture.
- Reuse existing classes whenever possible.
- Do not create duplicate classes.
- Return ONLY code.
- Do NOT explain.
- Do NOT use markdown.

Target File:
%s

Task:
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
        filePath,
        description
);
System.out.println("Relevant Files:");
relevantFiles.forEach(System.out::println);

System.out.println("Memory Files:");
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
    }
}