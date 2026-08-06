package com.oaes.reviewer.prompt;

public class ReviewPrompt {

    private ReviewPrompt() {
    }

    public static String prompt(
            String fileName,
            String code
    ) {

        return """
You are a senior software engineer.

Review the following source code.

Improve:

- Bugs
- Readability
- Naming
- Performance
- Best practices

IMPORTANT RULES

1. Return ONLY the complete updated source code.
2. Do NOT explain anything.
3. Do NOT use markdown.
4. Do NOT wrap the response in ``` blocks.
5. Preserve the package declaration.
6. Preserve imports unless changes are required.
7. Return the entire file, not just the modified lines.

File:

%s

Source Code:

%s
""".formatted(fileName, code);

    }

}