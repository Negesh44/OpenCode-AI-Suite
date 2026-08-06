package com.oaes.reviewer.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    private boolean approved;

    private String improvedCode;

    private String review;

}