package com.oaes.planner.dto;

import com.oaes.planner.model.ExecutionPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlannerResponse {

    private ExecutionPlan plan;

}