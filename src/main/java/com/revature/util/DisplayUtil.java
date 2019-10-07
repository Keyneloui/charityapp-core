package com.revature.util;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.DonationRequest;
import com.revature.model.DonorActivity;

public class DisplayUtil {

	public static void display(List<DonationRequest> list) {
		StringBuilder content = new StringBuilder();
		content.append("Request Id\tRequest Type\tRequest Amount\n");
		for (DonationRequest dr : list) {
			content.append(dr.getRequestId()).append("\t\t");
			content.append(dr.getRequestType()).append("\t\t");
			content.append(dr.getRequestAmount()).append("\t\t");

			content.append("\n");
		}

		System.out.println(content);
	}

	public static void displays(List<DonationRequest> list) {
		StringBuilder content = new StringBuilder();
		content.append("Request Type\tRequest Amount\n");
		for (DonationRequest dr : list) {
			content.append(dr.getRequestType()).append("\t\t");
			content.append(dr.getRequestAmount()).append("\t");

			content.append("\n");
		}

		System.out.println(content);
	}

	/**
	 * View Donor Details
	 * 
	 * @throws DBException
	 **/
	public static void donorDetails() throws DBException {
		UserDAO iudao = new UserDAOImpl();
		try {
			List<DonorActivity> list = iudao.findAll();
			displayDonor(list);
		} catch (DBException e) {
			System.out.println(e.getMessage());
			throw new DBException("Unable to process the request", e);
		}

	}

	private static void displayDonor(List<DonorActivity> list) {
		StringBuilder content = new StringBuilder();
		content.append(" Name\tEmail\t\n");
		for (DonorActivity user : list) {

			content.append(user.getName()).append("\t");
			content.append(user.getId()).append("\t");
			content.append("\n");
		}
		System.out.println(content);
	}

	/**
	 * View Donor Activity
	 * 
	 * @throws DBException
	 **/
	public static void donorActivity() throws DBException {
		UserDAO udao = new UserDAOImpl();
		try {
			udao.displayActivity();
		} catch (DBException e) {
			System.out.println(e.getMessage());
			throw new DBException("Unable to process the request", e);

		}
	}

}
