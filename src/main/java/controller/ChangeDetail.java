package controller;

import java.io.IOException;
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

public class ChangeDetail extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init() {
		log("inti");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		String policyNoParam = request.getParameter("policyno");
		Connection conn = model.MyConnect.getConnection(request);
		
		try {
			Statement stm = conn.createStatement();
			StringBuilder query = new StringBuilder("select Policy_No,Inception_Date,Expiry_Date,");
			query.append("Renewal_Date,Policy_Owner,Engine_Number,Chassis_No,Vehicle_Registration_No,");
			query.append("b.Billing,Sum_insured,Rate,Annual_Premium,Posted_Premium,Effective_Date,statuspolicy ");
			query.append("from Moto_Policy mp join Billing b on mp.Billing_Currency_id=b.id where ");
			query.append("Policy_No =" + "'"+policyNoParam+"'");
			ResultSet result= stm.executeQuery(query.toString());
			while(result.next()) {
				model.Motor objectData = new model.Motor(result.getString(1), result.getDate(2), result.getDate(3),result.getString(5), 
						result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getBigDecimal(10), 
						result.getFloat(11), result.getBigDecimal(12), result.getBigDecimal(13), result.getString(15));
						objectData.setEffectiveDate(result.getDate(14));
						request.setAttribute("dataChangePage",objectData);
						
			}
			String queryBilling = "select id,Billing from Billing";
			ResultSet resultBilling =  stm.executeQuery(queryBilling);
			ArrayList<model.Billing> dataBilling = new ArrayList<model.Billing>();
			while(resultBilling.next()) {
				model.Billing dataBillingObject = new model.Billing(resultBilling.getInt(1), resultBilling.getString(2));
				dataBilling.add(dataBillingObject);
			}
			request.setAttribute("dataBillingChangePage", dataBilling);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		RequestDispatcher re = request.getRequestDispatcher("changedetail.jsp");
		re.forward(request, reponse);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response ) {
		
	}
	public void destroy() {
		
	}
}
