package com.revature.services;

import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.Admin;

public class AdminService {

	static AdminDAO ad = new AdminDAOImpl();

	public Admin adminLogin(String email, String password) {
		Admin user = null;
		try {
			user = ad.adminLogin(email, password);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		return user;

	}

}
