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
	@Override
	public String toString() {
		return "Option [id=" + id + ", question=" + question + ", optionText=" + optionText + ", isCorrect=" + isCorrect
				+ ", getId()=" + getId() + ", getQuestion()=" + getQuestion() + ", getOptionText()=" + getOptionText()
				+ ", getIsCorrect()=" + getIsCorrect() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	public Boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	

}
