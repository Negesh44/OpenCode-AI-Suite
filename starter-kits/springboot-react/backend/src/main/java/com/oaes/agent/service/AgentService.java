package com.oaes.agent.service;

import com.oaes.agent.dto.ChatRequest;
import com.oaes.agent.dto.ChatResponse;
import com.oaes.agent.model.OllamaMessage;
import com.oaes.conversation.entity.Conversation;
import com.oaes.conversation.entity.MessageRole;
import com.oaes.conversation.repository.ConversationRepository;
import com.oaes.conversation.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final LlmService llmService;
    private final ConversationRepository conversationRepository;
    private final MessageService messageService;

    public ChatResponse chat(ChatRequest request) {

        Conversation conversation = conversationRepository.findById(
                request.getConversationId()
        ).orElseThrow(() ->
                new RuntimeException("Conversation not found"));

        messageService.saveMessage(
                conversation,
                MessageRole.USER,
                request.getMessage()
        );

        List<OllamaMessage> messages =
                messageService.buildPrompt(conversation);

        ChatResponse response =
                llmService.chat(messages);

        messageService.saveMessage(
                conversation,
                MessageRole.ASSISTANT,
                response.getResponse()
        );

        return response;
    }
}