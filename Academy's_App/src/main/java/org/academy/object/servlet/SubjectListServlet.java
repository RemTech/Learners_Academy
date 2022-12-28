package org.academy.object.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.academy.object.entity.Subjects;
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


@WebServlet("/SubjectList")
public class SubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SQL_INSERT_SUBJECTS="INSERT INTO SUBJECTS VALUES(?,?)";
    private static final String FORWARD_TO_PAGE="subjectSuccess.jsp";
    private static final String SUCCESS_MESSAGE="<b> Record Created Successfully in the Database</b>";
    private static final String UNSUCCESSFUL_MESSAGE="<b> Record Not Created Successfully </b>";
    private String subjectName;
    private String subjectCode;
    
    public SubjectListServlet() {
    	super();
     }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection con=null ;
		 PreparedStatement ps=null;
	     SessionFactory sf=null;
	     Session session=null;
	     Transaction tx=null;
		   
		  try {
			  sf=HibernateDB.getSessionFactory();
			   session=sf.openSession();
			   tx=session.beginTransaction();
			   subjectName=(String)request.getParameter("subjectName");
			   subjectCode=(String)request.getParameter("subjectCode");
			   
			  /*Obj creation String subject_name, String subject_code */
			  Subjects subjects=new Subjects(subjectName,subjectCode);
			  session.save(subjects);
			  con=DBConnection.getDBConnection();
			  ps=con.prepareStatement(SQL_INSERT_SUBJECTS);
			  ps.setString(1, subjectName);
			  ps.setString(2, subjectCode);
			  tx.commit();
			  ps.executeUpdate();
			 }catch(HibernateException he) {
		         he.getMessage();
	         }catch(SQLException sql) {
	        	 sql.getMessage();
	         }
		  finally{
	        	session.close();
	        	sf.close();
		  }
  
		  displaySuccessMessage(request,response);
      }

	private void displaySuccessMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("SuccessMessage",SUCCESS_MESSAGE);
		request.setAttribute("SubjectName",subjectName);
		request.setAttribute("SubjectCode",subjectCode);
		RequestDispatcher rd=request.getRequestDispatcher(FORWARD_TO_PAGE);
		rd.forward(request, response);
		
   }
}

