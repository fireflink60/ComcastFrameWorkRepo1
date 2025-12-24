package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtility {

	Connection con = null;

	public void getConnection(String url, String username, String password) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);

		con = DriverManager.getConnection(url, username, password);

	}

	public void getConnection() throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students\",\"root\",\"Saikiran45@");

	}

	public void Close() throws SQLException {
		con.close();
	}

	public ResultSet executeSelectQuery(String Query) throws SQLException {

		ResultSet r = null;
		try {
			Statement stat = con.createStatement();
			 r = stat.executeQuery(Query);

		} catch (Exception e) {

		}
		return r;

	}

	public int executeNonSelectQuery(String Query) throws SQLException {
		int r = 0;
		try {
			Statement stat = con.createStatement();
			r = stat.executeUpdate(Query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;

	}

}
