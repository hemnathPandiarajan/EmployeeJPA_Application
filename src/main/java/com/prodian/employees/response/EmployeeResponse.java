package com.prodian.employees.response;

import lombok.Data;

@Data
public class EmployeeResponse {

	public String status;

	public EmployeeResponse(String status) {
		super();
		this.status = status;
	}

	public EmployeeResponse() {

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
