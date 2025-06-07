# document-qa-spring-ai


# Document QA System (Spring Boot + Spring AI + pgvector)

A Question Answering system that:
- Extracts text from documents
- Generates embeddings using OpenAI (via Spring AI)
- Stores vector data in PostgreSQL with pgvector
- Performs similarity search
- Answers user questions using GPT-4

## Setup

### PostgreSQL + pgvector
```sql
CREATE EXTENSION IF NOT EXISTS vector;
CREATE TABLE document_embeddings (
  id UUID PRIMARY KEY,
  content TEXT,
  embedding VECTOR(1536)
);
