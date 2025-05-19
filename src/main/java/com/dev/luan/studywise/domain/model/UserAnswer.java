package com.dev.luan.studywise.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record UserAnswer(
        UUID id,
        UUID userRevisionUnitId,
        UUID questionId,
        UUID answerAlternativeId,
        Boolean wasCorrect,
        OffsetDateTime answeredAt) {

    public UserAnswer {
        if (userRevisionUnitId == null) {
            throw new IllegalArgumentException("User Revision Unit cannot be null");
        }
        if (questionId == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }
    }
}