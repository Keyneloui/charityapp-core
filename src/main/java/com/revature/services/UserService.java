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

			throw new DBException("Name/Email Id already exists,Register with a new Email and Name", e);
		} 
	}

	public User donorLogin(String email, String password) throws DBException {
		User user = null;
		try {
			user = udao.donorLogin(email, password);
		} catch (DBException e) {
			throw new DBException("Unable to login");
		}
		return user;

	}

	public List<DonorActivity> findAll() throws DBException {
		List<DonorActivity> list = null;
		try {
			list = udao.findAll();
		} catch (DBException e) {

			throw new DBException("Unable to request your process", e);
		}
		return list;
	}

	public void donorActivity(DonorActivity da) throws DBException {

		try {

			udao.donorActivity(da);
		} catch (DBException e) {
			throw new DBException("unable to display activity");
		}

	}

}
