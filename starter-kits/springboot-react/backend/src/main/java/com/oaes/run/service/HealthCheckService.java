package com.oaes.run.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class HealthCheckService {

    private final RestClient restClient =
            RestClient.builder().build();

    public boolean check() {

        try {

            ResponseEntity<String> response =
                    restClient.get()
                            .uri("http://localhost:8080/actuator/health")
                            .retrieve()
                            .toEntity(String.class);

            return response.getStatusCode().is2xxSuccessful();

        }

        catch (Exception e) {

            return false;

        }

    }

}