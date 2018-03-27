<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PARIKSHA</title>
</head>
<body>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
   <head>
      <title>JSTL sql:update Tag</title>
   </head>
<style>
body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }

}



.back {
		margin:em auto;
		font-family:"Roboto";
    
	}
	.back span {
		font-size:3em;
		color:#F2C640;
		background:#262B37;
		display:table-cell;
		box-shadow:inset 0 0 5px rgba(0,0,0,0.3), 0 5px 0 #ccc;
		padding: 0 15px;
		line-height: 100px;
		animation:jumb 2s infinite;
	}


</style>
<br>
<br>
   <body>
   <div class="topnav" id="myTopnav">
  <a href="adminTests.jsp">TESTS AVAIABLE</a>
  <a href="adminsubjects.jsp">CREATE TEST</a>
 
  <a href="Homepage.html" style="float:right">LOGOUT</a>
  <br>
  <br>
</div>
  <br>
  <br>
             <div align = "middle">
<span class="back">
	<span>P</span>
	<span>A</span>
	<span>R</span>
	<span>I</span>
	<span>K</span>
	<span>S</span>
	<span>H</span>
	<span>A</span>
</span>
  </div>
  <br>
   
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/PARIKSHA"
         user = "root"  password = "svcdhoney1"/>

      
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT Subject_name,Test_id,Test_name,Test_date from Tests;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>Subject</th>
            <th>Topic</th>
          <th>Scheduled on</th>
            <th>option</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.Subject_name}"/></td>
               <td> <c:out value = "${row.Test_name}"/></td>
               <td> <c:out value = "${row.Test_date}"/></td>
               <td> 
               <form action="Schedule.jsp">
       			<button type="submit" name = "Subject" value = "${row.Test_id}"/>Schedule Test</form>
    
    </td>
               
            </tr>
         </c:forEach>
      </table>

   </body>
</html>
</body>
</html>