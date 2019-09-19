package com.revature.maven_core;

import org.junit.Test;

import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImpl;

import com.revature.exception.DBException;
import com.revature.model.Admin;


public class TestAdminLogin {

	@Test
	public void Admintest() throws DBException {

		String email = "k@gmail.com";
		String pwd = "123";
		System.out.println("Email:" + email);
		System.out.println("password" + pwd);
		AdminDAO ad=new AdminDAOImpl();
		Admin admin = ad.adminLogin(email, pwd);
	}

}
