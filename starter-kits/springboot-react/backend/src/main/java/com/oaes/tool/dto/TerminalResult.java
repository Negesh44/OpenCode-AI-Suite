package com.oaes.tool.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalResult {

    private boolean success;

    private String output;

    private String error;

    private int exitCode;

}