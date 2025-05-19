package com.dev.luan.studywise.adapters.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", updatable = false)
    private UUID id;

    @Column(name = "keycloak_user_id", unique = true)
    private UUID keycloakUserId;

    @Column(name = "can_receive_email", nullable = false, updatable = true)
    private Boolean canReceiveEmail;

    @Column(name = "can_receive_sms", nullable = false, updatable = true)
    private Boolean canReceiveSms;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = true, updatable = true)
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "generatedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RevisionUnitEntity> revisionUnitsGenerated = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getCanReceiveEmail() {
        return canReceiveEmail;
    }

    public void setCanReceiveEmail(Boolean canReceiveEmail) {
        this.canReceiveEmail = canReceiveEmail;
    }

    public Boolean getCanReceiveSms() {
        return canReceiveSms;
    }

    public void setCanReceiveSms(Boolean canReceiveSms) {
        this.canReceiveSms = canReceiveSms;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UUID getKeycloakUserId() {
        return keycloakUserId;
    }

    public void setKeycloakUserId(UUID keycloakUserId) {
        this.keycloakUserId = keycloakUserId;
    }

    public List<RevisionUnitEntity> getRevisionUnitsGenerated() {
        return revisionUnitsGenerated;
    }

    public void setRevisionUnitsGenerated(List<RevisionUnitEntity> revisionUnitsGenerated) {
        this.revisionUnitsGenerated = revisionUnitsGenerated;
    }
}
