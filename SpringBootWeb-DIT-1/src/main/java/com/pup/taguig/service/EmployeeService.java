package com.pup.taguig.service;

import java.util.List;

import com.pup.taguig.dto.EmployeeRequest;
import com.pup.taguig.dto.EmployeeResponse;

public interface EmployeeService {

	public List<EmployeeRequest> getAllEmployees();
	
	public EmployeeRequest addEmployee(EmployeeRequest request);
	
	public EmployeeResponse getEmployeeById(long Id);

	public List<EmployeeResponse> employeeFilter(EmployeeRequest request);
	
}
