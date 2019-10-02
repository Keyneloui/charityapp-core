package com.revature.maven_core;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.revature.exception.DBException;
import com.revature.util.ConnectionUtil;



public class ConnectionUtilTest {
	@Test
	public void connectionTest() throws DBException {
		Connection connection = null;;
		try {
			connection = ConnectionUtil.getConnection();
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		assertNotNull(connection);
	}

}
