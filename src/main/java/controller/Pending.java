package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pending extends HttpServlet {
	@Override
	public void init() {
		log("Init");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = model.MyConnect.getConnection(request);
		ArrayList<model.Motor> data = new ArrayList<model.Motor>();
		try {
			Statement stm= con.createStatement();
			StringBuilder query = new StringBuilder("select Policy_No,Inception_Date,Expiry_Date,Renewal_Date,Policy_Owner,Engine_Number,Chassis_No,");
			query.append("Vehicle_Registration_No,b.Billing,Sum_insured,Rate,Annual_Premium,Posted_Premium,Effective_Date,statuspolicy from ");
			query.append("Moto_Policy mp join Billing b on mp.Billing_Currency_id=b.id where statuspolicy like 'SE'");
			ResultSet result = stm.executeQuery(query.toString());
			while(result.next()) {
				model.Motor objectData = new model.Motor(result.getString(1), result.getDate(2), result.getDate(3),result.getString(5), 
						result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getBigDecimal(10), 
						result.getFloat(11), result.getBigDecimal(12), result.getBigDecimal(13), result.getString(15));
						objectData.setEffectiveDate(result.getDate(14));
				data.add(objectData);
//				BigDecimal test = objectData.calculatorPostedPremium();
//				System.out.print(test.toString());
			}
			request.setAttribute("dataPendingPage", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rep= request.getRequestDispatcher("pending.jsp");
		rep.forward(request, response);
	}
	@Override
	public void destroy() {
		
	}
}
