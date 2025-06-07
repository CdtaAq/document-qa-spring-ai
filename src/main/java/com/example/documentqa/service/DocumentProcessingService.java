package com.example.documentqa.service;

import com.example.documentqa.model.DocumentChunk;
import com.example.documentqa.repository.DocumentChunkRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DocumentProcessingService {

    private final EmbeddingService embeddingService;
    private final DocumentChunkRepository repository;

    public DocumentProcessingService(EmbeddingService embeddingService,
                                     DocumentChunkRepository repository) {
        this.embeddingService = embeddingService;
        this.repository = repository;
    }

    public void processDocument(String content) {
        List<String> chunks = splitIntoChunks(content);

        for (String chunk : chunks) {
            float[] embedding = embeddingService.getEmbedding(chunk);
            DocumentChunk doc = new DocumentChunk(UUID.randomUUID(), chunk, embedding);
            repository.save(doc);
        }
    }

    private List<String> splitIntoChunks(String text) {
        int maxLen = 500;
        List<String> chunks = new ArrayList<>();
        for (int i = 0; i < text.length(); i += maxLen) {
            chunks.add(text.substring(i, Math.min(i + maxLen, text.length())));
        }
        return chunks;
    }
}
