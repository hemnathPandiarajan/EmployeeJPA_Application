package com.prodian.employees.DTO;

import lombok.Data;

@Data
public class EmployeeDTO {

	private long id;
	private String name;
	private String email;
	private String salary;
	private String mobile;
	

	public EmployeeDTO(long id,String name, String email, String salary, String mobile) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.mobile = mobile;
	}

	public EmployeeDTO() {
		
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
