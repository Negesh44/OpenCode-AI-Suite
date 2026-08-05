package com.oaes.runtime.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AgentContext {

    private UUID workspaceId;

    private UUID conversationId;

    private String goal;

    private AgentState state;

}