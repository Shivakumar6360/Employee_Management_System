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
////
////@WebServlet("/add")
////public class Employee_insertion extends HttpServlet {
////
////    @Override
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
////            throws ServletException, IOException {
////
////        String EmployeeName = req.getParameter("EmployeeName");
////        String EmployeeEmail = req.getParameter("EmployeeEmail");
////        int EmployeeAge = Integer.parseInt(req.getParameter("EmployeeAge")); // ✅ fixed
////
////        Connection conn = null;
////
////        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
////
////            conn = DriverManager.getConnection(
////                    "jdbc:mysql://localhost:3307/employeedata",
////                    "root",
////                    "root"
////            );
////
////            // ✅ DO NOT insert EmployeeId
////            PreparedStatement pst = conn.prepareStatement(
////                    "INSERT INTO employee(EmployeeName, EmployeeEmail, EmployeeAge) VALUES (?, ?, ?)"
////            );
////
////            pst.setString(1, EmployeeName);
////            pst.setString(2, EmployeeEmail);
////            pst.setInt(3, EmployeeAge);
////
////            pst.executeUpdate();   // ✅ Correct method
////
////            resp.sendRedirect("index.jsp");
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
////
//
//
//
//



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

@WebServlet("/add")
public class Employee_insertion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        // 🔍 DEBUG PRINTS (VERY IMPORTANT)
        System.out.println("Servlet /add called");

        String name = req.getParameter("EmployeeName");
        String email = req.getParameter("EmployeeEmail");
        String ageParam = req.getParameter("EmployeeAge");

        System.out.println("Name = " + name);
        System.out.println("Email = " + email);
        System.out.println("Age = " + ageParam);

        if (name == null || email == null || ageParam == null || ageParam.trim().isEmpty()) {
            resp.getWriter().println("ERROR: Form data missing");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageParam);
        } catch (NumberFormatException e) {
            resp.getWriter().println("ERROR: Age must be a number");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeedata?useSSL=false&serverTimezone=UTC",
                    "root",
                    "root"
            );

            PreparedStatement pst = conn.prepareStatement(
                    "INSERT INTO employee (EmployeeName, EmployeeEmail, EmployeeAge) VALUES (?, ?, ?)"
            );

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setInt(3, age);

            pst.executeUpdate();

            conn.close();

            resp.getWriter().println("SUCCESS: Employee inserted");

        } catch (Exception e) {
            e.printStackTrace();   // 🔥 CHECK CONSOLE OUTPUT
            resp.getWriter().println("SERVER ERROR OCCURRED");
        }
    }
}

