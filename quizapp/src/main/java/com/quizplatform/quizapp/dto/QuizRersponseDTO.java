package com.quizplatform.quizapp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.quizplatform.quizapp.entity.DifficultyLevel;

public record QuizRersponseDTO(
		 UUID id,
		 String title,
		 DifficultyLevel difficultyLevel,
		 Boolean published,
		 LocalDateTime createdAt) {

}
