package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Motor {
	private String policyNo;
	private Date effectiveDate;
	private Date expiryDate;
	private Date inceptionDate;
	private String policyOwner;
	private String engineNo;
	private String chasisNo;
	private String vehicleRegistrationNo;
	private String billingCurrency;
	private BigDecimal sumInsured;
	private Float rate;
	private BigDecimal annualPremium;
	private BigDecimal postedPremium;
	private String status;
	public Motor(String policyNo, Date inceptionDate,Date expiryDate,String policyOwner,
			String engineNo , String chasisNo,String vehicleRegistrationNo,String billingCurrency
			,BigDecimal sumInsured, Float rate,BigDecimal annualPremium,BigDecimal postedPremium,
			String status){
		this.policyNo = policyNo;
		this.inceptionDate = inceptionDate;
		this.expiryDate = expiryDate;
		this.policyOwner=policyOwner;
		this.engineNo=engineNo;
		this.chasisNo=chasisNo;
		this.vehicleRegistrationNo=vehicleRegistrationNo;
		this.billingCurrency=billingCurrency;
		this.sumInsured=sumInsured ;
		this.rate=rate;
		this.annualPremium=annualPremium;
		this.postedPremium=postedPremium;
		this.status=status;
	}
	public Motor() {
		
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate =  effectiveDate;
	}
	public String getPolicyNo() {
		return this.policyNo;
	}
	public Date getInceptionDate() {
		return this.inceptionDate;
	}
	public Date getExpiryDate() {
		return this.expiryDate;
	}
	public Date getEffectiveDate() {
		return this.effectiveDate;
	}
	public String getPolicyOwner() {
		return this.policyOwner;
	}
	public String getEngineNo() {
		return this.engineNo;
	}
	public String getChasisNo() {
		return this.chasisNo;
	}
	public String getVehicleRegistrationNo() {
		return this.vehicleRegistrationNo;
	}
	public String getBillingCurrency() {
		return this.billingCurrency;
	}
	public BigDecimal getSumInsured() {
		return this.sumInsured;
	}
	public Float getRate() {
		return this.rate;
	}
	public BigDecimal getAnnualPremium() {
		return this.annualPremium;
	}
	public BigDecimal getPostedPremium() {
		return this.postedPremium;
	}
	public String getStatus() {
		return this.status;
	}
	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public void setAnnualPremium(BigDecimal annualPremium) {
		this.annualPremium = annualPremium;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setPostedPremium(BigDecimal postedPremium) {
		this.postedPremium = postedPremium;
	}
	public BigDecimal calculatorAnnualPremium() {
		BigDecimal bigdecimalRate = new BigDecimal(this.rate.toString());
		BigDecimal a = new BigDecimal("100");
		BigDecimal sumInsuredMutilRate = this.sumInsured.multiply(bigdecimalRate);
		BigDecimal annualPremium = sumInsuredMutilRate.divide(a);
		return annualPremium;
	}
	public BigDecimal calculatorPostedPremium() {
		Date effectiveDate = this.effectiveDate;
		Date expiryDate = this.expiryDate;
		long timeEffectiveDate = effectiveDate.getTime();
		long timeExpiryDate = expiryDate.getTime();
		long calEffectiveDate = timeEffectiveDate/1000 /60/60/24;
		long calExpiryDate = timeExpiryDate/1000/60/60/24;
		Long numberOfDays = calExpiryDate - calEffectiveDate;
		BigDecimal divide = new BigDecimal("365");
		BigDecimal numberOfDaysDecimal = new BigDecimal(numberOfDays);
		BigDecimal lastAnnualPremium = this.annualPremium;
		BigDecimal currentAnnualPremium = this.calculatorAnnualPremium();
		BigDecimal annualPremiumEx = currentAnnualPremium.subtract(lastAnnualPremium);
		BigDecimal postedPremiumMutiple = annualPremiumEx.multiply(numberOfDaysDecimal);
		BigDecimal postedPremiumNeed = postedPremiumMutiple.divide(divide,RoundingMode.HALF_EVEN);
			return postedPremiumNeed;
		}
	
}
