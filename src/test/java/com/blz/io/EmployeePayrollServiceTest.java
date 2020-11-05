package com.blz.io;

import java.util.Arrays;
import org.junit.Test;
import org.junit.Assert;

public class EmployeePayrollServiceTest {

	@Test
	public void given2EmloyeesDetailsWrittenToFileShouldMatchWithEntries() {
		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(908, "Pallavi", 50000.0),
				new EmployeePayrollData(909, "Anni", 70000.0) };
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(com.blz.io.EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.printData(com.blz.io.EmployeePayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(com.blz.io.EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(2, entries);
	}
}
