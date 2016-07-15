package com.ok.datamining.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {

	public static Connection getDBConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Config.connString,
					Config.connUser, Config.connPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static Integer getPlantCount()
	{
		return 2;
	}

}
