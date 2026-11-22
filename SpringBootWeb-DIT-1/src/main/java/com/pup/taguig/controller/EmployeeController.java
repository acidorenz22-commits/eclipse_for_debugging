package com.pup.taguig.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.dto.EmployeeRequest;
import com.pup.taguig.dto.EmployeeResponse;
import com.pup.taguig.service.EmployeeService;
import com.pup.taguig.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * public EmployeeController() { employees.add(new EmployeeRequest(1, "Renz
	 * Acido", "Developer", 50000.00)); employees.add(new EmployeeRequest(2, "John
	 * Doe", "Manager", 60000.00)); employees.add(new EmployeeRequest(3, "Jane Doe",
	 * "Project Manager", 4000.00));6y
	 * 
	 * }
	 */

	@GetMapping
	public List<EmployeeRequest> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	/**
	 * @GetMapping("/{id}") public EmployeeRequest
	 * getEmployeeById(@PathVariable("id") int id) { for (EmployeeRequest employee :
	 * employees) { if (employee.getId() == id) { return employee; } } return null;
	 * }
	 */

	@PostMapping
	public EmployeeRequest addEmployee(@RequestBody EmployeeRequest request) {
		return employeeService.addEmployee(request);
	}

	@GetMapping("/{id}")
	public EmployeeResponse getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/filter")
	public List<EmployeeResponse> employeeFilter(@RequestBody(required = false) EmployeeRequest request) {

		List<EmployeeResponse> response = new ArrayList<>();

		if (Objects.nonNull(request) && Objects.nonNull(request.getName())) {
			response = employeeService.employeeFilter(request);

		}

		return response;
	}
}