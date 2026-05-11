package com.quizplatform.quizapp.dto;

import java.util.List;

import com.quizplatform.quizapp.entity.QuestionType;

public record QuestionRequestDTO(
		String questionText,
		QuestionType questionType,
		Integer marks,
		List<OptionRequestDTO>options) {

}
