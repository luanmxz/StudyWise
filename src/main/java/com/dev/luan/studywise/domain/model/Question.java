package com.dev.luan.studywise.domain.model;

import java.util.List;
import java.util.UUID;

public record Question(
        UUID id,
        String text,
        Long answeredTimes,
        List<AnswerAlternative> answerAlternatives,
        UUID revisionUnitId) {

    public Question {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Question Text cannot be null or empty");
        }

        if (answerAlternatives == null || answerAlternatives.isEmpty()) {
            throw new IllegalArgumentException("Answer Alternatives cannot be null or empty");
        }
    }
}