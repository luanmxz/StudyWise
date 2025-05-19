package com.dev.luan.studywise.infrastructure.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import com.dev.luan.studywise.adapters.entities.UserSubtopicEntity;

@Repository
public class UserSubtopicRepository extends JpaRepository<UserSubtopicEntity, UUID> {

}
