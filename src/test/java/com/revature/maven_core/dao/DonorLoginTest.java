package com.revature.maven_core.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.DBException;
import com.revature.model.User;
import com.revature.util.Logger;

public class DonorLoginTest {

	//@Test
	public void donorLoginTest() {
		UserDAO userdao=new UserDAOImpl();
	
		User donor=new User();
		String email="k@gmail.com";
		String password="Keyne123";
		
		try {
			donor=userdao.donorLogin(email, password);
			assertNull(donor);
		} catch (DBException e) {
			Logger.debug(e.getMessage());
		}
		
		
	}

}
