package web.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public Connection getDBConnection() {
		String connectUrl = "jdbc:mysql://localhost:3306/hospitalmanagement?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "Do03011995";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(connectUrl, username, password);
			return connect;
		} catch (Exception e) {
			System.err.println("connect fail!");
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws SQLException {
		String connectUrl = "jdbc:mysql://localhost:3306/hospitalmanagement";
		String username = "root";
		String password = "Do03011995";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(connectUrl, username, password);
			System.out.print(connect);
		} catch (Exception e) {
			System.err.println("connect fail!");
			e.printStackTrace();
			System.out.print("fail");
		}
		
	}
}
