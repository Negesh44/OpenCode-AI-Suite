package com.oaes.tool.tools;

import com.oaes.storage.service.WorkspaceStorageService;
import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.enums.ToolType;
import com.oaes.tool.security.CommandValidator;
import com.oaes.tool.service.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TerminalTool implements Tool {

    private final WorkspaceStorageService workspaceStorageService;
    private final CommandValidator commandValidator;

    @Override
    public ToolType getType() {
        return ToolType.TERMINAL;
    }

    @Override
    public ToolResponse execute(ToolRequest request) {

        try {

            /*
             * Validate command
             */
            if (!commandValidator.isAllowed(request.getCommand())) {

                return ToolResponse.builder()
                        .success(false)
                        .message("Command is not allowed.")
                        .data(request.getCommand())
                        .timestamp(LocalDateTime.now())
                        .build();

            }

            /*
             * Resolve workspace
             */
            Path workspace =
                    workspaceStorageService.getWorkspaceRoot(
                            request.getWorkspaceId()
                    );

            boolean windows =
                    System.getProperty("os.name")
                            .toLowerCase()
                            .contains("win");

            ProcessBuilder builder;

            if (windows) {

                builder = new ProcessBuilder(
                        "cmd",
                        "/c",
                        request.getCommand()
                );

            } else {

                builder = new ProcessBuilder(
                        "bash",
                        "-c",
                        request.getCommand()
                );

            }

            builder.directory(workspace.toFile());
            builder.redirectErrorStream(true);

            Process process = builder.start();

            StringBuilder output = new StringBuilder();

            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(
                                         process.getInputStream()))) {

                String line;

                while ((line = reader.readLine()) != null) {

                    output.append(line)
                            .append("\n");

                }

            }

            int exitCode = process.waitFor();

            return ToolResponse.builder()
                    .success(exitCode == 0)
                    .message(exitCode == 0
                            ? "Command executed successfully."
                            : "Command execution failed.")
                    .data(output.toString())
                    .timestamp(LocalDateTime.now())
                    .build();

        } catch (Exception e) {

            return ToolResponse.builder()
                    .success(false)
                    .message("Terminal execution failed.")
                    .data(e.getMessage())
                    .timestamp(LocalDateTime.now())
                    .build();

        }

    }

}