package com.revature.maven_core;

import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.User;


public class TestDonorLogin {

	@Test
	public void test() throws DBException {

		String email = "a@gmail.com";
		String pwd = "mypass";
		System.out.println("Email:" + email);
		System.out.println("password+" + pwd);
		UserDAO ud = new UserDAOImpl();
		User userLogin = ud.donorLogin(email, pwd);
	}

}
