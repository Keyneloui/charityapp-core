package com.revature.model;

public class DonationRequest {
	private int id;
	private String requestType;
	private Double requestAmount;
	

	public int getRequestId() {
		return id;
	}

	public void setRequestId(int requestId) {
		this.id = requestId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(Double requestAmount) {
		this.requestAmount = requestAmount;
	}

	

	@Override
	public String toString() {
		return "DonationRequest :Request Id=" + id + ", Request Type=" + requestType + ", Request Amount="
				+ requestAmount + ".";
	}

}
