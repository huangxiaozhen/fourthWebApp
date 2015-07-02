package me.huangzhen;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.huangzhen.dao.*;

@WebServlet("/listAllStudent")
public class ListAllStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		StudentDao studentDao = new StudentDao();
		try
		{
			List<Student> students = studentDao.getAll();

			request.setAttribute("students", students);

			request.getRequestDispatcher("/student2.jsp").forward(request,
					response);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}
