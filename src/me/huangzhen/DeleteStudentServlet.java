package me.huangzhen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.huangzhen.dao.StudentDao;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String flowId = request.getParameter("flowId");
		
		StudentDao studentDao = new StudentDao();
		try
		{
			studentDao.deleteByFlowId( Integer.parseInt(flowId) );
			request.getRequestDispatcher("/success.jsp").forward(request, response);
			
		} catch (NumberFormatException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}
