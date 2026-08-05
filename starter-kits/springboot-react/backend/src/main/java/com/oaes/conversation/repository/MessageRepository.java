package com.oaes.conversation.repository;

import com.oaes.conversation.entity.Conversation;
import com.oaes.conversation.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    List<Message> findByConversationOrderByCreatedAtAsc(
            Conversation conversation
    );

}