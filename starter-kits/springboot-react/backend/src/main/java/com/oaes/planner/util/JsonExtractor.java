package com.oaes.planner.util;

public class JsonExtractor {

    private JsonExtractor() {}

    public static String extract(String text) {

        if (text == null) {
            throw new IllegalArgumentException("LLM returned null.");
        }

        text = text.replace("```json", "")
                   .replace("```", "")
                   .trim();

        int start = text.indexOf('{');
        int end = text.lastIndexOf('}');

        if (start == -1 || end == -1 || start >= end) {
            throw new RuntimeException("No JSON object found.");
        }

        return text.substring(start, end + 1);

    }

}