package com.quizplatform.quizapp.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	@ManyToOne
	@JoinColumn(name="quiz_id")
	private QuizEntity quiz;
	private String questionText;
	@Enumerated(EnumType.STRING)
	private QuestionType questionType;
	private Integer marks;
	private Integer orderIndex;
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	private List<Option>options;
	

}
