package com.oaes.planner.service;

import com.oaes.planner.dto.PlannerRequest;
import com.oaes.planner.model.PlannerResult;
import com.oaes.planner.model.PlannerTask;
import com.oaes.tool.enums.ToolType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlannerService {

    public PlannerResult createPlan(PlannerRequest request) {

        PlannerTask createReadme = PlannerTask.builder()
                .step(1)
                .description("Create README file")
                .tool(ToolType.FILE)
                .action("CREATE")
                .path("README.md")
                .build();

        PlannerTask writeReadme = PlannerTask.builder()
                .step(2)
                .description("Write README content")
                .tool(ToolType.FILE)
                .action("WRITE")
                .path("README.md")
                .content("# " + request.getGoal())
                .build();

        return PlannerResult.builder()
                .goal(request.getGoal())
                .tasks(List.of(createReadme, writeReadme))
                .build();
    }
}