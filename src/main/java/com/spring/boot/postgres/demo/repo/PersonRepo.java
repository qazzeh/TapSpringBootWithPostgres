package com.spring.boot.postgres.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.postgres.demo.entites.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
