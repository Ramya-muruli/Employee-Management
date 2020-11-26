package com.java.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.demo.entity.EmployeeIdentity;
import com.java.demo.entity.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, EmployeeIdentity>{

}
