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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	private int id;
	private double amount;

	@Override
	public String toString() {
		return "DonorActivity [name=" + name + ", requestType=" + requestType + ", requestId=" + requestId
				+ ", UserId=" + id + ", amount=" + amount + "]";
	}

}
