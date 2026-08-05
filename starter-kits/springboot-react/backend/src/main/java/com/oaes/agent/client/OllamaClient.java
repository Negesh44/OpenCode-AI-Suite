package com.oaes.agent.client;

import com.oaes.agent.config.OllamaProperties;
import com.oaes.agent.model.OllamaRequest;
import com.oaes.agent.model.OllamaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class OllamaClient {

    private final OllamaProperties properties;

    private final RestClient restClient = RestClient.builder().build();

    public OllamaResponse chat(OllamaRequest request) {

        return restClient.post()
                .uri(properties.getUrl())
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(OllamaResponse.class);
    }
}