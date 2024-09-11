package com.justin.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class BancoApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
		// boolean isConnected = testConnection();
		// assertTrue(isConnected, "Conexión fallida");
		// var connection = testConnection2();

	}

	public boolean testConnection() {
		try {
			jdbcTemplate.execute("SELECT 1");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Connection testConnection2() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=DB_BANCO;"
					+ "user=usuario1;"
					+ "password=12345678;"
					+ "trustServerCertificate=true";

			Connection con = DriverManager.getConnection(connectionUrl);
			return con;
		} catch (SQLException e) {
			System.out.println(e);

		} catch (Exception e) {
			System.out.println(e);

		}
		return null;
	}
}
