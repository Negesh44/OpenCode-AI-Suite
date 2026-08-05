package com.oaes.planner.dto;

import com.oaes.planner.model.PlannerResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlannerResponse {

    private PlannerResult plan;

}