package com.revature.services;

import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImpl;
import com.revature.exception.DBException;
import com.revature.exception.ServiceException;
import com.revature.model.Admin;

public class AdminService {

	/**
	 * method to call the login Dao for admin login
	 * 
	 * @throws ServiceException
	 **/
	

	public Admin adminLogin(String email, String password) throws ServiceException {
		AdminDAO adminDao = new AdminDAOImpl();
		
		Admin user = null;
		try {

			user = adminDao.adminLogin(email, password);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());

		}
		return user;

	}

}
