package com.oaes.runtime.service;

import com.oaes.runtime.dto.AgentProgress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentProgressService {

    private final AgentEventService eventService;

    public void publish(
            String stage,
            String message,
            int percentage
    ) {

        AgentProgress progress =
                AgentProgress.builder()
                        .stage(stage)
                        .message(message)
                        .percentage(percentage)
                        .build();

        System.out.println(progress);

        eventService.publish(progress);

    }

}