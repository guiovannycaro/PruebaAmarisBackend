package com.amaris.controller;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import com.amaris.dao.EmployeeDaoImpl;
import com.amaris.models.Employee;
import com.amaris.util.ExceptionUtil;

@RestController
@RequestMapping("/amaris/Servicio/Employee/")
@Api(value = "Consulta Empleados")
public class EmployeeController {

	protected final Log log = LogFactory.getLog(this.getClass());
	
	@GetMapping(value = "/LoadDataBase")
	@ApiOperation(value = "Consume y carga la informacion del servicio en la base de datos", response = Employee.class, notes = "Ingresa toda la informacion proveniente del servicio a la base de datos")
	@ApiResponses({
			@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Employee.class),
			@ApiResponse(code = 400, message = "Bad Request.No existen Datos En el servico", response = Employee.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Employee.class),
			@ApiResponse(code = 401, message = "Acceso denegado", response = Employee.class) })
	
	public String ChargeInformation() {
		
		ArrayList<Employee> informationEmployee = new ArrayList<>();
		try {
		
			
			EmployeeDaoImpl datos = new EmployeeDaoImpl();
			String rpt1 =	datos.consumeService();
		String rpt2 =	datos.consumeService2();
		     
			return "respuesta del consumo servicio dos " + "\n" + rpt2 + "\n" +  " respuesta del consumo uno" + "\n" + rpt1;
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return null;
		}
	}
	
	@PostMapping(value = "/addEmployee" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta agregar Employees", response = Employee.class, notes = "add employee ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Employee.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Employee Asociados a esa cedula(String)", response = Employee.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Employee.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Employee.class),
		@ApiResponse(code = 401, message = "No existen Employee Asociados a esa cedula", response = Employee.class),
		@ApiResponse(code = 404, message = "No existen Employee Asociados a esa cedula", response = Employee.class), })
	public String agregarClientes(
			@RequestBody Employee data) {
		try {
			EmployeeDaoImpl datos = new EmployeeDaoImpl();
			return datos.agregarEmployee(data);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue agregado De Manera Correcta\"}";
		}
	}
	
	@PostMapping(value = "/editEmployee" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Employees", response = Employee.class, notes = "edit employee ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Employee.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Employee Asociados a esa cedula(String)", response = Employee.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Employee.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Employee.class),
		@ApiResponse(code = 401, message = "No existen Employee Asociados a esa cedula", response = Employee.class),
		@ApiResponse(code = 404, message = "No existen Employee Asociados a esa cedula", response = Employee.class), })
	public String editarClientes(
			@RequestBody Employee data) {
		try {
			EmployeeDaoImpl datos = new EmployeeDaoImpl();
			return datos.updateEmployee(data);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}
	
	@GetMapping(value = "/listEmployee")
	@ApiOperation(value = "Consume y carga la informacion del servicio en la base de datos", response = Employee.class, notes = "Ingresa toda la informacion proveniente del servicio a la base de datos")
	@ApiResponses({
			@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Employee.class),
			@ApiResponse(code = 400, message = "Bad Request.No existen Datos En el servico", response = Employee.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Employee.class),
			@ApiResponse(code = 401, message = "Acceso denegado", response = Employee.class) })
	
	public List<Employee> listEmployee() {
		
		ArrayList<Employee> informationEmployee = new ArrayList<>();
		try {
		
			
			EmployeeDaoImpl datos = new EmployeeDaoImpl();
			return datos.returnAllEmployees();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}
	
	@GetMapping(value = "/listEmployeeById" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consume y carga la informacion del servicio en la base de datos", response = Employee.class, notes = "Ingresa toda la informacion proveniente del servicio a la base de datos")
	@ApiResponses({
			@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Employee.class),
			@ApiResponse(code = 400, message = "Bad Request.No existen Datos En el servico", response = Employee.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Employee.class),
			@ApiResponse(code = 401, message = "Acceso denegado", response = Employee.class) })
	
	public List<Employee> listEmployeeById(@RequestBody Employee data) {
		
		ArrayList<Employee> informationEmployee = new ArrayList<>();
		try {
		
			
			EmployeeDaoImpl datos = new EmployeeDaoImpl();
			return datos.buscarEmployeeById(data);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}
	
	@GetMapping(value = "/employeeSalary" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consume y carga la informacion del servicio en la base de datos", response = Employee.class, notes = "Ingresa toda la informacion proveniente del servicio a la base de datos")
	@ApiResponses({
			@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Employee.class),
			@ApiResponse(code = 400, message = "Bad Request.No existen Datos En el servico", response = Employee.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Employee.class),
			@ApiResponse(code = 401, message = "Acceso denegado", response = Employee.class) })
	
	public String EmployeeSalary(@RequestBody Employee data) {
		
		ArrayList<Employee> informationEmployee = new ArrayList<>();
		try {
		
			
			EmployeeDaoImpl datos = new EmployeeDaoImpl();
			
			return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El el salario anual del empleado es\",\"salario\":\""+ datos.calcularSalario(data) +"\"}";
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El calculo no se pudo realisar \"}";
		}
	}
}
