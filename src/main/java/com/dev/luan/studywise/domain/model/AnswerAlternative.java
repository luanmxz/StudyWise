package com.dev.luan.studywise.domain.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record AnswerAlternative(
        UUID id,
        String text,
        @JsonIgnore Boolean isCorrect,
        Boolean isChecked,
        UUID questionId) {

    public AnswerAlternative {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Answer Alternative Text cannot be null or empty");
        }
    }
}
