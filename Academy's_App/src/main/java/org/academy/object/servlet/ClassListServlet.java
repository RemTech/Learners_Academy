package org.academy.object.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.academy.object.entity.Classes;
import org.academy.object.util.DBConnection;
import org.academy.object.util.HibernateDB;
//import org.hibernate.Hibernate;
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


@WebServlet("/ClassListServlet")
public class ClassListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String Class_Name;
    private String Class_Capacity;
    private String Class_Accessibility;
    private String Class_Size;
    private String Floor_Level;
    private static final String SQL_CLASSES_INSERT="insert into classes values(?, ?, ?, ?, ?)";     
    private static final String SUCCESS_MESSAGE="Record Was Saved Correctly";
    private static final String UNSUCCESSFUL_MESSAGE="Record Was Not Saved Correctly";
    private static final String FORWARD_TO_PAGE_SUCCESS="SavedClasses.jsp";
    public ClassListServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection con=null ;
		 PreparedStatement ps=null ;
		 PrintWriter pw=null ;
		 SessionFactory sf=null;
		 Session session=null;
		 Transaction tx=null;
		 
		/*Hibernate and JDBC Connection*/
	 	try { 
	 		
	 		 sf=HibernateDB.getSessionFactory();
	 		 session=sf.openSession();
	 		 tx=session.beginTransaction();
	 		 Class_Name=(String)request.getParameter("className");
		 	 Class_Capacity=(String)request.getParameter("classCapacity");
		     Class_Accessibility=(String)request.getParameter("classAccessibility");
		 	 Class_Size=(String)request.getParameter("classSize");
		 	 Floor_Level=(String)request.getParameter("floorLevel");
	 		/* Obj Creation*/
	 		Classes cla =new Classes(Floor_Level,Class_Capacity,Class_Accessibility,Class_Name,Class_Size);
	 		session.save(cla);
	 		con=DBConnection.getDBConnection();
	 		ps=con.prepareStatement(SQL_CLASSES_INSERT);
	 		ps.setString(1,Floor_Level);
	 		ps.setString(2,Class_Capacity);
	 		ps.setString(3,Class_Accessibility);
	 		ps.setString(4,Class_Name);
	 		ps.setString(5,Class_Size);
	 		tx.commit();
	 		int result=ps.executeUpdate();
	 		if(result>0) {
	 		 /* Switch Case here for extra validation*/
	 		}else{
	 			pw.print(UNSUCCESSFUL_MESSAGE);
	 		}
	        }catch(HibernateException heb) {
                 heb.getMessage();
	        }catch(SQLException heb) {
                 heb.getMessage();
	        }finally{
	        	session.close();
	        	sf.close();
	        	try {
					ps.clearParameters();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        	    try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	       }
	        
	 	  displayResult(request,response);
}

	private void displayResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("SuccessMessage",SUCCESS_MESSAGE);
		request.setAttribute("ClassName",Class_Name);
		request.setAttribute("ClassCapacity",Class_Capacity);
		request.setAttribute("ClassAccessibility",Class_Accessibility);
		request.setAttribute("Class-size",Class_Size);
		RequestDispatcher rd=request.getRequestDispatcher(FORWARD_TO_PAGE_SUCCESS);
		rd.forward(request, response);
		
	}
}
