package com.spring.boot.postgres.demo.services;

import com.spring.boot.postgres.demo.entites.Person;

public interface PersonSercices {

	/**
	 * 
	 * @param person
	 * @return
	 */
	public Person savePerson(Person person);
}
