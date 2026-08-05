package com.oaes.build.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildResult {

    private boolean success;

    private String logs;

    private String errors;

    private int attempts;

}