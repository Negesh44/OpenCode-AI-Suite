package com.oaes.run.service;

import com.oaes.run.dto.RunResult;
import com.oaes.storage.service.WorkspaceStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RunService {

    private final WorkspaceStorageService workspaceStorageService;

    public RunResult runSpringBoot(UUID workspaceId) {

        try {

            Path root =
                    workspaceStorageService.getWorkspaceRoot(workspaceId);

            String mvn;

            if (System.getProperty("os.name").toLowerCase().contains("win")) {

                mvn =
                        "C:\\Program Files\\Apache\\Maven\\apache-maven-3.9.16\\bin\\mvn.cmd";

            } else {

                mvn = "mvn";

            }

            ProcessBuilder builder =
                    new ProcessBuilder(
                            mvn,
                            "spring-boot:run"
                    );

            builder.directory(root.toFile());

            builder.redirectErrorStream(true);

            Process process = builder.start();

            StringBuilder logs =
                    new StringBuilder();

            Thread reader =
                    new Thread(() -> {

                        try (BufferedReader br =
                                     new BufferedReader(
                                             new InputStreamReader(
                                                     process.getInputStream()))) {

                            String line;

                            while ((line = br.readLine()) != null) {

                                logs.append(line).append("\n");

                                System.out.println(line);

                            }

                        } catch (Exception ignored) {
                        }

                    });

            reader.start();

            Thread.sleep(10000);

            if (process.isAlive()) {

                return RunResult.builder()
                        .success(true)
                        .message("Application started.")
                        .logs(logs.toString())
                        .build();

            }

            return RunResult.builder()
                    .success(false)
                    .message("Application exited.")
                    .logs(logs.toString())
                    .build();

        }

        catch (Exception e) {

            return RunResult.builder()
                    .success(false)
                    .message(e.getMessage())
                    .logs("")
                    .build();

        }

    }

}