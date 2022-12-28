package org.academy.object.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.academy.object.entity.Classes;
import org.academy.object.entity.Subjects;
import org.academy.object.entity.Teachers;
import org.academy.object.util.DBConnection;
import org.academy.object.util.HibernateDB;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/teachers-to-class")
public class AssignTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String className;
	private String subjectName;
	private String subjectCode;
	private String age;
	private String gender;
	private String qualification;
	private String Class_Id;
	private final String SQL_QUERY="INSERT INTO TEACHERS VALUES(?,?,?,?,?,?,?,?,?)";
	private final String ASSIGN_TEACHERS="Assign-Teachers.jsp";
    public AssignTeachers() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Teachers to a Class*/
		
		 Connection con=null ;
		 PreparedStatement ps=null ;
		 SessionFactory sf=null;
		 Session session=null;
		 Transaction tx=null;
		 /* Front End Parameter */
		 
		  firstName=request.getParameter("firstName");
		  lastName=request.getParameter("lastName");
		  className=request.getParameter("className"); 
		  subjectName=request.getParameter("subjectName");
		  subjectCode=request.getParameter("subjectCode");
		  age=request.getParameter("age");
		  gender=request.getParameter("gender");
		  qualification=request.getParameter("qualification");
		  Class_Id=request.getParameter("class_id");
		 
		 /*Backend Logic*/
		 /*String first_name, String last_name, String qualification, String age, String gender,Subjects subjects, Classes classes*/ 
		 try {
		    
			sf=HibernateDB.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			/*Subjects Object*/
			Subjects subject = new Subjects(subjectName,subjectCode);
			session.save(subject);
			/*Classes object*/
			Classes classes=new Classes(Integer.parseInt(Class_Id));
			session.save(classes);
			/* Teacher Object */
			Teachers teacher =new Teachers(firstName,lastName,qualification,age,gender,subject,classes);
			session.save(teacher);
			/* DB Connection */
			con=DBConnection.getDBConnection();
			ps=con.prepareStatement(SQL_QUERY);
			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ps.setString(3,className);
			ps.setString(4,subjectName);
			ps.setString(5,subjectCode);
			ps.setString(6,age);
			ps.setString(7,gender);
			ps.setString(8,qualification);
			ps.setString(9,Class_Id);
			tx.commit();
			ps.executeUpdate();
		  }catch(HibernateException hex) {
		hex.getMessage();
		}catch(SQLException sql) {
			sql.getMessage();
		}
		 
		 displayPage(response,request);
	}

	private void displayPage(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		/*To build the display page for the next phase*/
		request.setAttribute("firstName",firstName);
		request.setAttribute("lastName",lastName);
		request.setAttribute("className",className);
		request.setAttribute("subjectName",subjectName);
		request.setAttribute("subjectCode",subjectCode);
		request.setAttribute("age",age);
		request.setAttribute("gender",gender);
		request.setAttribute("qualification",qualification);
		request.setAttribute("Class_Id",Class_Id);
		RequestDispatcher rd = request.getRequestDispatcher(ASSIGN_TEACHERS);
		rd.forward(request, response);
	}

}
