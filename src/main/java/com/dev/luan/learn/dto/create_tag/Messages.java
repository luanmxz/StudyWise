package com.dev.luan.learn.dto.create_tag;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Messages {
    private List<Message> messages;

    @SerializedName("max_tokens")
    private Integer maxTokens;

    private String model;

    @SerializedName("stream")
    private Boolean isStream;

    public Messages() {
    }

    public Messages(List<Message> messages, Integer maxTokens, String model, Boolean isStream) {
        this.messages = messages;
        this.maxTokens = maxTokens;
        this.model = model;
        this.isStream = isStream;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Integer getMaxTokens() {
        return this.maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getIsStream() {
        return isStream;
    }

    public void setIsStream(Boolean isStream) {
        this.isStream = isStream;
    }

}
