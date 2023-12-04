package com.amaris.controller;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.amaris.dao.UserDaoImpl;
import com.amaris.models.Users;
import com.amaris.util.ExceptionUtil;

@RestController
@RequestMapping("/amaris/Servicio/Users")
@Api(value = "Consulta Empleados")
public class UserController {

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	
	@PostMapping(value = "/addUser" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta agregar Employees", response =  Users.class, notes = "add employee ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response =  Users.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Employee Asociados a esa cedula(String)", response =  Users.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =  Users.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response =  Users.class),
		@ApiResponse(code = 401, message = "No existen Employee Asociados a esa cedula", response =  Users.class),
		@ApiResponse(code = 404, message = "No existen Employee Asociados a esa cedula", response =  Users.class), })
	public String agregarUsers(
			@RequestBody Users data) {
		try {
			UserDaoImpl datos = new UserDaoImpl();
			return datos.agregarUser(data);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue agregado De Manera Correcta\"}";
		}
	}
	
	@PostMapping(value = "/editUser" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Employees", response =  Users.class, notes = "edit employee ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response =  Users.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Employee Asociados a esa cedula(String)", response =  Users.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =  Users.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response =  Users.class),
		@ApiResponse(code = 401, message = "No existen Employee Asociados a esa cedula", response =  Users.class),
		@ApiResponse(code = 404, message = "No existen Employee Asociados a esa cedula", response =  Users.class), })
	public String editarUsers(
			@RequestBody  Users data) {
		try {
			UserDaoImpl datos = new UserDaoImpl();
			return datos.updateUser(data);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@GetMapping(value = "/listUser")
	@ApiOperation(value = "Consume y carga la informacion del servicio en la base de datos", response =  Users.class, notes = "Ingresa toda la informacion proveniente del servicio a la base de datos")
	@ApiResponses({
			@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response =  Users.class),
			@ApiResponse(code = 400, message = "Bad Request.No existen Datos En el servico", response =  Users.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response =  Users.class),
			@ApiResponse(code = 401, message = "Acceso denegado", response =  Users.class) })
	
	public List< Users> listEmployee() {
		
		ArrayList< Users> informationEmployee = new ArrayList<>();
		try {
		
			
			UserDaoImpl datos = new UserDaoImpl();
			return datos.returnAllUsers();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}
	
	
	@GetMapping(value = "/listUserById" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consume y carga la informacion del servicio en la base de datos", response =  Users.class, notes = "Ingresa toda la informacion proveniente del servicio a la base de datos")
	@ApiResponses({
			@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response =  Users.class),
			@ApiResponse(code = 400, message = "Bad Request.No existen Datos En el servico", response =  Users.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response =  Users.class),
			@ApiResponse(code = 401, message = "Acceso denegado", response =  Users.class) })
	
	public List< Users> listUsersById(@RequestBody Users data) {
		
		ArrayList< Users> informationEmployee = new ArrayList<>();
		try {
		
			
			UserDaoImpl datos = new UserDaoImpl();
			return datos.buscarUserById(data);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}
}
