package Context;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContext {
	private static String url = "jdbc:sqlserver://localhost;databaseName=QuanLyBanGiay;encrypt=true;trustServerCertificate=true;";

	private DBContext() {

	}

	public static final Connection Connect() {
		try {

			Connection conn;

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			conn = DriverManager.getConnection(url, "sa", "123");

			return conn;

		} catch (ClassNotFoundException e) {

			// TODO: handle exception

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}

	public static final ResultSet Query(String strQuery) {

		Statement stmt;

		try {

			stmt = Connect().createStatement();

			ResultSet rs = stmt.executeQuery(strQuery);

			return rs;

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return null;
		}
	}
	public static void Create (String strQuery) {

		Statement stmt;

		try {

			stmt = Connect().createStatement();

			stmt.executeUpdate(strQuery);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}
	public static void Delete (String strQuery) {

		Statement stmt;

		try {

			stmt = Connect().createStatement();

			stmt.executeUpdate(strQuery);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}
	public static void Edit (String strQuery) {

		Statement stmt;

		try {

			stmt = Connect().createStatement();

			stmt.executeUpdate(strQuery);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}
}


