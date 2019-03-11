package com.haliri.israj.javaspringboothazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JavaSpringbootHazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringbootHazelcastApplication.class, args);
	}

}
