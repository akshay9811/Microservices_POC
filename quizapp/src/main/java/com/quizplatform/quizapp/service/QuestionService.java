package com.quizplatform.quizapp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.quizplatform.quizapp.dto.QuestionRequestDTO;
import com.quizplatform.quizapp.entity.Option;
import com.quizplatform.quizapp.entity.Question;
import com.quizplatform.quizapp.entity.QuizEntity;
import com.quizplatform.quizapp.exception.ResourceNotFoundException;
import com.quizplatform.quizapp.repositories.QuestionRepository;
import com.quizplatform.quizapp.repositories.QuizRepository;

@Service
public class QuestionService {
	private final QuizRepository quizRepository;
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuizRepository quizRepository,QuestionRepository questionRepository) {
		this.quizRepository = quizRepository;
		this.questionRepository = questionRepository;
	}
	
	//ConvertQuestionRequestDTO>Entity(Mapping request to Entity)
	
	public void addQuestionToQuiz(UUID quizId, QuestionRequestDTO request) {
		QuizEntity quiz = quizRepository.findById(quizId)
				.orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
		
		Question question = new Question();
		question.setQuiz(quiz);
		question.setQuestionText(request.questionText());
		question.setQuestionType(request.questionType());
		question.setMarks(request.marks());
		
		if(request.options() != null) {
			List<Option>options = request.options()
					.stream()
					.map(opt -> {
						Option option = new Option();
						option.setOptionText(opt.optionText());
						option.setIsCorrect(opt.isCorrect());
						option.setQuestion(question);
						return option;
					})
					.toList();
			question.setOptions(options);
		}
		
		questionRepository.save(question);
		
	}
	
	public void deleteQuestion(UUID questionId) {
		if(!questionRepository.existsById(questionId)) {
			throw new ResourceNotFoundException("Question not found");
		}
		questionRepository.deleteById(questionId);
	}
	
	
	

}
