package com.problem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		
		LoginDao dao= new LoginDao();
		if(dao.check(id, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("report.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}

	}

	
}