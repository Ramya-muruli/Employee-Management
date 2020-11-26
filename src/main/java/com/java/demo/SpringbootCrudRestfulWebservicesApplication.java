package com.java.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.demo.entity.EmployeeIdentity;
import com.java.demo.entity.Employees;
import com.java.demo.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootCrudRestfulWebservicesApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudRestfulWebservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// clear up all the tables
		employeeRepository.deleteAllInBatch();

		// employee object and insert in database
		Employees employee = new Employees(new EmployeeIdentity("7624", "NTT"), "Ramya", "gurulingappa",
				"ramya@gmail.com");
		// employeeRepository.save(employee);

	}

}
