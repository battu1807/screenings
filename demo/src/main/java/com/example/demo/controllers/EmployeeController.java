package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.EmployeeTaxInfo;
import com.example.demo.services.EmployeeService;

import jakarta.validation.Valid;


/**
 * @author Rudra
 * This is controller class receives request from clients and process the request by calling the respective services methods
 * to save employee data, to get single employee tax info and to get all employees tax info
 */

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee storeEmployee(@RequestBody @Valid Employee employee){

		System.out.println("EmployeeController.storeEmployee()----");
//		Employee employee = new Employee(001, "Rudra","Satya","rudra@gmail.com",1234, LocalDate.of(2022, 1, 13),10000);
		employeeService.saveEmployee(employee);
		return employee;
	}

	@GetMapping("/tax/{employeeId}")
	public ResponseEntity<Object> getEmployeeTax(@PathVariable int employeeId){

		System.out.println("EmployeeController.getEmployeeTax()----");
		EmployeeTaxInfo employeeTaxInfo = employeeService.getEmployeeTax(employeeId);
		if(employeeTaxInfo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found with employeeId : " + employeeId);
		}
		else
			return new ResponseEntity<>(employeeService.getEmployeeTax(employeeId), HttpStatus.OK);
	}
	
	@GetMapping("/tax")
	public List<EmployeeTaxInfo> getAllEmployeesTax(){

		System.out.println("EmployeeController.getAllEmployeesTax()----");
		return employeeService.getAllEmployeesTax();
	}
}
