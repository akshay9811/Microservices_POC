package com.quizplatform.quizapp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizplatform.quizapp.dto.QuizRequestDTO;
import com.quizplatform.quizapp.dto.QuizRersponseDTO;
import com.quizplatform.quizapp.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizAppController {
	
	private final QuizService quizService;
	
	public QuizAppController(QuizService quizService) {
		this.quizService=quizService;
		}
	
	@PostMapping("/createquiz")
	public ResponseEntity<QuizRersponseDTO> createQuiz(@RequestBody QuizRequestDTO request){
		UUID mockUserId = UUID.randomUUID();
		QuizRersponseDTO response = quizService.createQuiz(request, mockUserId);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(response);
		
		
	}
	
	@PostMapping("/{quizId}/publish")
	public ResponseEntity<QuizRersponseDTO> publishQuiz(@PathVariable UUID quizId){
		QuizRersponseDTO response = quizService.publishQuiz(quizId);
		return ResponseEntity.ok(response);
		
	}
	@GetMapping("/getpublishedquizzes")
		public ResponseEntity<List<QuizRersponseDTO>> getPublishedQuizzes(){
		return ResponseEntity.ok(quizService.getPublishedQuizzes());		
		}
	
	

}
