package com.sandeep.firstrest.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class UserDetailCLR implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private UserDetailsRepository repository;
	
	public UserDetailCLR(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(Arrays.toString(args));
		repository.save(new UserDetail("Hare","Admin"));
		repository.save(new UserDetail("Krishna","User"));
		repository.save(new UserDetail("Ram","Admin"));
		List<UserDetail> users = repository.findAll();
		users.stream().forEach(user->logger.info(user.toString()));


		
	}
	

}
