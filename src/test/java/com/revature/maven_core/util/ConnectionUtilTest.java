package com.revature.maven_core.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.revature.exception.DBException;
import com.revature.util.ConnectionUtil;

public class ConnectionUtilTest {

	//@Test
	public void connectionUtilTest() {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			assertNotNull(con);

		} catch (DBException e) {
			
		}
				
	}

}
