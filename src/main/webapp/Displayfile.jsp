


<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Employees</title>
<style>
table, th, td {
    border: 1px solid black;
}
table {
    border-collapse: collapse;
}
</style>
</head>
<body>

<h1>Display All Employees</h1>

<%
ResultSet rs = (ResultSet) request.getAttribute("Key");
%>

<table>
    <tr>
        <th>EmployeeId</th>
        <th>EmployeeName</th>
        <th>EmployeeEmail</th>
        <th>EmployeeAge</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>

<%
while (rs != null && rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("EmployeeId") %></td>
        <td><%= rs.getString("EmployeeName") %></td>
        <td><%= rs.getString("EmployeeEmail") %></td>
        <td><%= rs.getInt("EmployeeAge") %></td>
        <td>
            <a href="searchid?EmployeeId=<%= rs.getInt("EmployeeId") %>">Update</a>
            <td>
            <a href="delete?EmployeeId=<%= rs.getInt("EmployeeId") %>">Delete</a>
        </td>
    </tr>
<%
}
%>
</table>

<br>
<a href="index.jsp">Go to Dashboard</a>

</body>
</html>




