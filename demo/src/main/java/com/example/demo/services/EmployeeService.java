package com.example.demo.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Employee;
import com.example.demo.Entity.EmployeeTaxInfo;

/**
 * @author Rudra
 * This is a service class having methods to save employee, calculate employee's tax & cess, 
 * to get employee tax & cess for all & also based on employeeId
 */


@Service
public class EmployeeService {

	Map<Integer, Employee> employeesMap = new Hashtable<Integer, Employee>();
	
	/**
	 * @param employee
	 * @return employeeId of saved employee
	 */
	public int saveEmployee(Employee employee) {
		employeesMap.put(employee.getEmployeeId(), employee);
		return employee.getEmployeeId();
	}
	
	/**
	 * @param employeeId
	 * @return tax info of specific employee with employeeId
	 */
	public EmployeeTaxInfo getEmployeeTax(int employeeId) 
	{ 
			if(employeesMap.get(employeeId) == null)
				return null;
			else
				return  getTaxAndCessInfo(employeesMap.get(employeeId));
	}
	
	/**
	 * @return List of tax info of all employees
	 */
	public List<EmployeeTaxInfo> getAllEmployeesTax(){
		List<EmployeeTaxInfo> employeesTaxInfoList = new ArrayList<EmployeeTaxInfo>();
		Employee employee = null;
		for(Entry entry:employeesMap.entrySet()) {
			employee = (Employee)entry.getValue();
			employeesTaxInfoList.add(getTaxAndCessInfo(employee));
		}
		return employeesTaxInfoList;
	}
	
	/**
	 * @param employee
	 * @return Tax and Cess of employee
	 */
	public EmployeeTaxInfo getTaxAndCessInfo(Employee employee){
		int employeeYearlySalary = 0;
		float employeeTax = 0;
		float employeeCess = 0;
		
		employeeYearlySalary = employee.getSalary() * 12;
		
		LocalDate startLdt = LocalDate.of(2023, 03, 31);
		long diffInDays = ChronoUnit.DAYS.between(startLdt, employee.getDOJ());
		System.out.println("EmployeeService.getAllEmployeesTax() : " + diffInDays);
		
		if(diffInDays > 0) {
			employeeYearlySalary = (int)(employeeYearlySalary - (diffInDays * (employee.getSalary() / 30)));
		}
		
		if(employeeYearlySalary <= 250000) { employeeTax = 0;}
		else if(employeeYearlySalary > 250000 && employeeYearlySalary <= 500000) {employeeTax = (employeeYearlySalary * (5f/100)); }
		else if(employeeYearlySalary > 500000 && employeeYearlySalary <= 1000000) {employeeTax = (employeeYearlySalary * (10f/100)); }
		else if(employeeYearlySalary > 1000000) {employeeTax = (employeeYearlySalary * (20f/100)); }
		
		System.out.println("EmployeeService.getAllEmployeesTax() : " + (employeeYearlySalary * (20f/100)));
		
		if(employeeYearlySalary > 2500000) {employeeCess = (employeeYearlySalary * (2f/100)); }
		
		return new EmployeeTaxInfo(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getSalary(), employeeTax, employeeCess);
	}
	
}
