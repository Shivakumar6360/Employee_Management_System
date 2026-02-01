
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Dashboard</title>
</head>
<body>

<h1>Welcome to Employee Dashboard</h1>

<!-- Add Employee JSP -->
<a href="<%= request.getContextPath() %>/AddEmployee.jsp">
    ADD EMPLOYEE
</a>

<br><br>

<!-- Display Employees via Servlet -->
<a href="<%= request.getContextPath() %>/display">
    Display All Employee Details
</a>

</body>
</html>
