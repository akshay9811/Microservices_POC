package com.quizplatform.quizapp.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="quizzes")
public class QuizEntity {

	public QuizEntity(String title, String description, DifficultyLevel difficultyLevel, Integer timeLimitMinutes,
            boolean published, UUID createdBy, LocalDateTime createdAt) {
this.title = title;
this.description = description;
this.difficulty = difficultyLevel;
this.timeLimitInMinutes = timeLimitMinutes;
this.published = published;
this.createdBy = createdBy;
this.createdAt = createdAt;
}
	public QuizEntity() {
	    // JPA needs this
	}
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	private String title;
	private String description;
	private DifficultyLevel difficulty;
	private Integer timeLimitInMinutes;
	public Integer getTimeLimitInMinutes() {
		return timeLimitInMinutes;
	}
	public void setTimeLimitInMinutes(Integer timeLimitInMinutes) {
		this.timeLimitInMinutes = timeLimitInMinutes;
	}
	private Integer maxscore;
	private Boolean published;
	private UUID createdBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@OneToMany(mappedBy="quiz",cascade=CascadeType.ALL)
	private List<Question>questions;
	@Override
	public String toString() {
		return "QuizEntity [id=" + id + ", title=" + title + ", description=" + description + ", difficulty="
				+ difficulty + ", timeLimitInMinutes=" + timeLimitInMinutes + ", maxscore=" + maxscore + ", published="
				+ published + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", questions=" + questions + ", getTimeLimitInMinutes()=" + getTimeLimitInMinutes() + ", getId()="
				+ getId() + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getDifficulty()=" + getDifficulty() + ", getMaxscore()=" + getMaxscore() + ", getPublished()="
				+ getPublished() + ", getCreatedBy()=" + getCreatedBy() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getUpdatedAt()=" + getUpdatedAt() + ", getQuestions()=" + getQuestions() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DifficultyLevel getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(DifficultyLevel difficulty) {
		this.difficulty = difficulty;
	}
	public Integer getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(Integer maxscore) {
		this.maxscore = maxscore;
	}
	public Boolean getPublished() {
		return published;
	}
	public void setPublished(Boolean published) {
		this.published = published;
	}
	public UUID getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
