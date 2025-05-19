package com.dev.luan.studywise.domain.model;

import java.util.UUID;

public record UserSubtopic(
        UUID id,
        UUID userId,
        UUID subtopicId) {

}
