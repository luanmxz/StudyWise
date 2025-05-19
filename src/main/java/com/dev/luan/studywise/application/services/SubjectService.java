package com.dev.luan.studywise.application.services;

import org.springframework.stereotype.Service;

import com.dev.luan.studywise.adapters.dto.create_subject.CreateSubjectRequest;
import com.dev.luan.studywise.adapters.dto.create_subject.CreateSubjectResponse;
import com.dev.luan.studywise.adapters.entities.SubjectEntity;
import com.dev.luan.studywise.adapters.mappers.SubjectMapper;
import com.dev.luan.studywise.domain.model.Subject;
import com.dev.luan.studywise.infrastructure.repositories.SubjectRepository;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Transactional
    public CreateSubjectResponse createSubject(CreateSubjectRequest createSubjectRequest) {
        try {
            Subject subject = new Subject(null, createSubjectRequest.subjectName(), null);
            SubjectEntity subjectEntity = subjectMapper.toEntity(subject);

            SubjectEntity savedSubjectEntity = subjectRepository.save(subjectEntity);

            CreateSubjectResponse response = subjectMapper.toResponse(savedSubjectEntity);

            return response;
        } catch (Exception e) {
            throw new RuntimeException("Error creating subject: " + e.getMessage(), e);
        }
    }
}
