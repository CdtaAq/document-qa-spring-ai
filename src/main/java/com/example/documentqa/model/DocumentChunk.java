package com.example.documentqa.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "document_embeddings")
public class DocumentChunk {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "vector(1536)", nullable = false)
    private float[] embedding;

    public DocumentChunk() {
        // Default constructor for JPA
    }

    public DocumentChunk(UUID id, String content, float[] embedding) {
        this.id = id;
        this.content = content;
        this.embedding = embedding;
    }

    // === Getters ===

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public float[] getEmbedding() {
        return embedding;
    }

    // === Setters ===

    public void setId(UUID id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmbedding(float[] embedding) {
        this.embedding = embedding;
    }
}
