package com.oaes.agent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OllamaResponse {

    private String model;

    private String created_at;

    private OllamaResponseMessage message;

    private boolean done;

}