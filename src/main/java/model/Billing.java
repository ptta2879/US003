package model;

public class Billing {
	private int id;
	private String billing;
	public Billing(int id, String billing) {
		this.id=id;
		this.billing=billing;
	}
	public String getBilling() {
		return this.billing;
	}
	public int getId() {
		return this.id;
	}
}
