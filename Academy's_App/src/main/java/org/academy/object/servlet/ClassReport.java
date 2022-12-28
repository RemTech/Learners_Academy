package org.academy.object.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.academy.object.entity.Classes;
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

@WebServlet("/classReport")
public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String className;
    private Connection con;
    private Session session;
    private Transaction tx;
    private SessionFactory sf;
    private PreparedStatement ps;
    private ResultSet rs;
    private final String QUERY="SELECT * FROM CLASSES WHERE CLASS_ID=?";
    private String access;
    private String capacity;
    private String class_name;
    private String class_size;
    private String floor_level;
    private String student;
    private String subject;
    private String teachers;
    private final String displayPage="reportpage.jsp";
    
    public ClassReport() {
      super();  
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* to process the data for class report functionality */
		
		className=request.getParameter("className");
		try {
		    sf=HibernateDB.getSessionFactory();
		    session=sf.openSession();
		    tx=session.beginTransaction();
		    /* obj creation */
		    Classes cla=new Classes(Integer.parseInt(className));
		    session.save(cla);
		    con=DBConnection.getDBConnection();
		    ps=con.prepareStatement(QUERY);
		    ps.setNString(1,String.valueOf(cla));
		    tx.commit();
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	access=rs.getNString(1);
		    	capacity=rs.getNString(2);
		    	class_name=rs.getNString(3);
		    	class_size=rs.getNString(4);
		    	floor_level=rs.getNString(5);
		    	student=rs.getNString(6);
		    	subject=rs.getNString(7);
		    	teachers=rs.getNString(8);
		    }
		    
	}catch(HibernateException hex) {
		hex.getMessage();
	}catch(SQLException sql) {
		sql.getMessage();
	}

	displayResult(response,request);	
}


	private void displayResult(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		request.setAttribute("access",access);
		request.setAttribute("capacity",capacity);
		request.setAttribute("class_name",class_name);
		request.setAttribute("class_size",class_size);
		request.setAttribute("floor_level",floor_level);
		request.setAttribute("student",student);
		request.setAttribute("subject",subject);
		request.setAttribute("teachers",teachers);
		RequestDispatcher rd = request.getRequestDispatcher(displayPage); /* dispatches to another page */
		rd.forward(request, response);
	}
}
