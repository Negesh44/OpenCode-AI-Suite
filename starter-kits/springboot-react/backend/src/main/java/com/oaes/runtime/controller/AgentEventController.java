package com.oaes.runtime.controller;

import com.oaes.runtime.service.AgentEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/runtime")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AgentEventController {

    private final AgentEventService eventService;

    @GetMapping(
            value = "/events",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public SseEmitter subscribe() {

        return eventService.subscribe();

    }

}