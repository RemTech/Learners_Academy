package org.academy.object.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.academy.object.entity.Classes;
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

@WebServlet("/classes")
public class AssignClassesServlet extends HttpServlet {
//	public Connection con ;
//	public PreparedStatement ps ;
//	public PrintWriter pw ;
//	public SessionFactory sf;
//	public Session session;
//	public Transaction tx;
	private static final String SUCCESS_MESSAGE = "<b>Classes Assigned to Subjects Successfully</b>";
	private static final String UNSUCCESSFUL_MESSAGE = "<b>Classes not Assigned to Subjects Successfully</b>";
	private static final long serialVersionUID = 1L;
	private static final String SQL_ASSIGN_CLASSES_QUERY = "INSERT INTO CLASSES_SUBJECTS VALUES(?,?,?,?,?,?,?)"; /* INSERT statement  */
																									
																										 
													 													

	public AssignClassesServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 Connection con=null ;
		 PreparedStatement ps=null ;
		 PrintWriter pw=null ;
		 SessionFactory sf=null;
		 Session session=null;
		 Transaction tx=null;
		 
		String floorLevel = (String) request.getParameter("floorlevel");
		String capacity = (String) request.getParameter("capacity");
		String accessible = (String) request.getParameter("accessible");
		String className = (String) request.getParameter("classname");
		String class_size = (String) request.getParameter("class-size");
		String subject_Name = (String) request.getParameter("subject-name");
		String subject_Code = (String) request.getParameter("subject-code");
		
		/* Hibernate Session && JDBC configuration **/
		try {
			
		    sf=HibernateDB.getSessionFactory();
		    session=sf.openSession();
		    tx=session.beginTransaction();
		    List<Subjects> sub = new ArrayList<>();
			sub.add(new Subjects(subject_Name, subject_Code));
			session.save(sub);
			List<Classes> cla = new ArrayList<>();
			cla.add(new Classes(floorLevel, capacity, accessible, className,class_size)); 
			session.save(cla);
			
			con = DBConnection.getDBConnection();
			ps = con.prepareStatement(SQL_ASSIGN_CLASSES_QUERY);
			ps.setString(1,floorLevel);
			ps.setString(2,capacity);
			ps.setString(3,accessible);
			ps.setString(4,className);
			ps.setString(5,class_size);
			ps.setString(6,subject_Name);
			ps.setString(7,subject_Code);
			tx.commit();
			int result = ps.executeUpdate();
			if (result > 0) {
                pw = response.getWriter();
				pw.print(SUCCESS_MESSAGE);

			} else {

				pw.print(UNSUCCESSFUL_MESSAGE);
			}

		} catch (SQLException sql) {

		}catch(HibernateException he) {
			he.getMessage();
		}
		finally {
			    //session.close();
			    //sf.close();
                
				
	      }
		displayResult(request, response); /*to rethink the placement of this in the scheme of things*/

	}

	private void displayResult(HttpServletRequest request, HttpServletResponse response) {

		//request.setAttribute("SuccessMessage", SUCCESS_MESSAGE);
		//request.setAttribute("UnsuccessfulMessage", UNSUCCESSFUL_MESSAGE);
		RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
		try {

			rd.forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
