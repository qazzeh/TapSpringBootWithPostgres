package com.spring.boot.postgres.demo.beans;

import java.io.Serializable;

import com.spring.boot.postgres.demo.entites.Person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class PersonBean implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String Name;
	private String Address;

	public PersonBean(Person person) {
		this.setId(person.getId());
		this.setName(person.getName());
		this.setAddress(person.getAddress());
	}

	public Person createEntity() {
		Person person = new Person();
		person.setId(this.getId());
		person.setName(this.getName());
		person.setAddress(this.getAddress());
		return person;
	}
}
