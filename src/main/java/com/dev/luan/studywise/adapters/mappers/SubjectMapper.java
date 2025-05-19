package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.dto.create_subject.CreateSubjectResponse;
import com.dev.luan.studywise.adapters.entities.SubjectEntity;
import com.dev.luan.studywise.domain.model.Subject;

@Mapper(componentModel = "spring", uses = { SubtopicMapper.class })
public interface SubjectMapper {

    @Mapping(target = "subtopics", source = "subtopics")
    Subject toModel(SubjectEntity entity);

    @Mapping(target = "subtopics", ignore = true)
    @Mapping(target = "revisionUnits", ignore = true)
    SubjectEntity toEntity(Subject model);

    CreateSubjectResponse toResponse(SubjectEntity entity);
}
