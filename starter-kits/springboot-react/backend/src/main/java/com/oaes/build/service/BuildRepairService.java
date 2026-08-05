package com.oaes.build.service;

import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.agent.service.LlmService;
import com.oaes.build.dto.BuildResult;
import com.oaes.build.dto.CompilerFixResponse;
import com.oaes.build.prompt.CompilerFixPrompt;
import com.oaes.build.util.CompilerFixParser;
import com.oaes.runtime.dto.AgentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildRepairService {

    private static final int MAX_RETRIES = 3;

    private final BuildService buildService;
    private final LlmService llmService;
    private final CompilerFixParser compilerFixParser;
    private final FileRewriteService fileRewriteService;

    public BuildResult repair(AgentRequest request) {

        BuildResult lastResult = null;

        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {

            System.out.println();
            System.out.println("=======================================");
            System.out.println("BUILD ATTEMPT : " + attempt);
            System.out.println("=======================================");

            try {

                lastResult = buildService.mavenBuild(
                        request.getWorkspaceId()
                );

                if (lastResult.isSuccess()) {

                    System.out.println("BUILD SUCCESS");

                    return lastResult;
                }

                System.out.println("BUILD FAILED");
                System.out.println(lastResult.getErrors());

                ChatResponse response =
                        llmService.chat(
                                List.of(
                                        new OllamaMessage(
                                                "user",
                                                CompilerFixPrompt.prompt(
                                                        lastResult.getErrors()
                                                )
                                        )
                                )
                        );

                System.out.println();
                System.out.println("========== AI FIX ==========");
                System.out.println(response.getResponse());
                System.out.println("============================");

                CompilerFixResponse fix =
                        compilerFixParser.parse(
                                response.getResponse()
                        );

                fileRewriteService.rewrite(
                        request.getWorkspaceId(),
                        fix.getFiles()
                );

                System.out.println("Files updated successfully.");

            } catch (Exception e) {

                e.printStackTrace();

                return BuildResult.builder()
                        .success(false)
                        .logs("")
                        .errors(e.getMessage())
                        .build();
            }

        }

        return lastResult;
    }

}