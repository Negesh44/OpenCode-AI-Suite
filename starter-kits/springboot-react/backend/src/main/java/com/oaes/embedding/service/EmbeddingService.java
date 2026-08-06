package com.oaes.embedding.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmbeddingService {

    public List<Double> embed(String text) {
        // TODO: Replace with Ollama embedding API later
        return Collections.emptyList();
    }
}