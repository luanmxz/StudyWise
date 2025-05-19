package com.dev.luan.studywise.domain.model;

import java.util.List;
import java.util.UUID;

public record Subject(
        UUID id,
        String name,
        List<Subtopic> subtopics) {

    public Subject {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty");
        }
    }
}
