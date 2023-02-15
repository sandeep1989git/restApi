package com.sandeep.firstrest.servey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class ServeyService {
	private static List<Servey> serveys = new ArrayList<>();
	

	static {
		
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Servey servey = new Servey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		serveys.add(servey);
	}
	

	public List<Servey> getServeys() {
		return serveys;
	}


	public Servey getServeyById(String serveyId) {
		// TODO Auto-generated method stub
		Predicate<? super Servey> predicate=l->l.getId().equalsIgnoreCase(serveyId);
		Optional<Servey> optionalServey = serveys.stream().filter(predicate).findFirst();
		if(optionalServey.isEmpty())	return null;
		return optionalServey.get(); 
				
	}


	public List<Question> getQuestions(String serveyId) {
		Servey servey = getServeyById(serveyId);
		if(servey==null) return null;
		return servey.getQuestions();
	}


	public Question getQuestionById(String serveyId, String questionId) {
		
		List<Question> questions=getQuestions(serveyId);
		if(questions==null)	return null;
		
		Predicate<? super Question> predicate=question->question.getId().equalsIgnoreCase(questionId);
		Optional<Question> optionalQuestion = questions.stream().filter(predicate).findFirst();
		if(optionalQuestion.isEmpty())
				return null;
		return optionalQuestion.get();
		
	}


	public String addQuestionByServeyId(String serveyId, Question question) {
		List<Question> questions = getQuestions(serveyId);
		
		question.setId(randomId());
		questions.add(question);
		return question.getId();
		
	}
	private String randomId() {
		SecureRandom secureRandom=new SecureRandom();
		String stringId = new BigInteger(32, secureRandom).toString();
		return stringId;
	}


	public String deleteQuestion(String serveyId, String questionId) {
		List<Question> questions = getQuestions(serveyId);
		if(questions==null) return null;
		Predicate<? super Question> predicate=question->question
									.getId().equalsIgnoreCase(questionId);
		boolean status=questions.removeIf(predicate);
		if(!status) return null;
		return questionId;
		}


	public String updateQuestion(String serveyId, String questionId, Question question) {
		List<Question> questions = getQuestions(serveyId);
		if(questions==null) return null;
		String updateStatus=deleteQuestion(serveyId,questionId);
		if(updateStatus==null)
			return null;
		questions.add(question);
		return questionId;
		
		
	}
		
	
	
}
