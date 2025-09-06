package com.jdbc.example;

import java.sql.*;

public class jdbcFirstApp {
	public static void main(String ar[]) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root","root");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select name from city "
					+ "where countrycode = 'ind' and district = 'bihar' and population<300000");
			String name;
			while(resultSet.next()) {
				name = resultSet.getString("name");
				System.out.println(name);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}