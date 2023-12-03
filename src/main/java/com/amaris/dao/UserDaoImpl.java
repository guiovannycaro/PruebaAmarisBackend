package com.amaris.dao;

import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;

import java.io.BufferedReader;
import com.amaris.models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.net.HttpURLConnection;
import com.amaris.util.executeQueryBD;

public class UserDaoImpl implements UsersDao{
	 private final String USER_AGENT = "Mozilla/5.0";
	 
	 executeQueryBD query = new executeQueryBD();
		ResultSet resulSelect;
		
	
	@Override
	public String agregarUser(Users empl) throws SQLException {
		
		String validaIngreso;
		String sql = "insert into  users"
				+ " (userid,id,title,bodys) "
				+ "values(" + empl.getUserId() + "," + empl.getId() + ",'" +empl.getTitle() + "'," + "'" + empl.getBody() + "')";
		System.out.println("consulta " + sql);
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
		
	}

	@Override
	public String updateUser(Users empl) throws SQLException {
		String validaIngreso;
		String sql = "Update   users SET "
				+ "userid = " + empl.getUserId() + ","
				+ "id = " + empl.getId() + ","
				+ "title = '" + empl.getTitle() + "',"
				+ "bodys = '" + empl.getBody() + "'"
				+ " WHERE iduser = " + empl.getIduser() + " ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue EDITADO De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue EDITADO De Manera Correcta\"}";
		}
		return validaIngreso;
		
	}
	
	@Override
	public List<Users> returnAllUsers() throws SQLException{
		ArrayList<Users> list = new ArrayList<>();
		String sql = "select * from users";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Users empl = new Users();
			empl.setIduser (resulSelect.getInt("iduser"));
			empl.setUserId(resulSelect.getInt("userid"));
			empl.setId(resulSelect.getInt("id"));
			empl.setTitle(resulSelect.getString("title"));
			empl.setBody(resulSelect.getString("bodys"));
		

			list.add(empl);
		}
		return list;
	}



	

	@Override
	public List<Users> buscarUserById(Users datos) throws SQLException{
		ArrayList<Users> list = new ArrayList<>();
		String sql = "select * from users where iduser = "+datos.getIduser()+"";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Users empl = new Users();
			empl.setIduser (resulSelect.getInt("iduser"));
			empl.setUserId(resulSelect.getInt("userid"));
			empl.setId(resulSelect.getInt("id"));
			empl.setTitle(resulSelect.getString("title"));
			empl.setBody(resulSelect.getString("bodys"));

			list.add(empl);
		}
		return list;
	}


	
	
}
