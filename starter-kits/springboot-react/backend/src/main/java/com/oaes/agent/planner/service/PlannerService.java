package com.oaes.agent.planner.service;

import com.oaes.agent.planner.dto.PlannerRequest;
import com.oaes.agent.planner.model.ExecutionPlan;
import com.oaes.agent.planner.model.PlanStep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlannerService {

    public ExecutionPlan createPlan(PlannerRequest request) {

        return ExecutionPlan.builder()
                .goal(request.getGoal())
                .steps(List.of(

                        PlanStep.builder()
                                .step(1)
                                .title("Understand Request")
                                .description("Analyze the user's goal.")
                                .build(),

                        PlanStep.builder()
                                .step(2)
                                .title("Break Into Tasks")
                                .description("Divide the goal into executable tasks.")
                                .build(),

                        PlanStep.builder()
                                .step(3)
                                .title("Execute")
                                .description("Send tasks to the execution engine.")
                                .build()

                ))
                .build();

    }

}