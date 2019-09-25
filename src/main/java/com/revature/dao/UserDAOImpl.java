package com.revature.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.DBException;

import com.revature.model.DonorActivity;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	/**
	 * method for donor login
	 * 
	 * @throws DBException
	 **/
	public User donorLogin(String email, String password) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "select name,email_id,password from donor where email_id = ? and password = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User();

				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email_id"));
				user.setPassword(rs.getString("password"));
				System.out.println("Login Success");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DBException("Unable to login", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}

		return user;
	}

	/**
	 * method for donor register
	 * 
	 * @throws DBException
	 **/

	public void register(User user) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into donor(name,email_id,password) values (?,?,?)";

		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());

			pst.executeUpdate();

		} catch (SQLException e) {

			throw new DBException("Email,Name already exists\nRegister with a new Email and Name", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	/**
	 * method to view the donor list
	 * 
	 * @throws DBException
	 **/
	public List<DonorActivity> findAll() throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DonorActivity da = null;
		List<DonorActivity> list = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select name,request_type,amount from donor d,activity a where d.email_id=a.email_id";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {

				da = toRow(rs);
				list.add(da);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DBException("Unable to list Donor", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return list;

	}

	private DonorActivity toRow(ResultSet rs) throws DBException {
		DonorActivity da = null;

		try {

			String name = rs.getString("name");

			String requestType = rs.getString("request_type");
			double amount = rs.getDouble("amount");
			da = new DonorActivity();

			da.setName(name);

			da.setRequestType(requestType);
			da.setAmount(amount);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DBException("Unable to display", e);
		}
		return da;
	}

	/**
	 * method to add donor activity
	 * 
	 * @throws DBException
	 **/

	public void donorActivity(DonorActivity da) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into activity(email_id,amount,request_type) values ( ?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, da.getEmailId());
			pst.setDouble(2, da.getAmount());
			pst.setString(3, da.getRequestType());
			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DBException("Unable to display the donor activity", e);

		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	/**
	 * method to view donor activity
	 * 
	 * @throws DBException
	 **/

}
