package com.revature.maven_core;

import java.util.List;

import org.junit.Test;

import com.revature.dao.DonationDAO;
import com.revature.dao.DonationDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.DonationRequest;



public class TestDonationRequest {

	@Test
	public void DonationRequesttest() throws DBException {

		DonationRequest request = new DonationRequest();

		request.setRequestType("FOOD");

		request.setRequestAmount(500.40);

		request.setRequestId(1);

		DonationDAO dao = new DonationDAOImpl();
		List<DonationRequest> list = dao.findAll();

	}

}
