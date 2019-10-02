package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exception.DBException;
import com.revature.model.Admin;
import com.revature.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDAO {

	/**
	 * method for admin login
	 * 
	 * @throws DBException
	 **/

	public Admin adminLogin(String emailId, String password) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Admin user = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select id,name,email from admin where email = ? and password = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, emailId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new Admin();
                user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				}

		} catch (SQLException e) {

			throw new DBException("Unable to login", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return user;
	}

	public void admin(String email, String pwd) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update admin set email= ? where password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pwd);
			pst.executeUpdate();

		} catch (SQLException e) {

			throw new DBException("unable to update request", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}

}
