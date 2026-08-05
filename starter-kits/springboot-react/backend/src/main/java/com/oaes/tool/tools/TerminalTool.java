package com.oaes.tool.tools;

import com.oaes.storage.service.WorkspaceStorageService;
import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.enums.ToolType;
import com.oaes.tool.service.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TerminalTool implements Tool {

    private final WorkspaceStorageService workspaceStorageService;

    private static final List<String> ALLOWED_COMMANDS = List.of(
            "git",
            "mvn",
            "gradle",
            "npm",
            "node",
            "java",
            "javac",
            "dir",
            "ls"
    );

    @Override
    public ToolType getType() {
        return ToolType.TERMINAL;
    }

    @Override
    public ToolResponse execute(ToolRequest request) {

        try {

            String command = request.getContent();

            if (command == null || command.isBlank()) {

                return fail("Command cannot be empty.");

            }

            String firstWord = command.trim().split("\\s+")[0];

            if (!ALLOWED_COMMANDS.contains(firstWord)) {

                return fail("Command not allowed: " + firstWord);

            }

            Path workspace =
                    workspaceStorageService.getWorkspaceRoot(
                            request.getWorkspaceId()
                    );

            ProcessBuilder builder;

            if (System.getProperty("os.name").toLowerCase().contains("win")) {

                builder = new ProcessBuilder("cmd", "/c", command);

            } else {

                builder = new ProcessBuilder("bash", "-c", command);

            }

            builder.directory(workspace.toFile());

            builder.redirectErrorStream(true);

            Process process = builder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()
                            )
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                output.append(line).append("\n");

            }

            int exitCode = process.waitFor();

            return ToolResponse.builder()
                    .success(exitCode == 0)
                    .message("Command finished. Exit Code: " + exitCode)
                    .data(output.toString())
                    .timestamp(LocalDateTime.now())
                    .build();

        } catch (Exception e) {

            return fail(e.getMessage());

        }

    }

    private ToolResponse fail(String message) {

        return ToolResponse.builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();

    }

}