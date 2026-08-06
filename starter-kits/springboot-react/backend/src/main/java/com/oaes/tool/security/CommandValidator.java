package com.oaes.tool.security;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandValidator {

    private static final List<String> ALLOWED = List.of(
            "mvn",
            "npm",
            "npx",
            "git",
            "java",
            "javac",
            "node",
            "python",
            "python3",
            "gradle",
            "docker"
    );

    public boolean isAllowed(String command) {

        if (command == null || command.isBlank()) {
            return false;
        }

        String firstCommand =
                command.trim()
                        .split("\\s+")[0]
                        .toLowerCase();

        return ALLOWED.contains(firstCommand);
    }

}