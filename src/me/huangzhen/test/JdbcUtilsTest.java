package me.huangzhen.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import me.huangzhen.db.JdbcUtils;

import org.junit.After;
import org.junit.Test;

public class JdbcUtilsTest
{

	@Test
	public void testGetConnection() throws SQLException
	{
		Connection connection = JdbcUtils.getConnection();
		System.out.println( "Connection:" + connection );
	}

}
