package com.dev.luan.studywise.adapters.dto.create_subject;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSubjectRequest(
                @NotBlank @Size(min = 3) @JsonProperty("subjectName") String subjectName) {
}
