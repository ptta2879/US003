package controller;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Home extends HttpServlet {
	@Override
	public void init() {
		log("Init");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
	 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	 dispatcher.forward(request, reponse);

	}
	@Override
	public void destroy() {
		log("Exits");
	}
}
