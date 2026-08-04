package com.oaes.agent.provider;

import com.oaes.agent.dto.ChatRequest;
import com.oaes.agent.dto.ChatResponse;

public interface LlmProvider {

    ChatResponse chat(ChatRequest request);

}