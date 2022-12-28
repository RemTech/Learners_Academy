package org.academy.object.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.academy.object.entity.Classes;
import org.academy.object.entity.Students;
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


@WebServlet("/studentslist")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private Connection con;
    private Session session;
    private Transaction tx;
    private SessionFactory sf;
    private PreparedStatement ps;
    private ResultSet rs;
    private String firstName;
    private String lastName;
    private String age;
    private String classID;
    private Students students;
    private String students_id;
    private String firstname;
    private String lastname;
    private String ages;
    private String gender;
    private String  classes_id;
    private final String SQL_QUERY="SELECT * FROM STUDENTS WHERE CLASS_ID=?"; 
    
    public StudentList() {
       super(); 
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 /* getParameters*/	
	   firstName=request.getParameter(firstName);
	   lastName=request.getParameter(lastName);
	   age=request.getParameter(age);
	   classID=request.getParameter(classID);
	   try{
		   sf=HibernateDB.getSessionFactory();
		   session=sf.openSession();
		   tx=session.beginTransaction();
		   /*obj creation*/
		   Classes classes =new Classes(Integer.parseInt(classID));
		   session.save(classes);
		   /*String first_name, String last_name, int student_age, Classes classes*/
		   int studentAge=Integer.parseInt(age);
		   students= new Students(firstName,lastName,studentAge,classes);
		   session.save(students);
		   /*DB connection*/
		   con=DBConnection.getDBConnection();
		   ps=con.prepareStatement(SQL_QUERY);
		   ps.setString(1,classID);
		   tx.commit();
		   rs=ps.executeQuery();
		   while(rs.next()) {
			   
			 students_id=rs.getNString(1);
			 firstname= rs.getNString(2);
			 lastname=rs.getNString(3);
			 ages=rs.getNString(4);
			 gender=rs.getNString(5);
			 classes_id=rs.getNString(6);
		   }
		   
		   }catch(HibernateException hex) {
		   hex.getMessage(); 
		   }catch(SQLException sql) {
			  sql.getLocalizedMessage();
		   }
	   
	   displayResult(request,response);
	}

	private void displayResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("Student-ID",students_id);
		request.setAttribute("First-Name",firstname);
		request.setAttribute("Last-Name",lastname);
		request.setAttribute("Age",ages);
		request.setAttribute("Gender",gender);
		request.setAttribute("Class-ID",classes_id);
		RequestDispatcher rd = request.getRequestDispatcher("StudentResult.jsp");
		rd.forward(request, response);
		
	}

}
