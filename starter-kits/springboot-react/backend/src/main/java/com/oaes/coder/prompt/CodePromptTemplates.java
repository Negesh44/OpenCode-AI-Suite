package com.oaes.coder.prompt;

public class CodePromptTemplates {

    private CodePromptTemplates() {
    }

    public static String generateJavaClass(
            String className,
            String description
    ) {

        return """
You are an expert Java Spring Boot developer.

Generate ONLY Java source code.

Do not use markdown.

Class name:

%s

Description:

%s
""".formatted(className, description);

    }

}