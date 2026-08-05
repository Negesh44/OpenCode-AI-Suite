package com.oaes.conversation.service;

import com.oaes.conversation.dto.ConversationRequest;
import com.oaes.conversation.dto.ConversationResponse;
import com.oaes.conversation.dto.MessageResponse;
import com.oaes.conversation.entity.Conversation;
import com.oaes.conversation.entity.Message;
import com.oaes.conversation.repository.ConversationRepository;
import com.oaes.conversation.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;

    public ConversationResponse createConversation(ConversationRequest request) {

        Conversation conversation = Conversation.builder()
                .title(request.getTitle())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        conversation = conversationRepository.save(conversation);

        return ConversationResponse.builder()
                .id(conversation.getId())
                .title(conversation.getTitle())
                .createdAt(conversation.getCreatedAt())
                .updatedAt(conversation.getUpdatedAt())
                .build();
    }

    public List<MessageResponse> getMessages(String conversationId) {

        Conversation conversation = conversationRepository.findById(
                java.util.UUID.fromString(conversationId)
        ).orElseThrow(() -> new RuntimeException("Conversation not found"));

        return messageRepository
                .findByConversationOrderByCreatedAtAsc(conversation)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private MessageResponse mapToResponse(Message message) {

        return MessageResponse.builder()
                .id(message.getId())
                .role(message.getRole())
                .content(message.getContent())
                .createdAt(message.getCreatedAt())
                .build();
    }
}