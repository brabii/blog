package com.brabii.dev.blog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<Person> getPerson2() {
		Person p = new Person();
		p.setId(1);
		p.setName("rabii");
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
