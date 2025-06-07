package com.example.documentqa.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimilaritySearchService {

    private final JdbcTemplate jdbcTemplate;

    public SimilaritySearchService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> findRelevantChunks(float[] embedding) {
        String sql = "SELECT content FROM document_embeddings ORDER BY embedding <-> ? LIMIT 5";
        return jdbcTemplate.queryForList(sql, new Object[]{embedding}, String.class);
    }
}
