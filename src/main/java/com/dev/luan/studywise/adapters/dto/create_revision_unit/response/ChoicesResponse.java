package com.dev.luan.studywise.adapters.dto.create_revision_unit.response;

public class ChoicesResponse {
    private Integer index;
    private MessageResponse message;

    public ChoicesResponse() {
    }

    public ChoicesResponse(Integer index, MessageResponse message) {
        this.index = index;
        this.message = message;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public MessageResponse getMessage() {
        return message;
    }

    public void setMessage(MessageResponse message) {
        this.message = message;
    }

}
