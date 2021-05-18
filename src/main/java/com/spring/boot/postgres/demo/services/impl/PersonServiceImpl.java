package com.spring.boot.postgres.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.postgres.demo.entites.Person;
import com.spring.boot.postgres.demo.repo.PersonRepo;
import com.spring.boot.postgres.demo.services.PersonSercices;

@Service
public class PersonServiceImpl implements PersonSercices {

	@Autowired
	PersonRepo personRep;

	@Override
	public Person savePerson(Person person) {
		return personRep.save(person);
	}
}
