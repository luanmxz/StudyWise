package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.UserSubtopicEntity;
import com.dev.luan.studywise.domain.model.UserSubtopic;

@Mapper(componentModel = "spring")
public interface UserSubtopicMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "subtopicId", source = "subtopic.id")
    UserSubtopic toModel(UserSubtopicEntity entity);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "subtopic.id", source = "subtopicId")
    UserSubtopicEntity toEntity(UserSubtopic model);
}
