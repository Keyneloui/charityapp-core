package com.revature.services;

import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.Admin;
import com.revature.util.Logger;

public class AdminService {

	static AdminDAO ad = new AdminDAOImpl();

	public Admin adminLogin(String email, String password) throws DBException{
		Logger.getInstance();
		Admin user = null;
		try {
			user = ad.adminLogin(email, password);
		} catch (DBException e) {
			throw new DBException("Unable to login");
			
		}
		return user;

	}

}
