package com.dev.luan.studywise.domain.model;

import java.util.UUID;

public record UserSubject(
        UUID id,
        UUID userId,
        UUID subjectId) {

}
