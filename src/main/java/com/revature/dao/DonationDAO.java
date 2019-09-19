package com.revature.dao;

import java.util.List;

import com.revature.exception.DBException;
import com.revature.model.DonationRequest;
import com.revature.model.DonorActivity;

public interface DonationDAO {
	List<DonationRequest> findAll() throws DBException;

	List<DonationRequest> findAllDonation() throws DBException;

	void addDonations(DonationRequest dr) throws DBException;

	void addDonation(DonationRequest dr) throws DBException;

	void updateDonations(DonorActivity da) throws DBException;

	void updateDonationss(DonationRequest drr) throws DBException;

	DonationRequest findByRequestType(String requestType) throws DBException;

	DonationRequest request(String requestType) throws DBException;

	void deleteDonation(DonationRequest drr) throws DBException;

}
