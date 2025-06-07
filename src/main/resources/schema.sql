-- Enable pgvector extension
CREATE EXTENSION IF NOT EXISTS vector;

-- Table to store document chunks and embeddings
CREATE TABLE document_embeddings (
    id UUID PRIMARY KEY,
    content TEXT,
    embedding VECTOR(1536)
);
