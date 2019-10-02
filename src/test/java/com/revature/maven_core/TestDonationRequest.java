package com.revature.maven_core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.dao.DonationDAO;
import com.revature.dao.DonationDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.DonationRequest;

public class TestDonationRequest {

	@Test
	public void DonationRequest() throws DBException {
		DonationRequest dr = null;
		DonationDAO dao = new DonationDAOImpl();
		dr = new DonationRequest();

		dr.setRequestType("Food");
		dr.setRequestId(1);
		dr.setRequestAmount(10000.00);

		try {
			dao.addDonations(dr);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNotNull(dr);
	}

	@Test
	public void InvalidDonationRequest() throws DBException {
		DonationRequest dr = null;
		DonationDAO dao = new DonationDAOImpl();
		dr = new DonationRequest();

		dr.setRequestType("Food");
		dr.setRequestId(1);
		dr.setRequestAmount(10000.00);

		try {
			dao.addDonations(dr);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNull(dr);
	}
}
