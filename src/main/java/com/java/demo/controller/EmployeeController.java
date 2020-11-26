package com.java.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.entity.EmployeeIdentity;
import com.java.demo.entity.Employees;
import com.java.demo.exception.ResourceNotFoundException;
import com.java.demo.repository.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/employees")
@Api(value = "Employee Management System")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepository;

	// get employees
	@ApiOperation(value = "view a list of available employees", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully retrieved results"),
			@ApiResponse(code = 401, message = "you are not authorised to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@GetMapping
	public List<Employees> getAllEmployees() {
		return this.empRepository.findAll();

	}

	// get emp by id
	@ApiOperation(value = "Get an employee by id")
	@GetMapping("/{id}")
	public Employees getEmpbyId(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable(value = "id") EmployeeIdentity empid) {
		return this.empRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("emp not found with empid :" + empid));

	}

	// create emp
	@ApiOperation(value = "Get an employee by id")
	@PostMapping
	public Employees createEmp(@ApiParam(value = "Employee object in db", required = true)@Valid @RequestBody Employees emp) {
		return this.empRepository.save(emp);
	}

	@PutMapping("/{id}")
	public Employees updateEmployee(@Valid @RequestBody Employees emp, @PathVariable("id") EmployeeIdentity empid) {
		Employees existingUser = this.empRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + empid));
		existingUser.setEmpfirstName(emp.getEmpfirstName());
		existingUser.setEmplastName(emp.getEmplastName());
		existingUser.setEmail(emp.getEmail());
		return this.empRepository.save(existingUser);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Employees> deleteUser(@PathVariable("id") EmployeeIdentity empid) {
		Employees existingUser = this.empRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + empid));
		this.empRepository.delete(existingUser);
		return ResponseEntity.ok().build();

	}

}