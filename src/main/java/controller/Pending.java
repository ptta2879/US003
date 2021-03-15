package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
			query.append("Moto_Policy mp join Billing b on mp.Billing_Currency_id=b.id where statuspolicy = 'SE'");
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String policyNoString = request.getParameter("policyno");
		String inceptionDateString = request.getParameter("inceptiondate");
		String effectiveDateString = request.getParameter("effectivedate");
		String expiryDateString =request.getParameter("expirydate");
		String sumInsuredString = request.getParameter("suminsured");
		String rateString = request.getParameter("rate");
		String annualPremiumString = request.getParameter("annualpremium");
		String postedPremiumString = request.getParameter("postedpremium");
		String enghineNoString = request.getParameter("enghineno");
		String chassicNoString = request.getParameter("chassicno");
		String vehicleRegistrationNoString = request.getParameter("vehicleregistrationno");
		String billingString = request.getParameter("billing");
		SimpleDateFormat fromatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date inceptionDate;
		try {
			inceptionDate = fromatter1.parse(inceptionDateString);
			Date effectiveDate = fromatter1.parse(effectiveDateString);
			Date expiryDate = fromatter1.parse(expiryDateString);
			Long test = effectiveDate.getTime() - inceptionDate.getTime();
			Long test1 = expiryDate.getTime() - effectiveDate.getTime();
			if(test <=0 ||test1<=0 ) {
				request.setAttribute("thongbao", "Fail");
			}else {
				Connection conn = model.MyConnect.getConnection(request);
				Statement stm =  conn.createStatement();
				String queryBilling = "select id,Billing from Billing where Billing like '"+billingString+"'";
				ResultSet resultBilling = stm.executeQuery(queryBilling);
				Integer Billing = 0;
				while(resultBilling.next()) {
					Billing = resultBilling.getInt(1);
				}
				StringBuilder query = new StringBuilder("update Moto_Policy set  Inception_Date='"+effectiveDateString+"',Engine_Number='"+enghineNoString+"' , ");
				query.append("Chassis_No='"+chassicNoString+"', Vehicle_Registration_No='"+vehicleRegistrationNoString+"', Billing_Currency_id='"+Billing.toString()+"',Sum_insured='"+sumInsuredString+"',Rate='"+rateString+"',Annual_Premium='"+annualPremiumString+"',Posted_Premium='"+postedPremiumString+"',");
				query.append("Effective_Date='"+effectiveDateString+"',statuspolicy='IF' where Policy_No = '"+policyNoString+"'");
				int status = stm.executeUpdate(query.toString());
				if(status != 0) {
				
					response.sendRedirect("Home");
				}else {
					request.setAttribute("thongbao", "Fail");
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void destroy() {
		
	}
}
