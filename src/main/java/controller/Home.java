package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Motor;





public class Home extends HttpServlet {
	@Override
	public void init() {
		log("Init");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		Connection conn = model.MyConnect.getConnection(request);
		try {
			/*****
			 * 
			 */
			Statement stmt= conn.createStatement();
			StringBuilder query=new StringBuilder("select Policy_No,Inception_Date,Expiry_Date,Renewal_Date,Policy_Owner,");
			query.append("Engine_Number,Chassis_No,Vehicle_Registration_No,b.Billing,Sum_insured,Rate,Annual_Premium,");
			query.append("Posted_Premium,statuspolicy from Moto_Policy mp join Billing b on mp.Billing_Currency_id=b.id ");
			query.append("where statuspolicy like 'IF'");
			ResultSet result= stmt.executeQuery(query.toString());
			ArrayList <model.Motor> data = new ArrayList<model.Motor>();
			while(result.next()) {
				model.Motor objectPageHome = new model.Motor(result.getString(1), result.getDate(2), result.getDate(3),result.getString(5), 
						result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getBigDecimal(10),
						result.getFloat(11), result.getBigDecimal(12), result.getBigDecimal(13), result.getString(14));
				data.add(objectPageHome);
				
			}
			request.setAttribute("dataHomePage", data);
			/*****
			 * 
			 */
			StringBuilder queryBilling = new StringBuilder("select * from Billing");
			ResultSet resultBilling = stmt.executeQuery(queryBilling.toString());
			ArrayList <model.Billing> data2 = new ArrayList<model.Billing>();
			while(resultBilling.next()) {
				model.Billing objectPageHomeBilling = new model.Billing(resultBilling.getInt(1), resultBilling.getString(2));
				data2.add(objectPageHomeBilling);
			}
			request.setAttribute("dataBilling", data2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	 dispatcher.forward(request, reponse);

	}
	@Override
	public void destroy() {
		log("Exits");
	}
}
