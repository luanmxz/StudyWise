package com.dev.luan.studywise.adapters.dto.create_revision_unit.response;

import com.google.gson.annotations.SerializedName;

public class MessageResponse {

    private String role;
    private String content;

    @SerializedName("finish_reason")
    private String finishReason;

    public MessageResponse() {
    }

    public MessageResponse(String role, String content, String finishReason) {
        this.role = role;
        this.content = content;
        this.finishReason = finishReason;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

}
