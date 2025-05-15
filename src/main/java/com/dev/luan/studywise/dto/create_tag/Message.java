package com.dev.luan.studywise.dto.create_tag;

import java.util.List;

public class Message {

    private String role;
    private List<Content> content;

    public Message() {
    }

    public Message(String role, List<Content> content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

}