package com.oaes.build.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaes.build.dto.CompilerFixResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompilerFixParser {

    private final ObjectMapper objectMapper;

    public CompilerFixResponse parse(String json) {

        try {

            int start = json.indexOf('{');
            int end = json.lastIndexOf('}');

            json = json.substring(start, end + 1);

            return objectMapper.readValue(
                    json,
                    CompilerFixResponse.class
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to parse compiler fix JSON.",
                    e
            );

        }

    }

}