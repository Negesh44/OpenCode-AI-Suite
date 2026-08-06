package com.oaes.tool.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalRequest {

    private UUID workspaceId;

    private String command;

}