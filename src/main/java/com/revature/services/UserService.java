package com.revature.services;

import java.util.List;


import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;

import com.revature.model.DonorActivity;
import com.revature.model.User;

public class UserService {
	static UserDAO udao = new UserDAOImpl();

	public void registerDonor(User user) throws DBException {
		try {

			udao.register(user);
		} catch (DBException e) {
			// System.out.println(e.getMessage());
			throw new DBException("Name/Email Id already exists,Register with a new Email and Name", e);
		}
	}

	public User donorLogin(String email, String password) {
		User user = null;
		try {
			user = udao.donorLogin(email, password);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		return user;

	}

	public List<DonorActivity> findAll() throws DBException {
		List<DonorActivity> list = null;
		try {
			list = udao.findAll();
		} catch (DBException e) {
			// System.out.println(e.getMessage());
			throw new DBException("Unable to request your process", e);
		}
		return list;
	}

	public void donorActivity(DonorActivity da) {

		try {

			udao.donorActivity(da);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}

	}

	public void displayActivity()

	{
		try {
			udao.displayActivity();
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}

}
