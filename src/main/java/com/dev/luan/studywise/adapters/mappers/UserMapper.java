package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.UserEntity;
import com.dev.luan.studywise.domain.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "isBlocked", ignore = true)
    User toModel(UserEntity entity);

    @Mapping(target = "revisionUnitsGenerated", ignore = true)
    UserEntity toEntity(User model);
}
