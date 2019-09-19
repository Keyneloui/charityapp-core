package com.revature.dao;

import com.revature.exception.DBException;
import com.revature.model.Admin;

public interface AdminDAO {
	Admin adminLogin(String emailIds, String passwords) throws DBException;

	void admin(String email, String pwd) throws DBException;

}