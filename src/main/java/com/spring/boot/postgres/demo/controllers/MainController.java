package com.spring.boot.postgres.demo.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.postgres.demo.entites.Person;
import com.spring.boot.postgres.demo.services.PersonSercices;

@RestController
public class MainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Autowired
	PersonSercices personSercices;

	/**
	 * 
	 * @param httpRequest
	 * @param apiRequest
	 * @return
	 * @throws BackendException
	 * @throws IOException
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 */
	@CrossOrigin("http://localhost:8080")
	@PostMapping(value = "/save", consumes = { "application/json" })
	public @ResponseBody String checkout(HttpServletRequest httpRequest, @RequestBody Object object)
			throws IOException, NoSuchAlgorithmException, NoSuchProviderException {

		Person p = new Person();
		p.setAddress("Amman");
		p.setName("Azzeh");
		personSercices.savePerson(p);
		return "Ok";

	}

	/**
	 * 
	 * @param exception
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler({ IOException.class, NoSuchAlgorithmException.class, NoSuchProviderException.class,
			Exception.class })
	public @ResponseBody String handleBackendException() throws IOException {
		LOGGER.error("Exception While Processing your Request {}");
		return "Ok";

	}

}
