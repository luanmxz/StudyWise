package com.dev.luan.studywise.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record UserRevisionUnit(
        UUID id,
        UUID userId,
        UUID revisionUnitId,
        OffsetDateTime startedAt,
        OffsetDateTime completedAt,
        Boolean isAllAnswersCorrect) {

    public UserRevisionUnit {
        if (userId == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (revisionUnitId == null) {
            throw new IllegalArgumentException("Revision Unit cannot be null");
        }

        if (completedAt != null && completedAt.isBefore(startedAt)) {
            throw new IllegalArgumentException("CompletedAt cannot be before StartedAt");
        }

        if (completedAt != null && isAllAnswersCorrect == null) {
            throw new IllegalArgumentException("isAllAnswersCorrect cannot be null when completedAt is not null");
        }
    }
}
