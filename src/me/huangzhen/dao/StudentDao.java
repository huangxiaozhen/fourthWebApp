package me.huangzhen.dao;

import me.huangzhen.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentDao
{

	public void deleteByFlowId(int flowId) throws ClassNotFoundException, IOException
	{
		// 1. 获取数据库连接数据
		Properties properties = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"jdbc.properties");
		properties.load(is);

		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String mysqlDriver = properties.getProperty("driver");
		String jdbcUrl = properties.getProperty("jdbcUrl");

		Class.forName(mysqlDriver);

		Connection connection = null;
		PreparedStatement ps = null;

		List<Student> students = new ArrayList<Student>();
		Student student;

		try
		{
			connection = DriverManager.getConnection(jdbcUrl, user, password);

			String sql = "delete from test_student where flow_id = ?";

			ps = connection.prepareStatement(sql);

			ps.setInt(1, flowId);

			ps.executeUpdate();

			// 获取每一个学生的信息，并且加入到list中

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{

			if (ps != null)
			{
				try
				{
					ps.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

		}

	}

	public List<Student> getAll() throws IOException, ClassNotFoundException
	{
		// 1. 获取数据库连接数据
		Properties properties = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"jdbc.properties");
		properties.load(is);

		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String mysqlDriver = properties.getProperty("driver");
		String jdbcUrl = properties.getProperty("jdbcUrl");

		Class.forName(mysqlDriver);

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Student> students = new ArrayList<Student>();
		Student student;

		try
		{
			connection = DriverManager.getConnection(jdbcUrl, user, password);

			String sql = "select * from test_student";

			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			// 获取每一个学生的信息，并且加入到list中
			while (rs.next())
			{
				student = new Student();
				student.setFlowId(rs.getInt(1));
				student.setType(rs.getInt(2));
				student.setIdCard(rs.getString(3));
				student.setExamCard(rs.getString(4));
				student.setStudentName(rs.getString(5));
				student.setLocation(rs.getString(6));
				student.setGrade(rs.getInt(7));

				students.add(student);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if (ps != null)
			{
				try
				{
					ps.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

		}

		return students;

	}

}
