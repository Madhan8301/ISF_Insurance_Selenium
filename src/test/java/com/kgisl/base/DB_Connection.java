package com.kgisl.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.aeonbits.owner.ConfigFactory;

import io.cucumber.java.Scenario;

public class DB_Connection {

	public String schemaName = "";
	public Connection con = null;
	public Statement st;
	public String DBurl = null;
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
	public String DBpath = System.getProperty("user.dir") + "/TestData" + "/sqlite/";
	public String fileName = config.DBName();

	public void createDB() throws Exception {
		File f = new File(DBpath + fileName + ".db");
		if (!f.exists()) {
			String url = "jdbc:sqlite:" + DBpath + fileName + ".db";

			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection(url);
				if (con != null) {
					DatabaseMetaData meta = con.getMetaData();
					System.out.println("The driver name is " + meta.getDriverName());
					System.out.println("A new database has been created.");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void createTable() throws SQLException, Exception {
		String url = "jdbc:sqlite:" + DBpath + fileName + ".db";
		String sql = "CREATE TABLE Master (\n" + " TestID INTEGER,\n" + " TestCaseID text,\n " + " ScenarioName text,\n"
				+ " Status text,\n" + " TIMESTAMP text,\n" + " TestData text \n);";
		String sql1 = "CREATE TABLE Summary (\n" + " TestID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "  TestCaseID text,\n " + " ScenarioName text,\n" + " Status text,\n" + " TIMESTAMP text,\n "
				+ "TestData text \n);";

		String sql2 = "CREATE TABLE policyNo (\n" + " TestID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "  TestCaseID text,\n " + " scenarioName text,\n" + " policyNo text \n);";

		// connect();
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();

		if (getConfigData("CreateTable").equalsIgnoreCase("Y")) {
			try {
				stmt.execute("DROP TABLE Master;");
				stmt.execute(sql);
				// System.out.println("Table created");
			} catch (Exception e) {
				System.out.println("table not Available");
				stmt.execute(sql);
				e.printStackTrace();

			}
		} 

		try {
			stmt.execute("DROP TABLE Summary;");
			stmt.execute(sql1);
			// System.out.println("Table created");
		} catch (Exception e) {
			System.out.println("table not already exist");
			// stmt.execute("DROP TABLE Summary;");
			stmt.execute(sql1);
			// System.out.println("Table created");
			e.printStackTrace();

		}
		
		try {
			stmt.execute("DROP TABLE policyNo;");
			stmt.execute(sql2);
			// System.out.println("Table created");
		} catch (Exception e) {
			System.out.println("table not Available");
			stmt.execute(sql2);
			e.printStackTrace();

		}

	}

	public void connect() {
		con = null;
		try {
			String url = "jdbc:sqlite:" + DBpath + fileName + ".db";
			try {
				con = DriverManager.getConnection(url);
				if (con == null) {
					DatabaseMetaData meta = con.getMetaData();
					con = DriverManager.getConnection(url);
					System.out.println("The driver name is " + meta.getDriverName());
				}
			} catch (SQLException e) {
				System.out.print(e);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public String getConfigData(String propName) throws IOException {
		String propValue = "";
		Properties prop = new Properties();
		File f = new File(System.getProperty("user.dir") + "/FrameworkConfig.properties");
		FileInputStream fio = new FileInputStream(f);
		prop.load(fio);
		propValue = prop.getProperty(propName);
		return propValue;
	}

}
