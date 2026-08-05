package com.oaes.editor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditRequest {

    private String fileName;

    private String currentCode;

    private String instruction;

}