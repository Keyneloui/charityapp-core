package com.revature.services;

import java.util.List;

import com.revature.dao.DonationDAO;
import com.revature.dao.DonationDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.exception.ServiceException;
import com.revature.model.DonationRequest;
import com.revature.model.DonorActivity;

public class DonationService {

	static DonationDAO donationDao = new DonationDAOImpl();
	static UserDAO udao = new UserDAOImpl();

	public List<DonationRequest> findAll() throws ServiceException {
		List<DonationRequest> list = null;
		try {
			list = donationDao.findAll();
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return list;

	}

	public void addDonations(DonationRequest donationrequest) throws ServiceException {
		try {
			donationDao.addDonations(donationrequest);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());

		}
	}

	public void contributeDonation(DonorActivity donorActivity) throws ServiceException {
		try {

			donationDao.updateDonationByDonor(donorActivity);
			udao.donorActivity(donorActivity);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public void addDonation(DonationRequest donationRequest) throws ServiceException {
		try {
			donationDao.addDonations(donationRequest);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void updateDonations(DonorActivity donorActivity) throws ServiceException {
		try {
			donationDao.updateDonationByDonor(donorActivity);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void updateDonationsByAdmin(DonationRequest donationRequest) throws ServiceException {
		try {

			donationDao.updateDonationByAdmin(donationRequest);
		} catch (DBException e) {

			throw new ServiceException(e.getMessage());

		}
	}

	public DonationRequest findByRequestType(String requestType) throws ServiceException {
		DonationRequest donationRequest = null;
		try {
			donationDao.findByRequestType(requestType);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return donationRequest;

	}

	public DonationRequest request(String requestType) throws ServiceException {
		DonationRequest donationRequest = null;
		try {
			donationDao.request(requestType);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return donationRequest;

	}

}
