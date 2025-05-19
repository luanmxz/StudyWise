package com.dev.luan.studywise.adapters.entities;

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
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "question_id", updatable = false)
    private UUID id;

    @Column(name = "question_text", columnDefinition = "TEXT", nullable = false, updatable = false)
    private String text;

    @Column(name = "answered_times", updatable = true)
    private Long answeredTimes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "revision_unit_id", nullable = false)
    private RevisionUnitEntity revisionUnit;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerAlternativeEntity> answerAlternatives = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getAnsweredTimes() {
        return answeredTimes;
    }

    public void setAnsweredTimes(Long answeredTimes) {
        this.answeredTimes = answeredTimes;
    }

    public RevisionUnitEntity getRevisionUnit() {
        return revisionUnit;
    }

    public void setRevisionUnit(RevisionUnitEntity revisionUnit) {
        this.revisionUnit = revisionUnit;
    }

    public List<AnswerAlternativeEntity> getAnswerAlternatives() {
        return answerAlternatives;
    }

    public void setAnswerAlternatives(List<AnswerAlternativeEntity> answerAlternatives) {
        this.answerAlternatives = answerAlternatives;
    }
}
