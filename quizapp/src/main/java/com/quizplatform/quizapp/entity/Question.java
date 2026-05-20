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
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", quiz=" + quiz + ", questionText=" + questionText + ", questionType="
				+ questionType + ", marks=" + marks + ", orderIndex=" + orderIndex + ", options=" + options
				+ ", getId()=" + getId() + ", getQuiz()=" + getQuiz() + ", getQuestionText()=" + getQuestionText()
				+ ", getQuestionType()=" + getQuestionType() + ", getMarks()=" + getMarks() + ", getOrderIndex()="
				+ getOrderIndex() + ", getOptions()=" + getOptions() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public QuizEntity getQuiz() {
		return quiz;
	}
	public void setQuiz(QuizEntity quiz) {
		this.quiz = quiz;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	private Integer marks;
	private Integer orderIndex;
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	private List<Option>options;
	

}
