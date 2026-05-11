package com.quizplatform.quizapp.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="quizzes")
public class QuizEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	private String title;
	private String description;
	private DifficultyLevel difficulty;
	private Integer maxscore;
	private Boolean published;
	private UUID createdBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<Question>questions;
}
