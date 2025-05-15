package com.dev.luan.studywise.model;

import java.util.List;

public class Tip {

    private Long id;
    private String affirmation;
    private String description;
    private List<TipQuestion> questions;

    public Tip() {
    }

    public Tip(String affirmation, String description, List<TipQuestion> questions) {
        this.affirmation = affirmation;
        this.description = description;
        this.setQuestions(questions);
    }

    public Tip(Long id, String affirmation, String description, List<TipQuestion> questions) {
        this.id = id;
        this.affirmation = affirmation;
        this.description = description;
        this.setQuestions(questions);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAffirmation() {
        return affirmation;
    }

    public void setAffirmation(String affirmation) {
        this.affirmation = affirmation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TipQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TipQuestion> questions) {
        if (questions.size() < 2) {
            throw new IllegalArgumentException("A tip can have a minimum of 2 questions");
        }

        if (questions.size() > 3) {
            throw new IllegalArgumentException("A tip can have a maximum of 3 questions");
        }

        this.questions = questions;
    }

}
