package com.revature.maven_core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.User;


public class TestDonorRegister {

	@Test
	public void testRegister(User user) throws DBException {
		String name="Keyne";
		String email = "k1@gmail.com";
		String password = "123";
		user = new User();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		UserDAO dao = new UserDAOImpl();
		try {
			 dao.register(user);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNotNull(user);
		
	}
	@Test
	public void inValidRegister(User user) throws DBException {
		String name="Keyne";
		String email = "k1@gmail.com";
		String password = "123";
		user = new User();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		UserDAO dao = new UserDAOImpl();
	
		try {
			dao.register(user);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNull(user);
		
	}

}
