package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.RevisionUnitEntity;
import com.dev.luan.studywise.domain.model.RevisionUnit;

@Mapper(componentModel = "spring", uses = { AnswerAlternativeMapper.class, QuestionMapper.class })
public interface RevisionUnitMapper {

    @Mapping(target = "generatedBy", source = "generatedBy.id")
    @Mapping(target = "subjectId", source = "subject.id")
    @Mapping(target = "subtopicId", source = "subtopic.id")
    RevisionUnit toModel(RevisionUnitEntity entity);

    @Mapping(target = "generatedBy.id", source = "generatedBy")
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "subtopic.id", source = "subtopicId")
    RevisionUnitEntity toEntity(RevisionUnit model);
}
