package com.blz.io;

public class EmployeePayrollData {

	private int id;
	private String name;
	private double salary;

	public EmployeePayrollData(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
