package com.java.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "employees")
@ApiModel(description = "All details about the employee. ")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated employee id")
	@NotNull
	@EmbeddedId
	private EmployeeIdentity empid;

	@Column(name = "first_name")
	@ApiModelProperty(notes = "The employee firstname")
	@NotNull
	@Size(min = 2, message = "First name should have atleast 2 characters")
	private String empfirstName;

	@Column(name = "last_name")
	@ApiModelProperty(notes = "The employee lastname")
	@NotNull
	@Size(min = 2, message = "First name should have atleast 2 characters")
	private String emplastName;

	@Column(name = "email")
	@ApiModelProperty(notes = "The employee email")
	@Email
	@NotNull
	@NotBlank
	private String email;

	public EmployeeIdentity getEmpid() {
		return empid;
	}

	public void setEmpid(EmployeeIdentity empid) {
		this.empid = empid;
	}

	public String getEmpfirstName() {
		return empfirstName;
	}

	public void setEmpfirstName(String empfirstName) {
		this.empfirstName = empfirstName;
	}

	public String getEmplastName() {
		return emplastName;
	}

	public void setEmplastName(String emplastName) {
		this.emplastName = emplastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="fid",referencedColumnName = "id")
	List<PerformannceComments> comment = new ArrayList<>();
	
	public Employees() {

	}

	public Employees(EmployeeIdentity empid,String empfirstName, String emplastName, String email) {
		super();
		this.empid =empid;
		this.empfirstName = empfirstName;
		this.emplastName = emplastName;
		this.email = email;
	}
	
	public Employees(String empfirstName, String emplastName, String email) {
		super();
		this.empid =empid;
		this.empfirstName = empfirstName;
		this.emplastName = emplastName;
		this.email = email;
	}

}
