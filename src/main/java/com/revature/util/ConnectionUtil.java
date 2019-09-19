package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class ConnectionUtil {
	 private static final ConnectionUtil INSTANCE = new ConnectionUtil();
	    
	    private ConnectionUtil() {
	        //private Constructor
	    }
	    
	    public static ConnectionUtil getInstance() {
	        return INSTANCE;
	    }
	 

	public static Connection getConnection() {
//		String driverClassName = "com.mysql.cj.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/Charity_app";
//		String username = "root";
//		String password = "root";

		Connection con = null;
		 //try with resources, it will the close the reader.close automatically.
        try(InputStream inputStream  = INSTANCE.getClass()
                .getClassLoader().getResourceAsStream("application.properties")) {
            
            Properties prop = new Properties();
            // load a properties file
            prop.load(inputStream);

            String driverClassName = prop.getProperty("driverClassName");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Loading Credentials from Property Files:" + con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load the driver class");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to get DB Connection");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Unable to read property files");
        }

//
//		try {
//			Class.forName(driverClassName);
//			con = DriverManager.getConnection(url, username, password);
//			// System.out.println(con);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Unable to load the driver class");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Unable to get DB Connection");
//		}

		return con;

	}
	public static void main(String[] args)
	{
		getConnection();
	}

	public static void close(Connection con, PreparedStatement pst) {

		try {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {

		}

	}

	public static void close(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();

		} catch (Exception e) {

		}

	}

	public static void close(Connection con, Scanner scn) {
		try {
			if (scn != null)
				scn.close();
			if (con != null)
				con.close();

		} catch (Exception e) {

		}

	}
}
