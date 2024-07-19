package com.example.demo.Entity;

public class EmployeeTaxInfo {

	private int employeeId;
	private String firstName;
	private String lastName;
	private int salary;
	private float taxAmount;
	private float cessAmount;
	
	public EmployeeTaxInfo(int employeeId, String firstName, String lastName, int salary, float taxAmount,
			float cessAmount) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public float getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public float getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(float cessAmount) {
		this.cessAmount = cessAmount;
	}

	@Override
	public String toString() {
		return "EmployeeTaxInfo [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}

}
