package com.oaes.agent.provider;

import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;

import java.util.List;

public interface LlmProvider {

    ChatResponse chat(List<OllamaMessage> messages);

}