package com.dev.luan.studywise.model;

import java.util.List;

public class TipQuestion {
    private Long id;
    private String title;
    private List<TipQuestionOption> options;
    private Integer correctOptions = 1;

    public TipQuestion() {
    }

    public TipQuestion(String title, List<TipQuestionOption> options) {
        this.title = title;
        this.setOptions(options);
        this.correctOptions = options.stream().filter(TipQuestionOption::getIsCorrect).toList().size();
    }

    public TipQuestion(Long id, String title, List<TipQuestionOption> options) {
        this.id = id;
        this.title = title;
        this.setOptions(options);
        this.correctOptions = options.stream().filter(TipQuestionOption::getIsCorrect).toList().size();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TipQuestionOption> getOptions() {
        return options;
    }

    public void setOptions(List<TipQuestionOption> options) {
        if (options.size() < 2) {
            throw new IllegalArgumentException("A question can have a minimum of 2 options");
        }

        if (options.size() > 3) {
            throw new IllegalArgumentException("A question can have a maximum of 3 options");
        }
        this.options = options;
    }

    public Integer getCorrectOptions() {
        return correctOptions;
    }

    public void setCorrectOptions(Integer correctOptions) {
        this.correctOptions = correctOptions;
    }
}
