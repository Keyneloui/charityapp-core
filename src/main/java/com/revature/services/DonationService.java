package com.revature.services;

import java.util.List;

import com.revature.dao.DonationDAO;
import com.revature.dao.DonationDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.DonationRequest;
import com.revature.model.DonorActivity;
import com.revature.model.User;

public class DonationService {

	static DonationDAO dao = new DonationDAOImpl();
	static UserDAO udao = new UserDAOImpl();

	public List<DonationRequest> findAll()throws DBException {
		List list = null;
		try {
			list=dao.findAll();
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public List<DonationRequest> findAllDonation() {
		List list = null;
		try {
			dao.findAllDonation();
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public void addDonations(DonationRequest dr) throws DBException {
		try {
			dao.addDonations(dr);
		} catch (DBException e) {
			throw new DBException("Unable to add donation,Request Type and Request Id already exists", e);
			// System.out.println(e.getMessage());
		}
	}

	public void contributeDonation(DonorActivity da) throws DBException {
		try {
			String requestType = null;
			dao.findByRequestType(requestType);
			dao.updateDonations(da);
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
			dao.updateDonations(da);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateDonationss(DonationRequest drr)throws DBException {
		try {
			String requestType=null;
			dao.findByRequestType(requestType);
			dao.updateDonationss(drr);
		} catch (DBException e) {
			//System.out.println(e.getMessage());
			throw new DBException("Give a valid input");

		}
	}

	public DonationRequest findByRequestType(String requestType) {
		DonationRequest dr = null;
		try {
			dao.findByRequestType(requestType);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		return dr;

	}

	public DonationRequest request(String requestType) {
		DonationRequest dr = null;
		try {
			dao.request(requestType);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		return dr;

	}

	public void deleteDonation(DonationRequest drr) {
		try {
			dao.deleteDonation(drr);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}

}
