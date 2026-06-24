package com.project.writer.service;

import com.project.writer.entity.EmailRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Map;

@Service

public class EmailGeneratorService {

    private final WebClient webClient;


    @Value("${gemini.api.url}")
    private  String geminiApiUrl;

    @Value("${gemini.api.key}")
    private  String geminiApiKey;

    public EmailGeneratorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String generateEmailReply(EmailRequest emailRequest) {
        String prompt = buildPrompt(emailRequest);

        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {
                        Map.of("parts", new Object[] {
                                Map.of("text", prompt)
                        })
                }
        );

        // Standardized model path directly in Java code
        String targetUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + geminiApiKey;

        try {
            String response = webClient.post()
                    .uri(targetUrl) // 👈 Pass the complete URL directly as a single string
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .retry(0) // Stop background retries
                    .block();

            return extractResponseContent(response);

        } catch (WebClientResponseException e) {
            return "Google API Error (" + e.getStatusCode() + "): " + e.getResponseBodyAsString();
        } catch (Exception e) {
            return "Internal Connection Error: " + e.getMessage();
        }
    }

    private String extractResponseContent(String response) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            return root.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();


        }catch (Exception e){
            return "Error Processing Request : "+ e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a Professional email reply for the following email content.Please don't generate Subject line");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("use a ").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\n Original email : \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
