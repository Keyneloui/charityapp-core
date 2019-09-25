package com.revature.maven_core;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.revature.exception.DBException;
import com.revature.util.ConnectionUtil;



public class ConnectionUtilTest {
	@Test
	public void connectionTest() throws DBException {
		Connection con = ConnectionUtil.getConnection();
		assertNotNull(con);
	}

}
