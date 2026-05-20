package com.quizplatform.quizapp.dto;

import com.quizplatform.quizapp.entity.DifficultyLevel;

public record QuizRequestDTO(
		String title,
		String description,
		DifficultyLevel difficultyLevel,
		Integer timeLimitInMinutes
		) {

}
