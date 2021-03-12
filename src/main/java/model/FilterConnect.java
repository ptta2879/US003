package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterConnect implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath= req.getServletPath();
		if(servletPath.contains("/Home") || servletPath.contains("/Pending") || 
				servletPath.contains("/ChangeDetail")) {
			Connection conn =null;
			try {
				conn = Database.getConnection();
				conn.setAutoCommit(false);
				Attribute.storeConnection(request, conn);
				chain.doFilter(request, response);
				conn.commit();
			} catch (Exception e) {
				Database.rollbackQuietly(conn);
				throw new ServletException();
			}finally {
				Database.closeQuietly(conn);
			}
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		
	}
}
