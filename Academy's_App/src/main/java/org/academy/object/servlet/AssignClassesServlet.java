package org.academy.object.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

@WebServlet("/assigns-class")
public class AssignClassesServlet extends HttpServlet {
	private static final String SUCCESS_MESSAGE = "<b>Classes Assigned to Subjects Successfully</b>";
	private static final String UNSUCCESSFUL_MESSAGE = "<b>Classes not Assigned to Subjects Successfully</b>";
	private static final long serialVersionUID = 1L;
	private static final String SQL_ASSIGN_QUERY_CLASSES = "INSERT INTO CLASSES VALUES(?,?,?,?,?)"; /* INSERT statement  */
	private static final String SQL_ASSIGN_QUERY_SUBJECTS = "INSERT INTO SUBJECTS VALUES(?,?)";
	private static final String SQL_ASSIGN_QUERY_CLASSES_SUBJECTS = "INSERT INTO subject_classes VALUES(?,?)";
	private String floorLevel;
	private String accessible;
	private String capacity;
	private String className;
	private String class_size;
	private String subject_Name;
	private String subject_Code;
	//private ResultSet rs1_classes;
	//private ResultSet rs2_subjects;
	private Connection con ;
	private PreparedStatement ps ;
	private SessionFactory sf;
	private Session session;
	private Transaction tx;
	private ResultSet rs1_classes;
	private ResultSet rs2_subjects;
	private int rsClass;
	private int rsSubject;
	public AssignClassesServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 
		
		 
		/* Hibernate Session && JDBC configuration **/
		try {
			
		    sf=HibernateDB.getSessionFactory();
		    session=sf.openSession();
		    tx=session.beginTransaction();
		     /* Classes parameters */
		     floorLevel = (String) request.getParameter("floorLevel");
		     className = (String) request.getParameter("className");
			 capacity = (String) request.getParameter("capacity");
			 accessible = (String) request.getParameter("accessible");
			 class_size = (String) request.getParameter("class-size");
			 /* Subjects parameters */
			 subject_Name = (String) request.getParameter("subject-name");
		     subject_Code = (String) request.getParameter("subject-code");
		      
		    List<Subjects> sub = new ArrayList<>();
			sub.add(new Subjects(subject_Name, subject_Code));
			session.save(sub);
			List<Classes> cla = new ArrayList<>();
			cla.add(new Classes(floorLevel, capacity, accessible, className,class_size)); 
			session.save(cla);
			
			/* Db operation for Subjects */
			con = DBConnection.getDBConnection();
			ps = con.prepareStatement(SQL_ASSIGN_QUERY_SUBJECTS);
			ps.setString(1,subject_Name);
			ps.setString(2,subject_Code);
			session.save(sub);
			tx.commit();
			rs1_classes=ps.executeQuery();
			
			/*Extracting info from resultSet*/
			while(rs1_classes.next()) {
				rsClass=rs1_classes.getInt(1);
			}
			
			/* Db operation for Classes */
			con = DBConnection.getDBConnection();
			ps=con.prepareStatement(SQL_ASSIGN_QUERY_CLASSES);
			ps.setString(1,floorLevel);
			ps.setString(2,capacity);
			ps.setString(3,accessible);
			ps.setString(4,className);
			ps.setString(5,class_size);
			session.save(cla);
			tx.commit();
			rs2_subjects=ps.executeQuery();
			
			/*Extracting info from resultSet*/
			while(rs2_subjects.next()) {
				rsSubject=rs2_subjects.getInt(1);
			}
			
			/* DB connection for the CLASSES_SUBJECTS TABLE */
			con=DBConnection.getDBConnection();
     		ps=con.prepareStatement(SQL_ASSIGN_QUERY_CLASSES_SUBJECTS);
		     ps.setInt(1,rsClass);
		     ps.setInt(2,rsSubject);
		     ps.executeUpdate();
			} catch (SQLException sql) {
               sql.getMessage();
		    }catch(HibernateException he) {
			he.getMessage();
		    }
		    finally {
			    session.close();
			    sf.close();
                }
		displayResult(request, response); 
        
        }
     
	
	

	private void displayResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Floor_Level",floorLevel);
		request.setAttribute("ClassName",className);
		request.setAttribute("Capacity",capacity);
		request.setAttribute("Accessible",accessible);
		request.setAttribute("Subject-Name",subject_Name);
		request.setAttribute("Subject-Code",subject_Code);
		RequestDispatcher rd = request.getRequestDispatcher("Assign-Classes-Page.jsp");
		rd.forward(request, response);
		
	}
}
