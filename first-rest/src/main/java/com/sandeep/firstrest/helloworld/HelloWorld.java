package com.sandeep.firstrest.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@RequestMapping("/hello/{name}")
	
	public HelloworldBean printHello(@PathVariable String name) {
		return new HelloworldBean("Hello World "+ name);
	}
}
