package com.jsp.servlet.sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/save-updated-student")
public class SaveUpdateStudentServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		String studentName = req.getParameter("studentName");
		String studentEmail = req.getParameter("studentEmail");
		int studentAge = Integer.parseInt(req.getParameter("studentAge"));
		String studentCourse = req.getParameter("studentCourse");
		String studentCity = req.getParameter("studentCity");
		
		// JDBC LOGIC

				Connection conn = null;

				try {
					Driver driver = new com.mysql.cj.jdbc.Driver();

					DriverManager.registerDriver(driver);

					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system", "root",
							"mysql@1234");
					
					PreparedStatement pst = conn.prepareStatement("UPDATE student SET studentName=?,studentEmail=?,studentAge=?,studentCourse=?,studentCity=? WHERE studentId=?");
					
					pst.setString(1, studentName);
					pst.setString(2, studentEmail);
					pst.setInt(3, studentAge);
					pst.setString(4, studentCourse);
					pst.setString(5, studentCity);
					pst.setInt(6, studentId);
					
					
					pst.executeUpdate();
					
					resp.sendRedirect("display-all-students");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}		
					
	}

}
