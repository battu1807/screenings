package com.example.demo.Entity;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {
	
	@NotNull (message="employeeId should be > 0")
	@Min(1)
	private int employeeId;
	
	@NotBlank (message="firstName should not be blank")
	private String firstName;
	
	@NotBlank (message="lastName should not be blank")
	private String lastName;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message="Invalid Email")
	private String email;
	
	@NotNull (message="Invalid Phone numer, must be 10 digits - only numbers")
	@Pattern(regexp="(^$|[0-9]{10})")
	@Size(min=10,max=10)
	private String phoneNumber;
	
	@Past (message="Date should be past only")
	private LocalDate DOJ;
	
	@NotNull
	@Min(10000) 
	private int salary;
	
	public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, LocalDate dOJ,
			int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		DOJ = dOJ;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDOJ() {
		return DOJ;
	}

	public void setDOJ(LocalDate dOJ) {
		DOJ = dOJ;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", DOJ=" + DOJ + ", salary=" + salary + "]";
	}

}
