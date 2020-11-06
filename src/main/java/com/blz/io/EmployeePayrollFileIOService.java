package com.blz.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static String PAYROll_FILE_NAME = "payroll-file.txt";

	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer buffer = new StringBuffer();
		employeePayrollList.forEach(emp -> {
			String empDataString = emp.toString().concat("\n");
			buffer.append(empDataString);
		});

		try {
			Files.write(Paths.get(PAYROll_FILE_NAME), buffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}