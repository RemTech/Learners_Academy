package org.academy.object.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/") /** root directory any path is allowed **/
public class ServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServicesServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws jakarta.servlet.ServletException, IOException  {
		String path=(String)request.getServletPath(); /** paths for the services **/
		
		switch(path) {
		
		case"/assign_classes":
			assignClasses(request,response);
			 break;
		case"/teacher_classes":
		     teacherClasses(request,response);
		     break;
		case"/student-address":
		     getStudents(request,response);
		     break;
		case"/teachers_class":
			teachersClass(request,response);
			break;
		case"/list-subject":
			listOfSubjects(request,response);
			break;
		case"/list-teachers":
			listOfTeachers(request,response);
			break;
		case"/list-classes":
			listOfClasses(request,response);
			
			default:
				/** Blank **/
		  }
	
}
	
	private void listOfTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("ListOfTeachers.jsp"); 
	      rd.forward(request, response);
		
	}
	private void listOfClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("ListOfClasses.jsp"); 
	      rd.forward(request, response);
		
	}
	private void listOfSubjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("ListOfSubjects.jsp"); 
	      rd.forward(request, response);
		
	}
	
	private void teachersClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("TeachersClass.jsp");
	       rd.forward(request, response);
	}
	
	private void getStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("StudentList.jsp");
	       rd.forward(request, response);
	}
	private void teacherClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("TeacherClasses.jsp");
	       rd.forward(request, response);
	}
	private void assignClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   RequestDispatcher rd= request.getRequestDispatcher("AssignClasses.jsp");
       rd.forward(request, response);
       
	}

}
