package com.ollama.chatbot.service;

import com.ollama.chatbot.response.LlamaResponse;

public interface LlamaAiService {

    LlamaResponse generateMessage(String prompt);
}
