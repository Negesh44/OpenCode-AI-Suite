package com.oaes.conversation.service;

import com.oaes.agent.model.OllamaMessage;
import com.oaes.conversation.entity.Conversation;
import com.oaes.conversation.entity.Message;
import com.oaes.conversation.entity.MessageRole;
import com.oaes.conversation.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message saveMessage(
            Conversation conversation,
            MessageRole role,
            String content
    ) {

        Message message = Message.builder()
                .conversation(conversation)
                .role(role)
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();

        return messageRepository.save(message);
    }

    public List<Message> getConversationMessages(Conversation conversation) {
        return messageRepository.findByConversationOrderByCreatedAtAsc(conversation);
    }

    public List<OllamaMessage> buildPrompt(Conversation conversation) {

        return getConversationMessages(conversation)
                .stream()
                .map(message -> new OllamaMessage(
                        message.getRole().name().toLowerCase(),
                        message.getContent()
                ))
                .toList();
    }
}