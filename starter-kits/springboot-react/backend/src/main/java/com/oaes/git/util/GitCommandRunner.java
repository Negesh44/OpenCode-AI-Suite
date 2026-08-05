package com.oaes.git.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

@Component
public class GitCommandRunner {

    public String run(Path directory, String... command)
            throws Exception {

        Process process =
                new ProcessBuilder(command)
                        .directory(directory.toFile())
                        .redirectErrorStream(true)
                        .start();

        StringBuilder output =
                new StringBuilder();

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

        process.waitFor();

        return output.toString();

    }

}