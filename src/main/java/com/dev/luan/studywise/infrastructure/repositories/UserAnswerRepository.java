package com.dev.luan.studywise.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.luan.studywise.adapters.entities.UserAnswerEntity;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswerEntity, UUID> {

}
