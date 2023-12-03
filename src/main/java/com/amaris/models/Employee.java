package com.amaris.models;

public class Employee {
	 int employeeId;
	  String idService;
	  String employeeName;
	  String employeeSalary;
	  String employeeAge;
	  String profileImage;
	  
	public Employee() {
	}

	public Employee(int employeeId, String idService, String employeeName, String employeeSalary, String employeeAge,
			String profileImage) {
		super();
		this.employeeId = employeeId;
		this.idService = idService;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.profileImage = profileImage;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getIdService() {
		return idService;
	}

	public void setIdService(String idService) {
		this.idService = idService;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", idService=" + idService + ", employeeName=" + employeeName
				+ ", employeeSalary=" + employeeSalary + ", employeeAge=" + employeeAge + ", profileImage=" + profileImage
				+ "]";
	}
}
