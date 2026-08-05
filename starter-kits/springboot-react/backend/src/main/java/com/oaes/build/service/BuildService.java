package com.oaes.build.service;

import com.oaes.build.dto.BuildResult;
import com.oaes.storage.service.WorkspaceStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuildService {

    private final WorkspaceStorageService workspaceStorageService;

    public BuildResult mavenBuild(UUID workspaceId) throws Exception {

        Path root = workspaceStorageService.getWorkspaceRoot(workspaceId);

        String mvnCommand;

        if (System.getProperty("os.name").toLowerCase().contains("win")) {

            mvnCommand =
                    "C:\\Program Files\\Apache\\Maven\\apache-maven-3.9.16\\bin\\mvn.cmd";

        } else {

            mvnCommand = "mvn";

        }

        return run(
                root,
                mvnCommand,
                "clean",
                "install"
        );
    }

    private BuildResult run(Path directory, String... command)
            throws Exception {

        ProcessBuilder builder = new ProcessBuilder(command);

        builder.directory(directory.toFile());
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

        return BuildResult.builder()
                .success(exitCode == 0)
                .logs(output.toString())
                .errors(exitCode == 0 ? "" : output.toString())
                .attempts(1)
                .build();
    }
}