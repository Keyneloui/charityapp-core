package com.revature.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.DBException;
import com.revature.model.DonationRequest;
import com.revature.model.DonorActivity;
import com.revature.util.ConnectionUtil;

public class DonationDAOImpl implements DonationDAO {
	private static final String REQUEST_TYPE = "request_type";

	/**
	 * List to view all the donation request
	 * 
	 * @throws DBException
	 **/
	public List<DonationRequest> findAll() throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		List<DonationRequest> list = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select id,request_type,request_amount from donation_request order by id";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {

				DonationRequest dr = toRow(rs);
				list.add(dr);
			}
		} catch (SQLException e) {

			throw new DBException("Unable to display the donation list", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return list;
	}

	private DonationRequest toRow(ResultSet rs) throws DBException {
		DonationRequest dr = new DonationRequest();
		try {
			Integer requestId = rs.getInt("id");
			String requestType = rs.getString(REQUEST_TYPE);
			double requestAmount = rs.getDouble("request_amount");

			dr.setRequestId(requestId);
			dr.setRequestType(requestType);
			dr.setRequestAmount(requestAmount);

		} catch (SQLException e) {
			
			throw new DBException("Unable to display the list", e);
		}

		return dr;
	}

	/**
	 * Method to add the donations
	 * 
	 * @throws DBException
	 **/

	public void addDonations(DonationRequest dr) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into donation_request(id,request_type,request_amount) values ( ?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, dr.getRequestId());
			pst.setString(2, dr.getRequestType());
			pst.setDouble(3, dr.getRequestAmount());

			pst.executeUpdate();

		} catch (SQLException e) {

			throw new DBException("Unable to add request", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	/**
	 * Method to update the donations
	 * 
	 * @throws DBException
	 **/

	public void updateDonationByDonor(DonorActivity da) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update donation_request set request_amount= request_amount - ? where request_type=?";
			pst = con.prepareStatement(sql);
			pst.setString(2, da.getRequestType());
			pst.setDouble(1, da.getAmount());
			pst.executeUpdate();

		} catch (SQLException e) {
		
			throw new DBException("unable to update your request", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public void updateDonationByAdmin(DonationRequest drr) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update donation_request set request_amount= request_amount + ? where request_type=?";
			pst = con.prepareStatement(sql);
			pst.setString(2, drr.getRequestType());
			pst.setDouble(1, drr.getRequestAmount());
			pst.executeUpdate();

		} catch (SQLException e) {

			throw new DBException("unable to update request", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}

	/**
	 * Method to find the donation request
	 * 
	 * @throws DBException
	 **/

	public DonationRequest findByRequestType(String requestType) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		DonationRequest dr = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select id,request_type,request_amount from donation_request where request_type= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, requestType);
			rs = pst.executeQuery();

			if (rs.next()) {
				dr = toRow1(rs);
			}
		} catch (SQLException e) {
			
			throw new DBException("Invalid Request", e);

		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return dr;
	}

	private DonationRequest toRow1(ResultSet rs) throws DBException {
		DonationRequest dr = new DonationRequest();
		try {
			Integer requestId = rs.getInt("id");
			String requestType = rs.getString(REQUEST_TYPE);
			Double requestAmount = rs.getDouble("request_amount");

			dr.setRequestId(requestId);
			dr.setRequestType(requestType);
			dr.setRequestAmount(requestAmount);
		} catch (SQLException e) {
			throw new DBException("unable to implement", e);
		}
		return dr;

	}

	public DonationRequest request(String requestType) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DonationRequest dr = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from donation_request where request_type=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, requestType);

			rs = pst.executeQuery();
			if (rs.next()) {
				dr = new DonationRequest();
				dr.setRequestType(rs.getString(REQUEST_TYPE));
			}
		} catch (SQLException e) {

			throw new DBException("Invlid req", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}

		return dr;
	}

}
