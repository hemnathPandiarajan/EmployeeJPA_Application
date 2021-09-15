package com.prodian.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodian.employees.entity.Employee;

import lombok.Data;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
