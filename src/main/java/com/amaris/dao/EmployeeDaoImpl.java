package com.amaris.dao;

import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;

import java.io.BufferedReader;
import com.amaris.models.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.net.HttpURLConnection;
import com.amaris.util.executeQueryBD;

public class EmployeeDaoImpl implements EmployeeDao{
	 private final String USER_AGENT = "Mozilla/5.0";
	 
	 executeQueryBD query = new executeQueryBD();
		ResultSet resulSelect;
		
	@Override
	public String consumeService() {
		
		 String BASE_URL = "http://dummy.restapiexample.com/api/v1/employees";
		 String data = null;
		 int responseCode = 0;
		 try {
			URL url = new URL(BASE_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			 con.setRequestProperty("User-Agent", USER_AGENT);
			con.connect();
			
			responseCode = con.getResponseCode();
			if(responseCode != 200) {
				throw new RuntimeException("ha ocurrido un error de coneccion " + responseCode);
			}else {
				StringBuilder informationString = new StringBuilder();
				Scanner s = new Scanner(url.openStream());
				while(s.hasNext()) {
					informationString.append(s.nextLine());
					
				}
				
				s.close();
				
				System.out.println("el contenido es " + informationString);
				
				JSONArray jsonArray = new JSONArray(informationString.toString());
				
				JSONObject jsonObject = jsonArray.getJSONObject(0);
				System.out.println("el contenido 2  es " + jsonObject.getString("title"));
				JSONArray jArray3 = jsonObject.getJSONArray("data");
				for(int i = 0; i < jArray3.length(); i++)
				{
				   JSONObject object3 = jArray3.getJSONObject(i);
				   int id = object3.getInt("id");
				   String employee_name = object3.getString("employee_name");
				   int employee_salary = object3.getInt("employee_salary");
				   int employee_age = object3.getInt("employee_age");
				   String profile_image = object3.getString("profile_image");
				   
				     
				 data =   insertEmployee(id,employee_name,employee_salary,employee_age,profile_image);
				}
				
			}
			return data;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		
			
			String error = "{\"codigo\":\""+responseCode+"\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"se ha presentado un error durante el intento de coneccion con el servidor\"}";
			return error;
		}
		// TODO Auto-generated method stub
	
	}

	
	public String consumeService2() {
		
		 String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
		 String data = null;
		 try {
			URL url = new URL(BASE_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			
			int responseCode = con.getResponseCode();
			if(responseCode != 200) {
				throw new RuntimeException("ha ocurrido un error de coneccion " + responseCode);
			}else {
				StringBuilder informationString = new StringBuilder();
				Scanner s = new Scanner(url.openStream());
				while(s.hasNext()) {
					informationString.append(s.nextLine());
					
				}
				
				s.close();
				
				System.out.println("el contenido es " + informationString);
				
				JSONArray jsonArray = new JSONArray(informationString.toString());
				
				JSONObject jsonObject = jsonArray.getJSONObject(0);
				System.out.println("el contenido 2  es " + jsonObject.getString("title"));
				for(int i = 0; i < jsonArray .length(); i++)
				{
				   JSONObject object3 = jsonArray.getJSONObject(i);
				   
				   int userId = object3.getInt("userId");
				
				   int id = object3.getInt("id");
				  
				   String title = object3.getString("title");
				
				   String body = object3.getString("body");
				
				   
				  data = insertUser(userId,id,title,body);
				}
				
			}
			return data ;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
	}
	
	@Override
	public String agregarEmployee(Employee empl) throws SQLException {
		
		String validaIngreso;
		String sql = "insert into  employees"
				+ " (id,employee_name,employee_salary,employee_age,profile_image) "
				+ "values(" + empl.getIdService() + ",'" + empl.getEmployeeName() + "'," +empl.getEmployeeSalary() + "," + "" + empl.getEmployeeAge() + ",'" + empl.getProfileImage() + "')";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
		
	}

	@Override
	public String updateEmployee(Employee empl) throws SQLException {
		String validaIngreso;
		String sql = "Update   employees SET "
				+ "id = '" + empl.getIdService() + "',"
				+ "employee_name = '" + empl.getEmployeeName() + "',"
				+ "employee_salary = '" + empl.getEmployeeSalary() + "',"
				+ "employee_age = '" + empl.getEmployeeAge() + "',"
				+ "profile_image = '" + empl.getProfileImage() + "'"
				+ " WHERE idemployee = " + empl.getEmployeeId() + " ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue EDITADO De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue EDITADO De Manera Correcta\"}";
		}
		return validaIngreso;
		
	}
	
	@Override
	public List<Employee> returnAllEmployees() throws SQLException{
		ArrayList<Employee> list = new ArrayList<>();
		String sql = "select * from employees";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Employee empl = new Employee();
			empl.setEmployeeId(resulSelect.getInt("idemployee"));
			empl.setIdService(resulSelect.getString("id"));
			empl.setEmployeeName(resulSelect.getString("employee_name"));
			empl.setEmployeeSalary(resulSelect.getString("employee_salary"));
			empl.setEmployeeAge(resulSelect.getString("employee_age"));
			empl.setProfileImage(resulSelect.getString("profile_image"));

			list.add(empl);
		}
		return list;
	}



	@Override
	public void dropEmployee(Integer idEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> buscarEmployeeById(Employee datos) throws SQLException{
		ArrayList<Employee> list = new ArrayList<>();
		String sql = "select * from employees where idemployee = "+datos.getEmployeeId()+"";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Employee empl = new Employee();
			empl.setEmployeeId(resulSelect.getInt("idemployee"));
			empl.setIdService(resulSelect.getString("id"));
			empl.setEmployeeName(resulSelect.getString("employee_name"));
			empl.setEmployeeSalary(resulSelect.getString("employee_salary"));
			empl.setEmployeeAge(resulSelect.getString("employee_age"));
			empl.setProfileImage(resulSelect.getString("profile_image"));

			list.add(empl);
		}
		return list;
	}


	
	@Override
	public String  insertEmployee(int id,String employee_name,int employee_salary,int employee_age,String profile_image)  throws Exception{
		System.out.println(" el contenido userId " + id + " el contenido id " + employee_name + " el contenido title " + employee_salary + " el contenido body " + employee_age + " " + profile_image + "\n");
		String validaIngreso;
		String sql = "insert into  employees"
				+ " (id,employee_name,employee_salary,employee_age,profile_image) "
				+ "values(" + id + ",'" + employee_name + "'," +employee_salary + "," + "" + employee_age + ",'" + profile_image + "')";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
	
	
	}
	
	@Override
	public String  insertUser(int userId,int id, String title, String body)  throws Exception{
		System.out.println(" el contenido userId " + userId + " el contenido id " + id + " el contenido title " + title + " el contenido body " + body + "\n");
		String validaIngreso;
		String sql = "insert into  users"
				+ " (userId,id,title,bodys) "
				+ "values(" + userId + "," + id + ",'" +title + "'," + "'" + body + "')";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
				
	}


	@Override
	public double calcularSalario(Employee empl) {
	    int salario =	Integer.parseInt(empl.getEmployeeSalary());
	    double employee_anual_salary = salario * 12;
		return employee_anual_salary;
	}


}
