//package com.jdbc.servlet;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
////@WebServlet("/update")
////public class saveupdate extends HttpServlet{
////	@Override
////	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////		int EmployeeId=Integer.parseInt(req.getParameter("EmployeeId"));
////		String EmployeeName=req.getParameter("EmployeeName");
////		String EmployeeEmail=req.getParameter("EmployeeEmail");
////		int EmployeeAge=Integer.parseInt(req.getParameter("EmployeeAge"));
////		
////		Connection conn=null;
////		
////		try {
////			Class.forName("com.mysql.cj.jdbc.Driver");
////			
////				conn=DriverManager.getConnection("jdbc:mysql://localhost:3307:/employeedata","root","root");
////				PreparedStatement pst=conn.prepareStatement("select employee set EmployeeName=?,EmployeeEmail=?,EmployeeAge=? where EmployeeId=?");
////				pst.setString(1, EmployeeName);
////				pst.setString(2, EmployeeEmail);
////				pst.setInt(3, EmployeeAge);
////				pst.setInt(4, EmployeeId);
////				pst.executeUpdate();
//////				resp.sendRedirect("displayfile.jsp");
////			} catch (SQLException | ClassNotFoundException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}finally {
////				if(conn!=null) {
////					try {
////						conn.close();
////					} catch (SQLException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////				}
////			}
////			
////			
////		
////		
////	}
////}
//
//package com.jdbc.servlet;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/update")
//public class saveupdate extends HttpServlet {
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		int EmployeeId = Integer.parseInt(req.getParameter("EmployeeId"));
//		String EmployeeName = req.getParameter("EmployeeName");
//		String EmployeeEmail = req.getParameter("EmployeeEmail");
//		int EmployeeAge = Integer.parseInt(req.getParameter("EmployeeAge"));
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/employeedata", "root", "root");
//
//			PreparedStatement pst = conn.prepareStatement(
//					"UPDATE employee SET EmployeeName=?, EmployeeEmail=?, EmployeeAge=? WHERE EmployeeId=?");
//
//			pst.setString(1, EmployeeName);
//			pst.setString(2, EmployeeEmail);
//			pst.setInt(3, EmployeeAge);
//			pst.setInt(4, EmployeeId);
//
//			pst.executeUpdate();
//			conn.close();
//
//			// ✅ FIXED REDIRECT
////            resp.sendRedirect("display.jsp");
////			resp.sendRedirect(req.getContextPath() + "/display");
//			
////			resp.sendRedirect("displayfile.jsp");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.getWriter().println("Update failed");
//		}
//	}
//}



package com.jdbc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class saveupdate extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int EmployeeId = Integer.parseInt(req.getParameter("EmployeeId"));
        String EmployeeName = req.getParameter("EmployeeName");
        String EmployeeEmail = req.getParameter("EmployeeEmail");
        int EmployeeAge = Integer.parseInt(req.getParameter("EmployeeAge"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeedata",
                "root",
                "root"
            );

            PreparedStatement pst = conn.prepareStatement(
                "UPDATE employee SET EmployeeName=?, EmployeeEmail=?, EmployeeAge=? WHERE EmployeeId=?"
            );

            pst.setString(1, EmployeeName);
            pst.setString(2, EmployeeEmail);
            pst.setInt(3, EmployeeAge);
            pst.setInt(4, EmployeeId);

            pst.executeUpdate();
            conn.close();

            // redirect BACK to DisplayServlet
            resp.sendRedirect(req.getContextPath() + "/display");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

