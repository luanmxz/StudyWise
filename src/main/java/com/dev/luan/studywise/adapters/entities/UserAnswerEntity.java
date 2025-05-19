package com.dev.luan.studywise.adapters.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_answers")
public class UserAnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_answer_id", updatable = false)
    private UUID id;

    @Column(name = "was_correct", columnDefinition = "BOOLEAN", nullable = true)
    private Boolean wasCorrect;

    @Column(name = "answered_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = true)
    private OffsetDateTime answeredAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_revision_unit_id", nullable = false)
    private UserRevisionUnitEntity userRevisionUnit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionEntity question;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "answer_alternative_id", nullable = false)
    private AnswerAlternativeEntity answerAlternative;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getWasCorrect() {
        return wasCorrect;
    }

    public void setWasCorrect(Boolean wasCorrect) {
        this.wasCorrect = wasCorrect;
    }

    public OffsetDateTime getAnsweredAt() {
        return answeredAt;
    }

    public void setAnsweredAt(OffsetDateTime answeredAt) {
        this.answeredAt = answeredAt;
    }

    public UserRevisionUnitEntity getUserRevisionUnit() {
        return userRevisionUnit;
    }

    public void setUserRevisionUnit(UserRevisionUnitEntity userRevisionUnit) {
        this.userRevisionUnit = userRevisionUnit;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public AnswerAlternativeEntity getAnswerAlternative() {
        return answerAlternative;
    }

    public void setAnswerAlternative(AnswerAlternativeEntity answerAlternative) {
        this.answerAlternative = answerAlternative;
    }

}
