package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static final String MYSQL_USERNAME = "oopuser";
	public static final String MYSQL_PASSWORD = "asd123";
	public static final String MYSQL_DATABASE_SERVER = "jdbc:mysql://db4free.net:3306";
	public static final String MYSQL_DATABASE_NAME = "oopproject";
	public static Connection connection;

	// This class just connects to database
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}

		System.out.println("MySQL JDBC Driver Registered!");

		try {
			connection = DriverManager.getConnection(MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME, MYSQL_USERNAME,
					MYSQL_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	// Return active connection
	public static Connection getConnection() {
		return connection;
	}

	public static void CloseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBConnection n = new DBConnection();
	}
}