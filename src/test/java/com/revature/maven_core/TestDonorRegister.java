package com.revature.maven_core;

import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.User;


public class TestDonorRegister {

	@Test
	public void Donortest() throws DBException {
		User user = new User();
		
		user.setName(" ");
		user.setEmail("a@gmail.com");
		user.setPassword("mypass");
		UserDAO ob = new UserDAOImpl();
		ob.register(user);

	}

}
