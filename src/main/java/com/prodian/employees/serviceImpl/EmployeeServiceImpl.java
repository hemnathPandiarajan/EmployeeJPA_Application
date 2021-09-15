package com.prodian.employees.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prodian.employees.DTO.EmployeeDTO;
import com.prodian.employees.entity.Employee;
import com.prodian.employees.exception.ResourceNotFoundException;
import com.prodian.employees.repository.EmployeeRepository;
import com.prodian.employees.response.EmployeeResponse;
import com.prodian.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	public EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeResponse saveEmployee(EmployeeDTO employee) {
		Employee addEmp = new Employee();
		EmployeeResponse addEmployeeResponse = new EmployeeResponse();
		addEmp.setName(employee.getName());
		addEmp.setEmail(employee.getEmail());
		addEmp.setSalary(employee.getSalary());
		addEmp.setMobile(employee.getMobile());
		addEmp = employeeRepository.save(addEmp);
		if (addEmp != null) {
			addEmployeeResponse.setStatus("Success");
		} else {
			addEmployeeResponse.setStatus("Failed");
		}
		return addEmployeeResponse;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> employeeDtoList = new ArrayList();
		List<Employee> employeeList = employeeRepository.findAll();
		for (Employee employee : employeeList) {
			employeeDtoList.add(new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail(),
					employee.getSalary(), employee.getMobile()));
		}
		return employeeDtoList;
	}

	@Override
	public Optional<EmployeeDTO> getEmployeeById(long id) {
		Optional<Employee> employeeById = employeeRepository.findById(id);
		Employee emp = employeeById.get();
		return Optional
				.of(new EmployeeDTO(emp.getId(), emp.getName(), emp.getEmail(), emp.getSalary(), emp.getMobile()));
	}

	@Override
	public EmployeeResponse updateEmployee(EmployeeDTO employeeDTO, long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employee.setName(employeeDTO.getName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setSalary(employeeDTO.getSalary());
		employee.setMobile(employeeDTO.getMobile());
		employee = employeeRepository.save(employee);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (employee != null) {
			employeeResponse.setStatus("Successfully inserted");
		} else {
			employeeResponse.setStatus("Failed to insert");
		}
		return employeeResponse;
	}

	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);
	}

}
