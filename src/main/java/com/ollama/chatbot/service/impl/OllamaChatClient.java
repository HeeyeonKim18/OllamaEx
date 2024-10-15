package com.ollama.chatbot.service.impl;

import com.ollama.chatbot.service.ChatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component("customOllamaChatClient")
@RequiredArgsConstructor
public class OllamaChatClient implements ChatClient {

    private final RestTemplate restTemplate;

    @Value("${spring.ai.ollama.base-url}")
    private String baseUrl;

    @Value("${spring.ai.ollama.model}")
    private String model;

    @Override
    public String generate(String prompt) {
        String url = String.format("%s/generate", baseUrl);
        Map<String, Object> request = new HashMap<>();
        request.put("model", model);
        request.put("prompt", prompt);
        request.put("stream", false);

        try {
            System.out.println("URL: " + url);
            System.out.println("Request: " + request);

            return restTemplate.postForObject(url, request, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
