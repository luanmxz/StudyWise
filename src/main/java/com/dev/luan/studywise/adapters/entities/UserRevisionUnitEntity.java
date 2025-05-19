package com.dev.luan.studywise.adapters.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_revision_units")
public class UserRevisionUnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_revision_unit_id", updatable = false)
    private UUID id;

    @Column(name = "started_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    private OffsetDateTime startedAt;

    @Column(name = "completed_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = true, updatable = true)
    private OffsetDateTime completedAt;

    @Column(name = "is_all_answers_correct", nullable = true, updatable = true)
    private Boolean isAllAnswersCorrect;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "revision_unit_id", nullable = false, updatable = false)
    private RevisionUnitEntity revisionUnit;

    @OneToMany(mappedBy = "userRevisionUnit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAnswerEntity> userAnswers = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OffsetDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(OffsetDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public Boolean getIsAllAnswersCorrect() {
        return isAllAnswersCorrect;
    }

    public void setIsAllAnswersCorrect(Boolean isAllAnswersCorrect) {
        this.isAllAnswersCorrect = isAllAnswersCorrect;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RevisionUnitEntity getRevisionUnit() {
        return revisionUnit;
    }

    public void setRevisionUnit(RevisionUnitEntity revisionUnit) {
        this.revisionUnit = revisionUnit;
    }

    public List<UserAnswerEntity> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswerEntity> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
