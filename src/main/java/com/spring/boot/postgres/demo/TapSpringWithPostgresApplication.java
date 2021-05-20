package com.spring.boot.postgres.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TapSpringWithPostgresApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(TapSpringWithPostgresApplication.class).profiles("local", "dev", "prod").run(args);
	}

}
