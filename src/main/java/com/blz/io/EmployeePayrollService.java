package com.blz.io;

import java.util.*;

public class EmployeePayrollService {

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		super();
		this.employeePayrollList = employeePayrollList;
	}

	public EmployeePayrollService() {
		super();
	}

	private void readEmployeePayrollData(Scanner sc) {
		System.out.println("Enter Id : ");
		int id = sc.nextInt();
		System.out.println("Enter Name : ");
		String name = sc.next();
		System.out.println("Enter Salary : ");
		double salary = sc.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(com.blz.io.EmployeePayrollService.IOService.CONSOLE_IO))
			System.out.println("Employee Payroll to Details : " + employeePayrollList);
		if (ioService.equals(com.blz.io.EmployeePayrollService.IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);

	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner sc = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(sc);
		employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
	}
}
