package com.revature.services;

import java.util.List;

import com.revature.dao.DonationDAO;
import com.revature.dao.DonationDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.DonationRequest;
import com.revature.model.DonorActivity;

public class DonationService {

	static DonationDAO dao = new DonationDAOImpl();
	static UserDAO udao = new UserDAOImpl();

	public List<DonationRequest> findAll() throws DBException {
		List<DonationRequest> list = null;
		try {
			list = dao.findAll();
		} catch (DBException e) {
			throw new DBException("Unable to display list", e);
		}
		return list;

	}

	public void addDonations(DonationRequest dr) throws DBException {
		try {
			dao.addDonations(dr);
		} catch (DBException e) {
			throw new DBException("Unable to add donation,Request Type and Request Id already exists", e);

		}
	}

	public void contributeDonation(DonorActivity da) throws DBException {
		try {
			String requestType = null;
			dao.findByRequestType(requestType);
			dao.updateDonationByDonor(da);
			udao.donorActivity(da);
		} catch (DBException e) {
			throw new DBException("Give a valid input");
		}

	}

	public void addDonation(DonationRequest dr) {
		try {
			dao.addDonations(dr);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateDonations(DonorActivity da) {
		try {
			dao.updateDonationByDonor(da);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateDonationss(DonationRequest drr) throws DBException {
		try {
			String requestType = null;
			dao.findByRequestType(requestType);
			dao.updateDonationByAdmin(drr);
		} catch (DBException e) {

			throw new DBException("Give a valid input");

		}
	}

	public DonationRequest findByRequestType(String requestType) throws DBException {
		DonationRequest dr = null;
		try {
			dao.findByRequestType(requestType);
		} catch (DBException e) {
			throw new DBException("Give a valid input");

		}
		return dr;

	}

	public DonationRequest request(String requestType) throws DBException {
		DonationRequest dr = null;
		try {
			dao.request(requestType);
		} catch (DBException e) {
			throw new DBException("Unable to display donations");

		}
		return dr;

	}

	

}
