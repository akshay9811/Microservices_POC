package com.quizplatform.quizapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class questionController {
	
	@PostMapping()
	public ResponseEntity<Integer>createQuestion(){
		return null;
	}
   
	@PutMapping()
	public ResponseEntity<Integer>updateQuestion(){
		return null;
		
	}
	
	@DeleteMapping()
	public ResponseEntity<Integer>deleteQuestionById(){
		return null;
	}
}
