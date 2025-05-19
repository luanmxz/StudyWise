package com.dev.luan.studywise.adapters.entities;

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
@Table(name = "answer_alternatives")
public class AnswerAlternativeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "answer_alternative_id", updatable = false)
    private UUID id;

    @Column(name = "answer_alternative_text", columnDefinition = "TEXT", nullable = false, updatable = false)
    private String text;

    @Column(name = "is_correct", columnDefinition = "BOOLEAN", nullable = false)
    private Boolean isCorrect;

    @Column(name = "is_checked", columnDefinition = "BOOLEAN", nullable = true)
    private Boolean isChecked;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionEntity question;

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

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

}
