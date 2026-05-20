package com.quizplatform.quizapp.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizplatform.quizapp.dto.QuestionRequestDTO;
import com.quizplatform.quizapp.service.QuestionService;

@RestController
@RequestMapping("/api/quizzes/{quizId}/questions")
public class QuestionController {
	
	private final QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService=questionService;
		
	}
		
	@PostMapping()
	public ResponseEntity<Void>addQuestionToQuiz(@RequestBody QuestionRequestDTO request, @PathVariable UUID quizId){
		 questionService.addQuestionToQuiz(quizId, request);
		return ResponseEntity.status(HttpStatus.CREATED)
				.build();
	}
   
	@DeleteMapping()
	public ResponseEntity<Void>deleteQuestionById(@PathVariable UUID questionId){
		questionService.deleteQuestion(questionId);
		return ResponseEntity.noContent().build();
	}
}
