package com.amaris.dao;

import java.sql.SQLException;
import java.util.List;

import com.amaris.models.Employee;
public  interface  EmployeeDao {
	String consumeService();
	String agregarEmployee(Employee empl) throws SQLException ;
    List<Employee> returnAllEmployees() throws SQLException;
    String updateEmployee(Employee empl) throws SQLException ;
    void dropEmployee(Integer idEmployee);
    List<Employee> buscarEmployeeById(Employee datos) throws SQLException;
    public String  insertUser(int userId,int id, String title, String body)  throws Exception;
    public String  insertEmployee(int id,String employee_name,int employee_salary,int employee_age,String profile_image)  throws Exception;
    public double calcularSalario(Employee empl);
}
