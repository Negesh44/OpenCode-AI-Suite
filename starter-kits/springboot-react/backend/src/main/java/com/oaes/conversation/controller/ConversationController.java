package com.oaes.conversation.controller;

import com.oaes.conversation.dto.ConversationRequest;
import com.oaes.conversation.dto.ConversationResponse;
import com.oaes.conversation.dto.MessageResponse;
import com.oaes.conversation.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ConversationController {

    private final ConversationService conversationService;

    @PostMapping
    public ResponseEntity<ConversationResponse> createConversation(
            @RequestBody ConversationRequest request) {

        return ResponseEntity.ok(
                conversationService.createConversation(request)
        );
    }

    @GetMapping("/{conversationId}/messages")
    public ResponseEntity<List<MessageResponse>> getMessages(
            @PathVariable String conversationId) {

        return ResponseEntity.ok(
                conversationService.getMessages(conversationId)
        );
    }
}