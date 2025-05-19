package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.UserRevisionUnitEntity;
import com.dev.luan.studywise.domain.model.UserRevisionUnit;

@Mapper(componentModel = "spring")
public interface UserRevisionUnitMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "revisionUnitId", source = "revisionUnit.id")
    UserRevisionUnit toModel(UserRevisionUnitEntity entity);

    @Mapping(target = "userAnswers", ignore = true)
    @Mapping(target = "revisionUnit.id", source = "revisionUnitId")
    @Mapping(target = "user.id", source = "userId")
    UserRevisionUnitEntity toEntity(UserRevisionUnit model);
}
