package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.AnswerAlternativeEntity;
import com.dev.luan.studywise.domain.model.AnswerAlternative;

@Mapper(componentModel = "spring")
public interface AnswerAlternativeMapper {

    @Mapping(target = "questionId", source = "question.id")
    AnswerAlternative toModel(AnswerAlternativeEntity entity);

    @Mapping(target = "question.id", source = "questionId")
    AnswerAlternativeEntity toEntity(AnswerAlternative model);
}
