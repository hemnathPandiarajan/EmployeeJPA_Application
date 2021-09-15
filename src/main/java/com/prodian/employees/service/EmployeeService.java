package com.prodian.employees.service;

import java.util.List;
import java.util.Optional;

import com.prodian.employees.DTO.EmployeeDTO;
import com.prodian.employees.response.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse saveEmployee(EmployeeDTO employee);
	List<EmployeeDTO> getAllEmployee();
	Optional<EmployeeDTO> getEmployeeById(long id);
	EmployeeResponse updateEmployee(EmployeeDTO employeeDTO,long id);
	void deleteEmployee(long id);
}
