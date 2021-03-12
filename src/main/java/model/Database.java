package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static final String HOST_NAME = "localhost";
	private static final String SQL_INSTANCE_NAME = "SQLEXPRESS";
	private static final String DATABASE = "Policy";
	private static final String USERNAME ="sa";
	private static final String PASSWORD = "123";
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		String connectioURL = "jdbc:jtds:sqlserver://"+ HOST_NAME +":1433/"+DATABASE
				+";instance="+SQL_INSTANCE_NAME;
		return DriverManager.getConnection(connectioURL, USERNAME, PASSWORD);
	}
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
