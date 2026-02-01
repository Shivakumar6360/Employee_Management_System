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

@WebServlet("/delete")
public class DeleteEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("EmployeeId");

        if (idParam == null || idParam.isEmpty()) {
            resp.getWriter().println("EmployeeId not received for delete");
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
                    "DELETE FROM employee WHERE EmployeeId=?"
            );
            pst.setInt(1, EmployeeId);

            pst.executeUpdate();
            conn.close();

            // 🔁 redirect back to display
            resp.sendRedirect(req.getContextPath() + "/display");

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Delete failed");
        }
    }
}
