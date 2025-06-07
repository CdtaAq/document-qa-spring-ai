package com.example.documentqa.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QAService {

    private final EmbeddingService embeddingService;
    private final SimilaritySearchService similarityService;
    private final ChatClient chatClient;

    public QAService(EmbeddingService embeddingService,
                     SimilaritySearchService similarityService,
                     ChatClient chatClient) {
        this.embeddingService = embeddingService;
        this.similarityService = similarityService;
        this.chatClient = chatClient;
    }

    public String answerQuestion(String question) {
        float[] qEmbedding = embeddingService.getEmbedding(question);
        List<String> chunks = similarityService.findRelevantChunks(qEmbedding);
        String context = String.join("\n---\n", chunks);
        String prompt = "Answer based on the following:\n" + context + "\n\nQuestion: " + question;
        return chatClient.call(prompt);
    }
}
