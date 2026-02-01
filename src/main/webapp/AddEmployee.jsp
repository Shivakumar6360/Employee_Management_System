<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>

	<h2>Add Employee</h2>

	<form action="<%=request.getContextPath()%>/add" method="post">

		<input type="text" name="EmployeeName" placeholder="Name" required><br>
		<br> <input type="email" name="EmployeeEmail" placeholder="Email"
			required><br>
		<br> <input type="number" name="EmployeeAge" placeholder="Age"
			required><br>
		<br> <input type="submit" value="Add Employee">

	</form>


	<h1>
		<a href="index.jsp">Goto Dash Board</a>
	</h1>
</body>
</html>
