package com.sandeep.firstrest.servey;

import java.util.List;

public class Question {
	private String id;
	private String discription;
	private List<String> options;
	private String correctAns;
	
	public Question() {
		
	}
	public Question(String id, String discription, List<String> options, String correctAns) {
		super();
		this.id = id;
		this.discription = discription;
		this.options = options;
		this.correctAns = correctAns;
	}
	@Override
	public String toString() {
		return "question [id=" + id + ", discription=" + discription + ", options=" + options + ", correctAns="
				+ correctAns + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	
	
	

}
