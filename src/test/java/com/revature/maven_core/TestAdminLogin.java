package com.revature.maven_core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImpl;

import com.revature.exception.DBException;
import com.revature.model.Admin;


public class TestAdminLogin {

	@Test
	public void Admintest() throws DBException {

		String email = "k@gmail.com";
		String password = "123";
		AdminDAO admindao = new AdminDAOImpl();
		Admin admin = null;
		try {
			admin = admindao.adminLogin(email, password);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNotNull(admin);
	}
	@Test
	public void testInValidLogin() {

		String email = "";
		String password = "";
		AdminDAO admindao = new AdminDAOImpl();
		Admin admin = null;
		try {
			admin = admindao.adminLogin(email, password);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNull(admin);
	}

}
