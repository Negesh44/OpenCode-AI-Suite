package com.oaes.editor.prompt;
import com.oaes.editor.dto.EditRequest;

public class EditorPrompt {

    public static String build(EditRequest request) {

        return """
You are an expert Java software engineer.

Update the following file.

Requirements:
- Keep existing code.
- Modify only what is required.
- Return ONLY the final code.
- Do not use markdown.
- Do not explain anything.

Instruction:
%s

Current File:

%s
""".formatted(
                request.getInstruction(),
                request.getCurrentCode()
        );

    }

}