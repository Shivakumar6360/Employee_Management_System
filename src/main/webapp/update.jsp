

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>

<h2>Update Employee</h2>

<form action="<%= request.getContextPath() %>/update" method="post">

    <!-- 🔴 MOST IMPORTANT LINE -->
    <input type="hidden" name="EmployeeId"
           value="<%= request.getAttribute("EmployeeId") %>">

    Name:
    <input type="text" name="EmployeeName"
           value="<%= request.getAttribute("EmployeeName") %>" required>
    <br><br>

    Email:
    <input type="email" name="EmployeeEmail"
           value="<%= request.getAttribute("EmployeeEmail") %>" required>
    <br><br>

    Age:
    <input type="number" name="EmployeeAge"
           value="<%= request.getAttribute("EmployeeAge") %>" required>
    <br><br>

    <input type="submit" value="Update">
</form>

<br>
<a href="display.jsp">Back</a>

</body>
</html>
