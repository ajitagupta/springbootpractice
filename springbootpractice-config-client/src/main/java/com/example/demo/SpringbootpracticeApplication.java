package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@ComponentScan(basePackages = "my.own.controller"): Base packages entry is not required, that will be taken care of internally, 
												   // but some other package are present so we need to explicitly write them out.
//@Configuration
public class SpringbootpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootpracticeApplication.class, args);
	}

}
/*
 * @SpringBootApplication - it consists of 3 more annotations i.e @EnableAutoConfiguration, @ComponentScan, @SpringBootConfiguration
 * 
 * 
 * EnableAutoConfiguration : this takes care of creation of beans according to entries present in application.properties and pom.xml
 * so suppose we want to connect DB, so will add jpa and mysql depdency in pom.xml and in application.properties will add connection url.
 * EnableAutoConfiguration will create datasource for us.
 * 
 * ComponentScan : it is responsible to scan the from base packages (com.example.demo.*) to create beans
 * 
 * SpringBootConfiguration : it is also responsible to create beans, it is same as @Configuration
 * 
 * This application is a microservice implementation of a CRUD API for Book and Library
 * 
 */
