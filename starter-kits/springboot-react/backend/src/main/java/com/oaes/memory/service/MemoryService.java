package com.oaes.memory.service;

import com.oaes.conversation.entity.Conversation;
import com.oaes.conversation.entity.Message;
import com.oaes.conversation.repository.MessageRepository;
import com.oaes.memory.model.MemoryContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemoryService {

    private final MessageRepository messageRepository;

    public MemoryContext load(UUID conversationId) {

        Conversation conversation = new Conversation();
        conversation.setId(conversationId);

        List<Message> messages =
                messageRepository.findByConversationOrderByCreatedAtAsc(
                        conversation
                );

        List<String> history =
                messages.stream()
                        .map(m -> m.getRole() + ": " + m.getContent())
                        .toList();

        return MemoryContext.builder()
                .conversationHistory(history)
                .build();
    }
}