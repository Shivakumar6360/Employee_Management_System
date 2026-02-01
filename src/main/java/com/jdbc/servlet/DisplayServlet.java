

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


@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeedata",
                    "root",
                    "root"
            );

            PreparedStatement pst =
                    conn.prepareStatement("SELECT * FROM employee");

            ResultSet rs = pst.executeQuery();

            req.setAttribute("Key", rs);

            // 🔴 FIXED HERE
            RequestDispatcher rd = req.getRequestDispatcher("Displayfile.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


