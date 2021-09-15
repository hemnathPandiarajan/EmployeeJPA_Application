package com.prodian.employees.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodian.employees.DTO.EmployeeDTO;
import com.prodian.employees.entity.Employee;
import com.prodian.employees.response.EmployeeResponse;
import com.prodian.employees.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping()
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployee();
	}

	@PostMapping("addEmployee")
	public EmployeeResponse saveEmployee(@RequestBody EmployeeDTO employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(value = "id") long id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id).get());
	}

	@PutMapping("/{id}")
	public EmployeeResponse updateEmployee(@PathVariable(value = "id") long id, @RequestBody EmployeeDTO employeeDTO) {
		return employeeService.updateEmployee(employeeDTO, id);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}
}
