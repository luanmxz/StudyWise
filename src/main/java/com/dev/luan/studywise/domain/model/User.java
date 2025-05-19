package com.dev.luan.studywise.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record User(
        UUID id,
        String name,
        String email,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        Boolean isActive,
        Boolean isBlocked,
        String phone,
        Boolean canReceiveSms,
        Boolean canReceiveEmail,
        UUID keycloakUserId) {
    public User {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
    }
}