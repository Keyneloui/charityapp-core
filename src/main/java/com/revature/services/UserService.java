package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.exception.ServiceException;
import com.revature.model.DonorActivity;
import com.revature.model.User;

public class UserService {
	static UserDAO userDao = new UserDAOImpl();
	/**
	 * method to call the register Dao for donor registration
	 * 
	 * @throws ServiceException
	 **/

	public void registerDonor(User user) throws ServiceException {
		try {

			userDao.register(user);
		} catch (DBException e) {

			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * method to call the login Dao for donor login
	 * 
	 * @throws ServiceException
	 **/

	public User donorLogin(String email, String password) throws ServiceException {
		User user = null;
		try {
			user = userDao.donorLogin(email, password);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return user;

	}
	/**
	 * method to call the display Dao for viewing the donor contributions
	 * 
	 * @throws ServiceException
	 **/

	public List<DonorActivity> findAll() throws ServiceException {
		List<DonorActivity> list = null;
		try {
			list = userDao.findAll();
		} catch (DBException e) {

			throw new ServiceException(e.getMessage());
		}
		return list;
	}
	/**
	 * method to call the  Dao for adding the donor contributions
	 * 
	 * @throws ServiceException
	 **/

	public void donorActivity(DonorActivity donorActivity) throws ServiceException {

		try {

			userDao.donorActivity(donorActivity);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	

}
