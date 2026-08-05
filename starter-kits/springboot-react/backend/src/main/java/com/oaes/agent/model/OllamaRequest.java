package com.oaes.agent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OllamaRequest {

    private String model;

    private List<OllamaMessage> messages;

    private boolean stream;

}