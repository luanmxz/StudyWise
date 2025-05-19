package com.dev.luan.studywise.domain.model;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record RevisionUnit(
        UUID id,
        String affirmation,
        String description,
        UUID subjectId,
        UUID subtopicId,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        Long displayedTimes,
        List<Question> questions,
        UUID generatedBy) {

    public RevisionUnit {
        if (affirmation == null || affirmation.isEmpty()) {
            throw new IllegalArgumentException("Affirmation cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (questions == null || questions.isEmpty()) {
            throw new IllegalArgumentException("Questions cannot be null or empty");
        }
        if (questions.size() < 2 || questions.size() > 3) {
            throw new IllegalArgumentException("Questions size cannot be LOWER than TWO OR HIGHER than THREE");
        }
        if (subjectId == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (subtopicId == null) {
            throw new IllegalArgumentException("Subtopic cannot be null");
        }
    }
}