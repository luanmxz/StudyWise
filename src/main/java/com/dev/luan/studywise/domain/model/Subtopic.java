package com.dev.luan.studywise.domain.model;

import java.util.UUID;

public record Subtopic(
        UUID id,
        String name,
        UUID subjectId) {

    public Subtopic {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Subtopic name cannot be null or empty");
        }
    }
}
