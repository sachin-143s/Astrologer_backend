package com.adishakti.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adishakti.dao.ChatSessionRepository;
import com.adishakti.entity.ChatSession;

@Service
public class ChatSessionService {
    @Autowired
    private ChatSessionRepository chatSessionRepository;

    public ChatSession saveChatSession(ChatSession chatSession) {
        return chatSessionRepository.save(chatSession);
    }

    public List<ChatSession> getAllChatSessions() {
        return chatSessionRepository.findAll();
    }

    public Optional<ChatSession> getChatSessionById(Long id) {
        return chatSessionRepository.findById(id);
    }

    public void deleteChatSession(Long id) {
        chatSessionRepository.deleteById(id);
    }
}
