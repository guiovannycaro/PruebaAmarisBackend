package com.amaris.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class executeQueryBD {
	public ResultSet executeSelectBd(String sql) throws SQLException {
		try (Connection connection = ConnectionFactory.connectToBD()) {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException ex) {
			System.err.println("SQLException:\n " + ex + " Errror al consultar el valor");
			return null;
		}

	}

	public boolean executeUpdateBd(String sql) throws SQLException {
		boolean resultado;
		try (Connection connection = ConnectionFactory.connectToBD()) {
			PreparedStatement st = connection.prepareStatement(sql);
			st.executeUpdate();
			resultado = true;
		} catch (SQLException ex) {
			System.err.println("SQLException:\n " + ex + " Errror al actualizar el valor");
			resultado = false;
		}
		return resultado;
	}
}
