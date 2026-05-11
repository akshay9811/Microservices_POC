package com.quizplatform.quizapp.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="options")
public class Option {
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;
	private String optionText;
	private Boolean isCorrect;
	

}
