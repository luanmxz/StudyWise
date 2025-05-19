package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.SubtopicEntity;
import com.dev.luan.studywise.domain.model.Subtopic;

@Mapper(componentModel = "spring")
public interface SubtopicMapper {

    @Mapping(target = "subjectId", source = "subject.id")
    Subtopic toModel(SubtopicEntity entity);

    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "revisionUnits", ignore = true)
    SubtopicEntity toEntity(Subtopic model);
}
