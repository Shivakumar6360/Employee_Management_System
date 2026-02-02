Employee Management System (Java Servlet + JSP + JDBC)
> Project Overview

The Employee Management System is a Java web application built using Servlets, JSP, JDBC, and MySQL.
It performs full CRUD operations (Create, Read, Update, Delete) on employee records.

This project is ideal for Java Full-Stack / Backend beginners to understand:

Servlet request–response flow

JSP integration

JDBC database connectivity

MVC-style structure (Servlet → JSP → DB)

 >Tech Stack

Java (JDK 8+)

Servlet & JSP

JDBC

MySQL

Apache Tomcat 9

Maven

Eclipse IDE

📂 Project Structure
Employee-management-system
│
├── src/main/java
│   └── com.jdbc.servlet
│       ├── Employee_insertion.java   (CREATE)
│       ├── DisplayServlet.java       (READ)
│       ├── UpdateFile.java           (FETCH FOR UPDATE)
│       ├── saveupdate.java           (UPDATE)
│       └── DeleteEmployee.java       (DELETE)
│
├── src/main/webapp
│   ├── AddEmployee.jsp
│   ├── Displayfile.jsp
│   ├── update.jsp
│   └── WEB-INF
│       └── web.xml
│
├── pom.xml
└── README.md

🗄️ Database Configuration
Database Name
employeedata

Table Structure
CREATE TABLE employee (
    EmployeeId INT PRIMARY KEY AUTO_INCREMENT,
    EmployeeName VARCHAR(100),
    EmployeeEmail VARCHAR(100),
    EmployeeAge INT
);

JDBC Connection Used
jdbc:mysql://localhost:3307/employeedata
Username: root
Password: root

>> CRUD Operations (Detailed API Explanation)
>> CREATE Employee

Servlet: Employee_insertion.java
URL: /add
Method: POST

Request Parameters:

EmployeeName

EmployeeEmail

EmployeeAge

Flow:

AddEmployee.jsp → /add → INSERT INTO employee → Success


SQL Used:

INSERT INTO employee (EmployeeName, EmployeeEmail, EmployeeAge)
VALUES (?, ?, ?);

>> READ (Display All Employees)

Servlet: DisplayServlet.java
URL: /display
Method: GET

Flow:

/display → Fetch all employees → Displayfile.jsp


SQL Used:

SELECT * FROM employee;

>> UPDATE (Fetch Employee by ID)

Servlet: UpdateFile.java
URL: /searchid
Method: GET

Request Parameter:

EmployeeId

Flow:

Displayfile.jsp → /searchid → update.jsp (pre-filled form)


SQL Used:

SELECT * FROM employee WHERE EmployeeId = ?;

>> UPDATE (Save Updated Employee)

Servlet: saveupdate.java
URL: /update
Method: POST

Request Parameters:

EmployeeId

EmployeeName

EmployeeEmail

EmployeeAge

Flow:

update.jsp → /update → UPDATE employee → /display


SQL Used:

UPDATE employee
SET EmployeeName=?, EmployeeEmail=?, EmployeeAge=?
WHERE EmployeeId=?;

>> DELETE Employee

Servlet: DeleteEmployee.java
URL: /delete
Method: GET

Request Parameter:

EmployeeId

Flow:

Displayfile.jsp → /delete → DELETE FROM employee → /display


SQL Used:

DELETE FROM employee WHERE EmployeeId=?;

>> How to Run the Project
Prerequisites

JDK 8+

Apache Tomcat 9

MySQL

Eclipse IDE

Steps

Import project into Eclipse

File → Import → Existing Maven Project


Configure Tomcat 9 in Eclipse

Update MySQL credentials if needed

Start Tomcat Server

Open browser:

http://localhost:8081/Employee-management-system/display

>> Features

Add employee

View all employees

Update employee details

Delete employee

JDBC-based database operations

Clean servlet mapping using annotations

> Future Improvements

Use DAO layer

Add validation

Convert to Spring Boot

REST APIs

Frontend using React

👤 Author

Shivakumar
Java Full Stack Developer (Fresher)
