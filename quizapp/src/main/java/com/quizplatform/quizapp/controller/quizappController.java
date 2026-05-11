package com.quizplatform.quizapp.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizplatform.quizapp.dto.QuizRequestDTO;

@RestController
@RequestMapping("/api/quizzes")
public class quizappController {
	
	@GetMapping()
	public ResponseEntity<Integer>getquizzes(){
		return null;
		
	}
	
	@GetMapping()
	public ResponseEntity<Integer>getQuizById(){
		return null;
	}
	
	@PostMapping()
	public ResponseEntity<QuizResponseDTO>createQuiz(@RequestBody @Valid QuizRequestDTO request){
		UUID mockUserId = UUID.randomUUID();
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(quizService.createQuiz(request,mockUserId));
	}
	
	@PutMapping()
	public ResponseEntity<Integer>updatequiz(){
		return null;
	}
	
	@DeleteMapping()
	public ResponseEntity<Integer>deleteQuizById(){
		return null;
	}

}
