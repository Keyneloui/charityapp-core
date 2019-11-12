package com.revature.dao;

import java.util.List;

import com.revature.exception.DBException;

import com.revature.model.DonorActivity;
import com.revature.model.User;

public interface UserDAO {

	void register(User user) throws DBException;

	User donorLogin(String email, String password) throws DBException;

	List<DonorActivity> findAll() throws DBException;

	void donorActivity(DonorActivity da) throws DBException;
	
	void displayActivity() throws DBException;
	
	
}