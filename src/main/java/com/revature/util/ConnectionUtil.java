package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.exception.DBException;

public class ConnectionUtil {

	private static final String UNABLE_TO_CLOSE_THE_CONNECTION = "Unable to close the connection";

	public static Connection getConnection() throws DBException {
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Charity_app";
		String username = "root";
		String password = "root";

		Connection con = null;

		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {

			throw new DBException("Unable to load the driver class");
		} catch (SQLException e) {

			throw new DBException("Unable to get DB Connection");
		}

		return con;

	}

	public static void main(String[] args) {
		try {
			getConnection();
		} catch (DBException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void close(Connection con, PreparedStatement pst) throws DBException {

		try {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			throw new DBException(UNABLE_TO_CLOSE_THE_CONNECTION);

		}

	}

	public static void close(Connection con, PreparedStatement pst, ResultSet rs) throws DBException {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			throw new DBException(UNABLE_TO_CLOSE_THE_CONNECTION);

		}

	}

	public static void close(Connection con, Scanner scn) throws DBException {
		try {
			if (scn != null)
				scn.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			throw new DBException(UNABLE_TO_CLOSE_THE_CONNECTION);

		}

	}
}
