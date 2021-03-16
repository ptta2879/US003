package model;

import java.sql.Connection;

import javax.servlet.ServletRequest;

public class MyConnect {
	public static final String ATT_NAME = "CONNECTION_ATTRIBUTE";
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME, conn);
	}
	public static Connection getConnection(ServletRequest request) {
		return (Connection) request.getAttribute(ATT_NAME);
	}
}
