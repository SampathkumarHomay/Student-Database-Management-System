package com.jsp.servlet.sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/find-by-id")
public class FindStudentByIdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		
		// JDBC LOGIC

				Connection conn = null;

				try {
					Driver driver = new com.mysql.cj.jdbc.Driver();

					DriverManager.registerDriver(driver);

					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system", "root",
							"mysql@1234");
					
					PreparedStatement pst = conn.prepareStatement("SELECT * from student where studentId=?");
					pst.setInt(1, studentId);
					
					ResultSet rs = pst.executeQuery();
					
					req.setAttribute("resultSet", rs);
					RequestDispatcher rd = req.getRequestDispatcher("UpdateStudent.jsp");
					rd.forward(req, resp);
					
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
