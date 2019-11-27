package br.edu.cesmac.market.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection CONNECTION = null;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String USER = "postgres";
	private static final String PASSWORD = "post";
	private static final String URL = "localhost:5432/supermercado";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			CONNECTION = DriverManager.getConnection("jdbc:postgresql://" + URL, USER, PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return CONNECTION;
	}

	public static void closeConnection() {
		if (CONNECTION != null) {
			try {
				CONNECTION.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}