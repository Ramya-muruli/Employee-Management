package com.java.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.java.demo.entity.Employees;

@Configuration
public class EmployeeDBConfig {

	@Autowired
	private Employees dbConfig;

	@Bean
	@Profile("dev")
	public Employees dbConfigDev() {
		return new Employees("https://db-dev", "user_dev", "pass_dev");
	}

	@Bean
	@Profile("test")
	public Employees dbConfigTest() {
		return new Employees("https://db-test", "user_test", "pass_test");
	}

	@Bean
	@Profile("prod")
	public Employees dbConfigProd() {
		return new Employees("https://db-prod", "user_prod", "pass_prod");
	}

	@Bean
	public void print() {
		System.out.println("dbconfig :" + dbConfig);
	}
}
