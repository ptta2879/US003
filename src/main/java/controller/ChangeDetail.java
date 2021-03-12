package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeDetail extends HttpServlet {
	public void init() {
		log("inti");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		RequestDispatcher req = request.getRequestDispatcher("changedetail.jsp");
		req.forward(request, reponse);
	}
	public void destroy() {
		
	}
}
