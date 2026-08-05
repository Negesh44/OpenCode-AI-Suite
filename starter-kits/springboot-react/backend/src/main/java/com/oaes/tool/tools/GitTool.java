package com.oaes.tool.tools;

import com.oaes.storage.service.WorkspaceStorageService;
import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.enums.GitAction;
import com.oaes.tool.enums.ToolType;
import com.oaes.tool.service.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class GitTool implements Tool {

    private final WorkspaceStorageService workspaceStorageService;

    @Override
    public ToolType getType() {
        return ToolType.GIT;
    }

    @Override
    public ToolResponse execute(ToolRequest request) {

        try {

            Path workspace =
                    workspaceStorageService.getWorkspaceRoot(
                            request.getWorkspaceId()
                    );

            GitAction action =
                    GitAction.valueOf(request.getAction().toUpperCase());

            String command;

            switch (action) {

                case INIT ->
                        command = "git init";

                case STATUS ->
                        command = "git status";

                case ADD ->
                        command = "git add .";

                case COMMIT ->
                        command = "git commit -m \"" +
                                request.getContent() +
                                "\"";

                case BRANCH ->
                        command = "git branch";

                case CHECKOUT ->
                        command = "git checkout " +
                                request.getContent();

                case LOG ->
                        command = "git log --oneline";

                default ->
                        throw new RuntimeException("Unknown Git action.");

            }

            Process process =
                    new ProcessBuilder("cmd", "/c", command)
                            .directory(workspace.toFile())
                            .redirectErrorStream(true)
                            .start();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()
                            )
                    );

            StringBuilder output =
                    new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {

                output.append(line).append("\n");

            }

            process.waitFor();

            return ToolResponse.builder()
                    .success(true)
                    .message("Git command executed.")
                    .data(output.toString())
                    .timestamp(LocalDateTime.now())
                    .build();

        } catch (Exception e) {

            return ToolResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .timestamp(LocalDateTime.now())
                    .build();

        }

    }

}