package com.sandeep.firstrest.servey;

import java.util.List;

public class Servey {
	private String id;
	private String title;
	private String discription;
	private List<Question> questions;
	
	public Servey() {
		
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDiscription() {
		return discription;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public Servey(String id, String title, String discription, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Servey [id=" + id + ", title=" + title + ", discription=" + discription + ", questions=" + questions
				+ "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	

}
