package com.quizplatform.quizapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.quizplatform.quizapp.exception.ResourceNotFoundException;
import com.quizplatform.quizapp.dto.QuizRequestDTO;
import com.quizplatform.quizapp.dto.QuizRersponseDTO;
import com.quizplatform.quizapp.entity.QuizEntity;
import com.quizplatform.quizapp.repositories.QuizRepository;

@Service
public class QuizService {
	
	private final QuizRepository quizRepository;
    
	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	
	public QuizRersponseDTO createQuiz(QuizRequestDTO request, UUID userId) {
        // Step 1: Convert request DTO → Entity
        QuizEntity quiz = new QuizEntity(
            request.title(),
            request.description(),
            request.difficultyLevel(),
            request.timeLimitInMinutes(),
            false,
            userId,
            LocalDateTime.now()
        );
				
		//save Entity
		quizRepository.save(quiz);
		
		//Convert Entity to responseDTO
		 return new QuizRersponseDTO(
	            quiz.getId(),
	            quiz.getTitle(),
	            quiz.getDifficulty(),
	            quiz.getPublished(),
	            quiz.getCreatedAt()
	        );
	}
	
	public List<QuizRersponseDTO> getPublishedQuizzes() {
	    return quizRepository.findByPublishedTrue()
	            .stream()
	            .map(quiz -> new QuizRersponseDTO(
	                    quiz.getId(),               // entity getter
	                    quiz.getTitle(),
	                    quiz.getDifficulty(),       // maps to difficultyLevel in DTO
	                    quiz.getPublished(),
	                    quiz.getCreatedAt()
	            ))
	            .toList();
	}
	
	public QuizRersponseDTO publishQuiz(UUID quizId) {
		//fetchQuiz
		
		QuizEntity quiz = quizRepository.findById(quizId)
				.orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
		
		//Optional check(good practise)
        if(Boolean.TRUE.equals(getPublishedQuizzes())) {
        	throw new IllegalStateException("Quiz is already published");
        }
        
        //update fields
        quiz.setPublished(true);
        quiz.setUpdatedAt(LocalDateTime.now());
        
        //save
        quizRepository.save(quiz);
        
        //Convert To DTO 
        return new QuizRersponseDTO( 
        	quiz.getId(),
        	quiz.getTitle(),
        	quiz.getDifficulty(),
        	quiz.getPublished(),
        	quiz.getCreatedAt()
        	);
        
        		
		
	
	}
	
}
	

	           
			  
		
	
	
