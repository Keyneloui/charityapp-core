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
import com.revature.util.MessageConstant;

public class UserDAOImpl implements UserDAO {

	private static final String REQUEST_TYPE = "request_type";
	

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
			String sql = "select id,name,email_id,password from donor where email_id = ? and password = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email_id"));

			}
		} catch (SQLException e) {

			throw new DBException(MessageConstant.INVALID_LOGIN_CREDENTIALS);
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

			throw new DBException(MessageConstant.ACCOUNT_EXISTS);
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
		DonorActivity donorActivity = null;
		List<DonorActivity> list = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select name,request_type,amount_funded from donor d,activity a,donation_request dr where d.id=a.user_id and dr.id=a.request_id";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {

				donorActivity = toRow(rs);
				list.add(donorActivity);
			}

		} catch (SQLException e) {

			throw new DBException(MessageConstant.DONOR_LIST);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return list;

	}
	/**
	 * method to return the result set for viewing the donor list
	 * 
	 * @throws DBException
	 **/

	private DonorActivity toRow(ResultSet rs) throws DBException {
		DonorActivity donorActivity = null;

		try {

			String name = rs.getString("name");

			String requestType = rs.getString(REQUEST_TYPE);
			double amount = rs.getDouble("amount_funded");
			donorActivity = new DonorActivity();

			donorActivity.setName(name);

			donorActivity.setRequestType(requestType);
			donorActivity.setAmount(amount);
		} catch (SQLException e) {
			throw new DBException(MessageConstant.DONOR_LIST);
		}
		return donorActivity;
	}

	/**
	 * method to add donor contributions
	 * 
	 * @throws DBException
	 **/

	public void donorActivity(DonorActivity donorActivity) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into activity(user_id,amount_funded,request_id) values ( ?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, donorActivity.getId());
			pst.setDouble(2, donorActivity.getAmount());
			pst.setString(3, donorActivity.getRequestType());
			pst.executeUpdate();

		} catch (SQLException e) {

			throw new DBException(MessageConstant.DONOR_ACTIVITY);

		} finally {
			ConnectionUtil.close(con, pst);
		}

	}
	/**
	 * method to view the donor contributions
	 * 
	 * @throws DBException
	 **/

	public void displayActivity() throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql1 = "select email_id,amount,request_type from activity ";
			pst = con.prepareStatement(sql1);
			rs = pst.executeQuery();
			while (rs.next()) {

				StringBuilder content = new StringBuilder();
				content.append("donor Id\tAmount\tRequest Type\t\n");
				content.append(rs.getInt("email_id")).append("\t\t");
				content.append(rs.getString("amount")).append("\t");
				content.append(rs.getString(REQUEST_TYPE)).append("\t");
				content.append("\n");
				System.out.println(content);
			}
		} catch (SQLException e) {
			throw new DBException("Unable to process your request", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}

	}

	
}
