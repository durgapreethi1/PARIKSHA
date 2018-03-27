<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>


   <head>
      <title>JSTL sql:update Tag</title>
   </head>
<style>




</style>
   <body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/PARIKSHA"
         user = "root"  password = "svcdhoney1"/>

    
		Available C tests:
		<br>
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from multipleTests;
      </sql:query>
 
      <table border = "1" width = "50%">
         <tr>
            <th>Subject Name</th>
            <th>Test Id</th>
            <th>Test name</th>
            
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.subjectname}"/></td>
               <td> <c:out value = "${row.Test_id}"/></td>
               <td> <c:out value = "${row.TestName}"/></td>
            </tr>
         </c:forEach>
      </table>
      For Review:
      <% out.print("\n"); %>
      
      
      <form action = "JSTLSample.jsp">
           	<input class = "button" align = "right"  type = "submit" value = "Arrays">
       </form></td>
      <form action = "JSTLSample.jsp">
           	<input class = "button"  type = "submit" value = "Pointers">
      </form></td>      
	  <form action = "JSTLSample.jsp">
           	<input class = "button"  type = "submit" value = "Structures">
      </form></td>      
</body>
</html>