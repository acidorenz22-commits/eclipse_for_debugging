package com.pup.taguig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pup.taguig.dto.EmployeeRequest;
import com.pup.taguig.dto.EmployeeResponse;
import com.pup.taguig.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
	
}
