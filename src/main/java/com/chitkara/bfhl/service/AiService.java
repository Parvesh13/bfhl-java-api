package com.chitkara.bfhl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class AiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.create();

    public String askAI(String question) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + apiKey;

        Map<String, Object> body = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", question)
                        })
                }
        );

        Map response = webClient.post()
                .uri(url)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        Map candidate = (Map) ((java.util.List) response.get("candidates")).get(0);
        Map content = (Map) candidate.get("content");
        Map part = (Map) ((java.util.List) content.get("parts")).get(0);

        return part.get("text").toString().split(" ")[0];
    }
}
