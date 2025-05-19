package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.UserAnswerEntity;
import com.dev.luan.studywise.domain.model.UserAnswer;

@Mapper(componentModel = "spring")
public interface UserAnswerMapper {

    @Mapping(target = "userRevisionUnitId", source = "userRevisionUnit.id")
    @Mapping(target = "questionId", source = "question.id")
    @Mapping(target = "answerAlternativeId", source = "answerAlternative.id")
    UserAnswer toModel(UserAnswerEntity entity);

    @Mapping(target = "userRevisionUnit.id", source = "userRevisionUnitId")
    @Mapping(target = "question.id", source = "questionId")
    @Mapping(target = "answerAlternative.id", source = "answerAlternativeId")
    UserAnswerEntity toEntity(UserAnswer model);
}
