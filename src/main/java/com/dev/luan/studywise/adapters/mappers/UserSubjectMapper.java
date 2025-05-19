package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.UserSubjectEntity;
import com.dev.luan.studywise.domain.model.UserSubject;

@Mapper(componentModel = "spring")
public interface UserSubjectMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "subjectId", source = "subject.id")
    UserSubject toModel(UserSubjectEntity entity);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "subject.id", source = "subjectId")
    UserSubjectEntity toEntity(UserSubject model);
}
