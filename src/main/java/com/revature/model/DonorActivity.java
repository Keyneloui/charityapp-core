package com.revature.model;

public class DonorActivity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	private String requestType;
	private int requestId;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	private String emailId;
	private double amount;

	@Override
	public String toString() {
		return "DonorActivity [name=" + name + ", requestType=" + requestType + ", requestId=" + requestId
				+ ", emailId=" + emailId + ", amount=" + amount + "]";
	}

}
