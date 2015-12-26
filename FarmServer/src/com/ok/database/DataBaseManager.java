package com.ok.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBaseManager {
	public enum DatabaseType {
		MySQL, MicrosoftSQL
	}

	private DatabaseType databaseType = null;

	private String server = null;

	private String pointConnection = null;

	private String database = null;

	private String user = null;

	private String password = null;

	private static Connection connection = null;

	private String connectionString = null;

	public DataBaseManager() {

	}

	public ResultSet query(String sqlKomutu) throws SQLException {

		ResultSet resultSet = null;

		resultSet = this.getStatement().executeQuery(sqlKomutu);

		return resultSet;

	}
	public int update(String sqlKomutu) throws SQLException {

		return this.getStatement().executeUpdate(sqlKomutu);

	}
	public Boolean execute(String sqlKomutu) throws SQLException {

		return this.getStatement().execute(sqlKomutu);

	}

	public Statement getStatement() throws SQLException {

		Statement statement = null;

		statement = this.getBaglanti().createStatement();

		return statement;

	}

	private Connection getBaglanti() throws SQLException {

		if (connection == null) {

			connection = DriverManager.getConnection(this.getBaglantiDizgisi());

		}

		return connection;

	}

	public static void EndConnection() throws SQLException {

		if (connection != null)
			connection.close();
	}

	private String getBaglantiDizgisi() throws SQLException {

		if (connectionString == null) {

			switch (this.getDatabaseType()) {
			case MySQL:

				connectionString = "jdbc:mysql://" + this.getServer() + ":" + this.getPointConnection() + "/"
						+ this.getDatabase() + "?user=" + this.getUser() + "&password=" + this.getPassword() + "";
				break;

			case MicrosoftSQL:

				connectionString = "jdbc:sqlserver://" + this.getServer() + ":" + this.getPointConnection()
						+ ";databasename=" + this.getDatabase() + ";user=" + this.getUser() + ";password="
						+ this.getPassword() + "";
				break;

			default:

				throw new SQLException("Bu veritabani türü icin baglanti dizgisi olusuturulamiyor.");

			}

		}

		return connectionString;

	}

	public DatabaseType getDatabaseType() {

		if (databaseType == null) {

			databaseType = DatabaseType.MySQL;

		}

		return databaseType;

	}

	public void setDatabaseType(DatabaseType databaseType) {

		this.databaseType = databaseType;

	}

	public String getServer() {

		if (server == null) {

			server = "";

		}

		return server;

	}

	public void setServer(String server) {

		this.server = server;

	}

	public String getPointConnection() {

		if (pointConnection == null) {

			pointConnection = "";

		}

		return pointConnection;

	}

	public void setPointConnection(String pointConnection) {

		this.pointConnection = pointConnection;

	}

	public String getDatabase() {

		if (database == null) {

			database = "";

		}

		return database;

	}

	public void setDatabase(String database) {

		this.database = database;

	}

	public String getUser() {

		if (user == null) {

			user = "";

		}

		return user;

	}

	public void setUser(String user) {

		this.user = user;

	}

	public String getPassword() {

		if (password == null) {

			password = "";

		}

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}
}
