package com.oaes.runtime.service;

import com.oaes.runtime.dto.AgentProgress;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class AgentEventService {

    private final List<SseEmitter> emitters =
            new CopyOnWriteArrayList<>();

    public SseEmitter subscribe() {

        SseEmitter emitter = new SseEmitter(0L);

        emitters.add(emitter);

        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        emitter.onError(error -> emitters.remove(emitter));

        return emitter;
    }

    public void publish(AgentProgress progress) {

        for (SseEmitter emitter : emitters) {

            try {

                emitter.send(
                        SseEmitter.event()
                                .name("progress")
                                .data(progress, MediaType.APPLICATION_JSON)
                );

            } catch (Exception e) {

                emitter.complete();
                emitters.remove(emitter);

            }

        }

    }

}