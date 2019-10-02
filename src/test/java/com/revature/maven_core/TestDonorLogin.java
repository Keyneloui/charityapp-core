package com.revature.maven_core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.User;


public class TestDonorLogin {

	@Test
	public void test() throws DBException {

		String email = "k1@gmail.com";
		String password = "123";
		UserDAO dao = new UserDAOImpl();
		User user = null;
		try {
			user = dao.donorLogin(email, password);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNotNull(user);
	}
	@Test
	public void testInValidUserLogin() {
		String email = "";
		String password = "";
		UserDAO userdao = new UserDAOImpl();
		User userdetail = null;
		try {
			userdetail = userdao.donorLogin(email, password);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNull(userdetail);
	}

}
