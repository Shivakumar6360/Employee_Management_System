//////package com.jdbc.servlet;
//////
//////import java.io.IOException;
//////import java.sql.Connection;
//////import java.sql.DriverManager;
//////import java.sql.PreparedStatement;
//////import java.sql.ResultSet;
//////import java.sql.SQLException;
//////
//////import javax.servlet.RequestDispatcher;
//////import javax.servlet.ServletException;
//////import javax.servlet.annotation.WebServlet;
//////import javax.servlet.http.HttpServlet;
//////import javax.servlet.http.HttpServletRequest;
//////import javax.servlet.http.HttpServletResponse;
//////
//////@WebServlet("/searchid")
//////public class UpdateFile extends HttpServlet {
//////	@Override
//////	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//////		int EmployeeId = Integer.parseInt(req.getParameter("EmployeeId"));
//////
//////		Connection conn = null;
//////		try {
//////			Class.forName("com.mysql.cj.jdbc.Driver");
//////
//////			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307:employeedata","root","root");
//////			
//////			PreparedStatement pst=conn.prepareStatement("select * from employee where EmployeeId=?");
//////			pst.setInt(1, EmployeeId);
//////			
//////			ResultSet rs=pst.executeQuery();
//////			
//////			req.setAttribute("hlo",rs);
//////			RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
//////			rd.forward(req, resp);
//////			
//////		} catch (SQLException | ClassNotFoundException e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		}finally {
//////			
//////			if(conn!=null) {
//////				try {
//////					conn.close();
//////				} catch (SQLException e) {
//////					// TODO Auto-generated catch block
//////					e.printStackTrace();
//////				}
//////			}
//////		}
//////
//////	}
//////
//////}
////
////
////
////
////
////package com.jdbc.servlet;
////
////import java.io.IOException;
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////
////import javax.servlet.RequestDispatcher;
////import javax.servlet.ServletException;
////import javax.servlet.annotation.WebServlet;
////import javax.servlet.http.HttpServlet;
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////
////@WebServlet("/searchid")
////public class UpdateFile extends HttpServlet {
////
////    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
////            throws ServletException, IOException {
////
////        // ✅ 1. NULL CHECK
////        String idParam = req.getParameter("EmployeeId");
////
////        if (idParam == null || idParam.isEmpty()) {
////            resp.getWriter().println("EmployeeId not received from request");
////            return;
////        }
////
////        int EmployeeId = Integer.parseInt(idParam);
////
////        Connection conn = null;
////
////        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
////
////            // ✅ 2. FIXED JDBC URL
////            conn = DriverManager.getConnection(
////                    "jdbc:mysql://localhost:3307/employeedata",
////                    "root",
////                    "root"
////            );
////
////            PreparedStatement pst = conn.prepareStatement(
////                    "SELECT * FROM employee WHERE EmployeeId = ?"
////            );
////            pst.setInt(1, EmployeeId);
////
////            ResultSet rs = pst.executeQuery();
////
////            if (rs.next()) {
////                req.setAttribute("EmployeeId", rs.getInt("EmployeeId"));
////                req.setAttribute("EmployeeName", rs.getString("EmployeeName"));
////                req.setAttribute("EmployeeEmail", rs.getString("EmployeeEmail"));
////                req.setAttribute("EmployeeAge", rs.getInt("EmployeeAge"));
////            }
////
////            RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
////            rd.forward(req, resp);
////
////        } catch (SQLException | ClassNotFoundException e) {
////            e.printStackTrace();
////        } finally {
////            if (conn != null) {
////                try {
////                    conn.close();
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
////            }
////        }
////    }
////}
////
//
//
//package com.jdbc.servlet;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/searchid")
//public class UpdateFile extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        String idParam = req.getParameter("EmployeeId");
//
//        if (idParam == null || idParam.isEmpty()) {
//            resp.getWriter().println("EmployeeId not received");
//            return;
//        }
//
//        int EmployeeId = Integer.parseInt(idParam);
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3307/employeedata",
//                    "root",
//                    "root"
//            );
//
//            PreparedStatement pst = conn.prepareStatement(
//                    "SELECT * FROM employee WHERE EmployeeId=?"
//            );
//            pst.setInt(1, EmployeeId);
//
//            ResultSet rs = pst.executeQuery();
//
//            if (rs.next()) {
//                req.setAttribute("EmployeeId", rs.getInt("EmployeeId"));
//                req.setAttribute("EmployeeName", rs.getString("EmployeeName"));
//                req.setAttribute("EmployeeEmail", rs.getString("EmployeeEmail"));
//                req.setAttribute("EmployeeAge", rs.getInt("EmployeeAge"));
//            }
//
//            conn.close();
//
//            RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
//            rd.forward(req, resp);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            resp.getWriter().println("Server error in UpdateFile");
//        }
//    }
//}



package com.jdbc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchid")
public class UpdateFile extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("EmployeeId");

        if (idParam == null || idParam.isEmpty()) {
            resp.getWriter().println("EmployeeId not received");
            return;
        }

        int EmployeeId = Integer.parseInt(idParam);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeedata",
                "root",
                "root"
            );

            PreparedStatement pst = conn.prepareStatement(
                "SELECT * FROM employee WHERE EmployeeId=?"
            );
            pst.setInt(1, EmployeeId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                req.setAttribute("EmployeeId", rs.getInt("EmployeeId"));
                req.setAttribute("EmployeeName", rs.getString("EmployeeName"));
                req.setAttribute("EmployeeEmail", rs.getString("EmployeeEmail"));
                req.setAttribute("EmployeeAge", rs.getInt("EmployeeAge"));
            }

            conn.close();

            RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

