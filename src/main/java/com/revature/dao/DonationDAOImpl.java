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
import com.revature.util.MessageConstant;

public class DonationDAOImpl implements DonationDAO {
	private static final String REQUEST_TYPE = "requestType";

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

				DonationRequest donationRequest = toRow(rs);
				list.add(donationRequest);
			}
		} catch (SQLException e) {

			throw new DBException(MessageConstant.FUND_REQUEST);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return list;
	}
	/**
	 * Method to return result set for displaying the list
	 * 
	 * @throws DBException
	 **/

	private DonationRequest toRow(ResultSet rs) throws DBException {
		DonationRequest donationrequest = new DonationRequest();
		try {
			Integer requestId = rs.getInt("id");
			String requestType = rs.getString(REQUEST_TYPE);
			double requestAmount = rs.getDouble("request_amount");

			donationrequest.setRequestId(requestId);
			donationrequest.setRequestType(requestType);
			donationrequest.setRequestAmount(requestAmount);

		} catch (SQLException e) {

			throw new DBException(MessageConstant.REQUEST_PROCESSING);
		}

		return donationrequest;
	}

	/**
	 * Method to add the donations
	 * 
	 * @throws DBException
	 **/

	public void addDonations(DonationRequest donationRequest) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into donation_request(request_type,request_amount) values ( ?,?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, donationRequest.getRequestType());
			pst.setDouble(2, donationRequest.getRequestAmount());

			pst.executeUpdate();

		} catch (SQLException e) {

			throw new DBException(MessageConstant.FUND_REQUEST_ADDITION);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	/**
	 * Method to update the contributions made by donor 
	 * 
	 * @throws DBException
	 **/

	public void updateDonationByDonor(DonorActivity donorActivity) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update donation_request set request_amount= request_amount - ? where requestType=?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, donorActivity.getAmount());
			pst.setString(2, donorActivity.getRequestType());
			
			pst.executeUpdate();

		} catch (SQLException e) {

			throw new DBException(MessageConstant.FUND_REQUEST_ALTER);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}
	/**
	 * Method to alter the donations by admin
	 * 
	 * @throws DBException
	 **/


	public void updateDonationByAdmin(DonationRequest donationRequest) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update donation_request set request_amount= request_amount + ? where requestType=?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, donationRequest.getRequestAmount());
			pst.setString(2, donationRequest.getRequestType());
			
			pst.executeUpdate();

		} catch (SQLException e) {

			throw new DBException(MessageConstant.FUND_REQUEST_ALTER);
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
		DonationRequest donationRequest = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select request_type from donation_request where request_type= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, requestType);
			rs = pst.executeQuery();

			if (rs.next()) {
				donationRequest = toRow1(rs);
			}
		} catch (SQLException e) {

			throw new DBException(MessageConstant.FUND_REQUEST);

		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return donationRequest;
	}
	/**
	 * Method which returns the result set for finding  the donation request 
	 * 
	 * @throws DBException
	 **/

	private DonationRequest toRow1(ResultSet rs) throws DBException {
		DonationRequest donationRequest = new DonationRequest();
		try {
			Integer requestId = rs.getInt("id");
			String requestType = rs.getString(REQUEST_TYPE);
			Double requestAmount = rs.getDouble("request_amount");

			donationRequest.setRequestId(requestId);
			donationRequest.setRequestType(requestType);
			donationRequest.setRequestAmount(requestAmount);
		} catch (SQLException e) {
			throw new DBException(MessageConstant.REQUEST_PROCESSING);
		}
		return donationRequest;

	}
	/**
	 * Method to display the donation request
	 * 
	 * @throws DBException
	 **/

	public DonationRequest request(String requestType) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DonationRequest donationRequest = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from donation_request where request_type=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, requestType);

			rs = pst.executeQuery();
			if (rs.next()) {
				donationRequest = new DonationRequest();
				donationRequest.setRequestType(rs.getString(REQUEST_TYPE));
			}
		} catch (SQLException e) {

			throw new DBException(MessageConstant.FUND_REQUEST);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}

		return donationRequest;
	}

}
