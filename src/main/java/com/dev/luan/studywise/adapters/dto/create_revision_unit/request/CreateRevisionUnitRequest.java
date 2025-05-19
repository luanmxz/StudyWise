package com.dev.luan.studywise.adapters.dto.create_revision_unit.request;

import com.dev.luan.studywise.adapters.dto.SubjectDTO;
import com.dev.luan.studywise.adapters.dto.SubtopicDTO;

public record CreateRevisionUnitRequest(SubjectDTO subjectDTO, SubtopicDTO subtopicDTO) {
}
