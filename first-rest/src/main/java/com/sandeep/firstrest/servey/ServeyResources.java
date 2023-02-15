package com.sandeep.firstrest.servey;

import java.math.BigInteger;
import java.net.URI;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ServeyResources {

	private ServeyService serveyService;

	public ServeyResources(ServeyService serveyService) {
		super();
		this.serveyService = serveyService;
	}

	@RequestMapping("/serveys")
	public List<Servey> getServeys() {
		return serveyService.getServeys();
	}
	
	@RequestMapping("/serveys/{serveyId}")
	public Servey getServeysById(@PathVariable String serveyId) {
		 Servey serveyById = serveyService.getServeyById(serveyId);
		 if(serveyById==null)
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		 return serveyById;
	}
	@RequestMapping("/serveys/{serveyId}/questions")
	public List<Question> getQuestions(@PathVariable String serveyId) {
		 List<Question> questions = serveyService.getQuestions(serveyId);
		 if(questions==null)
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		 return questions;
	}
	
	@RequestMapping("/serveys/{serveyId}/questions/{questionId}")
	public Question getQuestionById(@PathVariable String serveyId,
										@PathVariable String questionId) {
		 Question question = serveyService.getQuestionById(serveyId, questionId);
		 if(question==null)
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		 return question;
	}
	@RequestMapping(value="/serveys/{serveyId}/questions",method=RequestMethod.POST)
	public ResponseEntity<Object> addQuestionByServeyId(@PathVariable String serveyId, 
				@RequestBody Question question) {
		serveyService.addQuestionByServeyId(serveyId,question);
		String questionId=question.getId();
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{questionId}").buildAndExpand(questionId).toUri() ;
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/serveys/{serveyId}/questions/{questionId}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteQuestion(@PathVariable String serveyId, 
				@PathVariable String questionId) {
		serveyService.deleteQuestion(serveyId,questionId);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/serveys/{serveyId}/questions/{questionId}",method=RequestMethod.PUT)
	public ResponseEntity<Object> updateQuestionByServeyId(@PathVariable String serveyId, 
				@PathVariable String questionId, @RequestBody Question question) {
		String updateStatus = serveyService.updateQuestion(serveyId,questionId,question);
		if(updateStatus==null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.accepted().build();
	}


	
	
	
}
