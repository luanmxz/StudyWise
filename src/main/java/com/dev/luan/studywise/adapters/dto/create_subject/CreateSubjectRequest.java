package com.dev.luan.studywise.adapters.dto.create_subject;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSubjectRequest(
        @NotBlank @Size(min = 3, message = "subjectName has a min size of 3 chars") @JsonProperty("subjectName") String subjectName) {
}
