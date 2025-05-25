package com.dev.luan.studywise.application.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dev.luan.studywise.adapters.dto.create_subject.CreateSubjectRequest;
import com.dev.luan.studywise.adapters.dto.create_subject.CreateSubjectResponse;
import com.dev.luan.studywise.adapters.entities.SubjectEntity;
import com.dev.luan.studywise.adapters.entities.UserEntity;
import com.dev.luan.studywise.adapters.entities.UserSubjectEntity;
import com.dev.luan.studywise.adapters.mappers.SubjectMapper;
import com.dev.luan.studywise.adapters.mappers.UserSubjectMapper;
import com.dev.luan.studywise.domain.model.Subject;
import com.dev.luan.studywise.domain.model.UserSubject;
import com.dev.luan.studywise.infrastructure.repositories.SubjectRepository;
import com.dev.luan.studywise.infrastructure.repositories.UserRepository;
import com.dev.luan.studywise.infrastructure.repositories.UserSubjectRepository;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {

	private final SubjectRepository subjectRepository;
	private final UserSubjectRepository userSubjectRepository;
	private final UserSubjectMapper userSubjectMapper;
	private final SubjectMapper subjectMapper;
	private final UserRepository userRepository;

	public SubjectService(SubjectRepository subjectRepository, UserSubjectRepository userSubjectRepository,
			SubjectMapper subjectMapper, UserSubjectMapper userSubjectMapper, UserRepository userRepository) {
		this.subjectRepository = subjectRepository;
		this.userSubjectRepository = userSubjectRepository;
		this.subjectMapper = subjectMapper;
		this.userSubjectMapper = userSubjectMapper;
		this.userRepository = userRepository;
	}

	/**
	 * Creates a new subject and associates it with the user who creates it.
	 * @param createSubjectRequest
	 * @param ownerId The id of the user who requested the creation of  the subject
	 * @return CreateSubjectResponse -> containing the id and name of the subject created
	 */
	@Transactional
	public CreateSubjectResponse createSubject(CreateSubjectRequest createSubjectRequest, String ownerId) {
		try {

			UserEntity userEntity = userRepository.findByKeycloakUserId(UUID.fromString(ownerId)).orElseThrow(() -> {
				throw new RuntimeException("User not found");
			});

			Subject subject = new Subject(null, createSubjectRequest.subjectName(), null);
			SubjectEntity subjectEntity = subjectMapper.toEntity(subject);
			SubjectEntity savedSubjectEntity = subjectRepository.save(subjectEntity);

			UserSubject userSubject = new UserSubject(null, userEntity.getId(), savedSubjectEntity.getId());
			UserSubjectEntity userSubjectEntity = userSubjectMapper.toEntity(userSubject);
			userSubjectRepository.save(userSubjectEntity);

			CreateSubjectResponse response = subjectMapper.toResponse(savedSubjectEntity);
			return response;

		} catch (Exception e) {
			throw new RuntimeException("Error creating subject: " + e.getMessage(), e);
		}
	}
}
