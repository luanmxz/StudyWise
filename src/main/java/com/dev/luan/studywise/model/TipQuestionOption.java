package com.dev.luan.studywise.model;

public class TipQuestionOption {

    private Long id;
    private String title;
    private Boolean isChecked = false;
    private Boolean isCorrect = false;

    public TipQuestionOption() {
    }

    public TipQuestionOption(String title, Boolean isChecked, Boolean isCorrect) {
        this.title = title;
        this.isChecked = isChecked;
        this.isCorrect = isCorrect;
    }

    public TipQuestionOption(Long id, String title, Boolean isChecked, Boolean isCorrect) {
        this.id = id;
        this.title = title;
        this.isChecked = isChecked;
        this.isCorrect = isCorrect;
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

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
