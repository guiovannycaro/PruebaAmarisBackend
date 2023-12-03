package com.amaris.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.amaris.config.properties.Propiedad;

public class ConnectionFactory {
	public static Connection connectToBD() throws SQLException {
		
		String connString = Propiedad.getCurrentInstance().getBDJdbc();
		
		String username = Propiedad.getCurrentInstance().getBDUsuario();
	
		String password = Propiedad.getCurrentInstance().getBDClave();
		
		return DriverManager.getConnection(connString, username, password);
	}
}
