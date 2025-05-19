package com.dev.luan.studywise.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.luan.studywise.adapters.entities.QuestionEntity;
import com.dev.luan.studywise.domain.model.Question;

@Mapper(componentModel = "spring", uses = { AnswerAlternativeMapper.class })
public interface QuestionMapper {

    @Mapping(target = "revisionUnitId", source = "revisionUnit.id")
    Question toModel(QuestionEntity entity);

    @Mapping(target = "revisionUnit.id", source = "revisionUnitId")
    QuestionEntity toEntity(Question model);
}
