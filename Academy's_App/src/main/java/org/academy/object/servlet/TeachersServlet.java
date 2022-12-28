package org.academy.object.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


@WebServlet("/teachers")
public class TeachersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Connection con=null ;
	private PreparedStatement ps=null;
	private PrintWriter pw=null ;
	private SessionFactory sf=null;
	private Session session=null;
	private Transaction tx=null;
	private static final String SQL_TEACHERS="INSERT INTO TEACHERS VALUES(?,?,?,?,?)";
	private static final String SUCCESS_MESSAGE="<b> Record Created Successfully in the Database</b>";
    private static final String UNSUCCESSFUL_MESSAGE="<b> Record Not Created Successfully </b>";
    private static final String FORWARD_TO_PAGE="teacherSuccess.jsp";
    private String firstName;
    private String lastName;
    private String qualifcation;
    private String age;
    private String gender;
    
    public TeachersServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Parameters from front-end*/
		/*String first_name, String last_name, String qualification, String age, String gender*/
		 firstName=request.getParameter("firstName");
		 lastName=request.getParameter("lastName");
		 qualifcation=request.getParameter("qualification");
		 age=request.getParameter("age");
		 gender=request.getParameter("gender");
		
		 /*Db connection*/
		try {
			con=DBConnection.getDBConnection();
			sf=HibernateDB.getSessionFactory();
			session=sf.openSession();
		    tx=session.beginTransaction();
		    Teachers teachers=new Teachers(firstName,lastName,qualifcation,age,gender);	    
		    session.save(teachers);
		  ps=con.prepareStatement(SQL_TEACHERS);
		    ps.setString(1, firstName);
		    ps.setString(2, lastName);
		    ps.setString(3, qualifcation);
		    ps.setString(4, age);
		    ps.setString(5, gender);
		    tx.commit();
		    ps.executeUpdate();
		    }catch(SQLException sql) {
		sql.getMessage();
	}catch(HibernateException hex) {
		hex.getMessage();	
	}
	finally {
		sf.close();
		session.close();
		
	}
     displayPage(request,response);
}


	private void displayPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("SuccessMessage",SUCCESS_MESSAGE);
		request.setAttribute("firstName",firstName);
		request.setAttribute("lastName",lastName);
		request.setAttribute("qualification",qualifcation);
		request.setAttribute("age",age);
		request.setAttribute("gender",gender);
		RequestDispatcher rd=request.getRequestDispatcher(FORWARD_TO_PAGE);
		rd.forward(request, response);
	}
}
