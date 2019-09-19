package com.revature.maven_core;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.revature.util.ConnectionUtil;



public class ConnectionUtilTest {
	@Test
	public void connectionTest() {
		Connection con = ConnectionUtil.getConnection();
		assertNotNull(con);
	}

}
