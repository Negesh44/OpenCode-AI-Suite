package com.oaes.build.prompt;

public class CompilerFixPrompt {

    private CompilerFixPrompt() {
    }

    public static String prompt(
            String compilerErrors
    ) {

        return """
You are a senior Spring Boot software engineer.

A project failed to compile.

Compiler Output:

%s

Your job is:

1. Fix ONLY the compiler errors.
2. Keep the project architecture.
3. Do NOT explain anything.
4. Return ONLY JSON.

Format:

{
  "files":[
    {
      "path":"src/main/java/...",
      "content":"..."
    }
  ]
}

Return only valid JSON.
""".formatted(compilerErrors);

    }

}