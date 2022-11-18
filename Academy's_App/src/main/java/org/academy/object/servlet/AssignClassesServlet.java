package org.academy.object.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/classes")
public class AssignClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SQL_ASSIGN_CLASSES_QUERY="";
    public AssignClassesServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classes=(String)request.getParameter("classes");
		String subjects=(String)request.getParameter("subjects");
		request.setAttribute("Subject", subjects);
		request.setAttribute("classes", classes);
		
		RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
		rd.forward(request, response);
		
	}

}
