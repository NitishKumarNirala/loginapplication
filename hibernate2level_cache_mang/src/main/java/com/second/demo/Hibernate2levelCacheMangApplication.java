package com.second.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.second")
@EnableJpaRepositories("com.second.repository")
@EntityScan("com.second.model")
@EnableAutoConfiguration
public class Hibernate2levelCacheMangApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hibernate2levelCacheMangApplication.class, args);
	}

}

