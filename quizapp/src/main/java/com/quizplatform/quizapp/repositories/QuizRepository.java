package com.quizplatform.quizapp.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizplatform.quizapp.dto.QuizRersponseDTO;
import com.quizplatform.quizapp.entity.QuizEntity;
@Repository
public interface QuizRepository extends JpaRepository<QuizEntity,UUID>{

	List<QuizEntity> findByPublishedTrue();

}
