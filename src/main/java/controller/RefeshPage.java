package controller;

import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Motor;

public class RefeshPage extends HttpServlet {
	public void init() {
		log("init");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String inceptionDateString = request.getParameter("inceptionDate");
		String effectiveDateString = request.getParameter("effectiveDate");
		String expiryDateString =request.getParameter("expiryDate");
		String sumInsuredString = request.getParameter("sumInsured");
		String rateString = request.getParameter("rate");
		String annualPremiumString = request.getParameter("annualPremium");
		SimpleDateFormat fromatter1 = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<String> jsonArray = new ArrayList<String>();
		String json;
		try {
			Date inceptionDate = fromatter1.parse(inceptionDateString);
			Date effectiveDate = fromatter1.parse(effectiveDateString);
			Date expiryDate = fromatter1.parse(expiryDateString);
			Long test = effectiveDate.getTime() - inceptionDate.getTime();
			Long test1 = expiryDate.getTime() - effectiveDate.getTime();
			if(test <= 0 || test1 <=0) {
				jsonArray.add("DateErr");
				json = new Gson().toJson(jsonArray);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(json);
			}else {
				BigDecimal sumInsured = new BigDecimal(sumInsuredString);
				Float rate = Float.parseFloat(rateString);
				BigDecimal annualPremium = new BigDecimal(annualPremiumString);
				Motor dataMotorRefesh = new Motor();
				dataMotorRefesh.setEffectiveDate(effectiveDate);
				dataMotorRefesh.setExpiryDate(expiryDate);
				dataMotorRefesh.setSumInsured(sumInsured);
				dataMotorRefesh.setRate(rate);
				dataMotorRefesh.setAnnualPremium(annualPremium);
				BigDecimal calAnnual = dataMotorRefesh.calculatorAnnualPremium();
				BigDecimal calPosted = dataMotorRefesh.calculatorPostedPremium();
				String calAnnualString = calAnnual.toString();
				String calPostedString = calPosted.toString();
				jsonArray.add(calAnnualString);
				jsonArray.add(calPostedString);
				json= new Gson().toJson(jsonArray);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(json);
			}
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String policyNoString = request.getParameter("policyNo");
		String inceptionDateString = request.getParameter("inceptionDate");
		String effectiveDateString = request.getParameter("effectiveDate");
		String expiryDateString =request.getParameter("expiryDate");
		String sumInsuredString = request.getParameter("sumInsured");
		String rateString = request.getParameter("rate");
		String annualPremiumString = request.getParameter("annualPremium");
		String postedPremiumString = request.getParameter("postedPremium");
		String enghineNoString = request.getParameter("enghineNo");
		String chassicNoString = request.getParameter("chassicNo");
		String vehicleRegistrationNoString = request.getParameter("vehicleRegistrationNo");
		String billingString = request.getParameter("billing");
		SimpleDateFormat fromatter1 = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<String> jsonArray = new ArrayList<String>();
		String json;
		Date inceptionDate;
		try {
			inceptionDate = fromatter1.parse(inceptionDateString);
			Date effectiveDate = fromatter1.parse(effectiveDateString);
			Date expiryDate = fromatter1.parse(expiryDateString);
			Long test = effectiveDate.getTime() - inceptionDate.getTime();
			Long test1 = expiryDate.getTime() - effectiveDate.getTime();
			if(test <= 0 || test1 <=0) {
				jsonArray.add("DataErr");
				json = new Gson().toJson(jsonArray);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(json);
			}else {
				Connection conn = model.MyConnect.getConnection(request);
				Statement stm =  conn.createStatement();
				String queryBilling = "select id,Billing from Billing where Billing = '"+billingString+"'";
				ResultSet resultBilling = stm.executeQuery(queryBilling);
				Integer Billing = 0;
				while(resultBilling.next()) {
					Billing = resultBilling.getInt(1);
				}
				StringBuilder query = new StringBuilder("update Moto_Policy set Policy_No ='"+policyNoString+" ', Inception_Date='"+inceptionDateString+"', Expiry_Date='"+expiryDateString+"',Engine_Number='"+enghineNoString+"' , ");
				query.append("Chassis_No='"+chassicNoString+"', Vehicle_Registration_No='"+vehicleRegistrationNoString+"', Billing_Currency_id='"+Billing.toString()+"',Sum_insured='"+sumInsuredString+"',Rate='"+rateString+"',Annual_Premium='"+annualPremiumString+"',Posted_Premium='"+postedPremiumString+"',");
				query.append("Effective_Date='"+effectiveDateString+"',statuspolicy='SE' where Policy_No = '"+policyNoString+"'");
				int status = stm.executeUpdate(query.toString());
				if(status == 0) {
					jsonArray.add("ErrUpdate");
					json = new Gson().toJson(jsonArray);
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(json);
				}else {
					jsonArray.add("UpdateSuccess");
					json = new Gson().toJson(jsonArray);
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(json);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void destroy() {
		
	}
	
}
