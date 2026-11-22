package com.pup.taguig.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pup.taguig.dto.EmployeeRequest;
import com.pup.taguig.dto.EmployeeResponse;
import com.pup.taguig.model.Employee;
import com.pup.taguig.repository.EmployeeRepository;
import com.pup.taguig.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository repository;

	private List<EmployeeRequest> employees = new ArrayList<>();

	@Override
	public List<EmployeeRequest> getAllEmployees() {
		return employees;
	}

	@Override
	public EmployeeRequest addEmployee(EmployeeRequest request) {

		// employees.add(response);

		Employee employee = new Employee(request.getName(), request.getPosition(), request.getSalary());
		repository.save(employee);
		return request;
	}

	private EmployeeResponse convertRequestToResponse(EmployeeRequest request) {
		EmployeeResponse response = new EmployeeResponse();

		response.setId(request.getId());
		response.setName(request.getName());
		response.setPosition(request.getPosition());
		response.setSalary(request.getSalary());

		return response;
	}

	@Override
	public EmployeeResponse getEmployeeById(long id) {
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee Not Found: " + id));

		EmployeeResponse response = convertEmployeeToResponse(employee);
		return response;
	}

	private EmployeeResponse convertEmployeeToResponse(Employee employee) {
		EmployeeResponse responseDTO = new EmployeeResponse();

		responseDTO.setId(employee.getId());
		responseDTO.setName(employee.getName());
		responseDTO.setPosition(employee.getPosition());
		responseDTO.setSalary(employee.getSalary());

		return responseDTO;
	}

	@Override
	public List<EmployeeResponse> employeeFilter(EmployeeRequest request) {
		
		LOGGER.debug("employeeFilter() --- Start");
		
		List <EmployeeResponse> response = new ArrayList<>();
		List <Employee> employees = null;
		
		employees = repository.findByName(request.getName());
		for (Employee employee: employees) {
			response.add(convertEmployeeToResponse(employee));
		}
		
		LOGGER.debug("employeeFilter() --- End");
		
		return response;
	}

}
