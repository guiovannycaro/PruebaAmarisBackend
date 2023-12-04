package com.amaris.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amaris.models.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeDaoImplTest {
	
	@Mock
	private EmployeeDaoImpl employeeRepositorio;
	
	
	
	@BeforeEach
	public void setUp() {
		
	}
	
 
    @DisplayName("Dado un  empleado que queremos crear "
    		+ "esperamos que cuando llamamos a agregarEmployee"
    		+ "esperamos que el usuario quede creado")
    @Test
    void agregarEmployee(Employee empl) {
    	Employee esperado = new Employee();
    	esperado.setEmployeeId(80);
     	esperado.setIdService("103.0.0.12");
    	esperado.setEmployeeName("pepito perez");
    	esperado.setEmployeeSalary("400000");
    	esperado.setEmployeeAge("40");
    	esperado.setProfileImage("uno.jpg");
    	try {
    		
    		String mensaje = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
    	Mockito.when(employeeRepositorio.agregarEmployee(esperado))
    	.thenReturn(mensaje);
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    
    @DisplayName("Dado un un empleado que queremos buscar "
    		+ "esperamos que cuando llamamos a buscarEmployeeById"
    		+ "esperamos que el id del empleado que se busca retorne toda"
    		+ "la informacion del mismo ")
    @Test
    public void buscarEmployeeById(Employee datos){
    	ArrayList<Employee> list = new ArrayList<>();
    	Employee esperado = new Employee();
    	esperado.setEmployeeId(80);
     	esperado.setIdService("103.0.0.12");
    	esperado.setEmployeeName("pepito perez");
    	esperado.setEmployeeSalary("400000");
    	esperado.setEmployeeAge("40");
    	esperado.setProfileImage("uno.jpg");
    	
    	
    	Employee e1 = new Employee();
    	e1.setEmployeeId(80);
     	e1.setIdService("103.0.0.12");
    	e1.setEmployeeName("pepito perez");
    	e1.setEmployeeSalary("400000");
    	e1.setEmployeeAge("40");
    	e1.setProfileImage("uno.jpg");
    	list.add(e1);
    	
    	try {
			Mockito.when(employeeRepositorio.buscarEmployeeById(esperado)).thenReturn(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
}
