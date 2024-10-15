package com.ollama.chatbot.service.impl;


import com.ollama.chatbot.response.LlamaResponse;
import com.ollama.chatbot.service.LlamaAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LlamaAiServiceImpl implements LlamaAiService {

    private final OllamaChatClient chatClient;

    @Override
    public LlamaResponse generateMessage(String prompt) {
        final String llamaMessage = chatClient.generate(prompt);
        return new LlamaResponse().setMessage(llamaMessage);
    }
}
