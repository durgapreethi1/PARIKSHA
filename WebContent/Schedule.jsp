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

</style>
<br>
  <br>
              
   <body>
   <div class="topnav" id="myTopnav">
  <a href="adminTests.jsp">TESTS AVAIABLE</a>
  <a href="#news">CREATE TEST</a>
  <a href="Schedule.jsp">SCHEDULE TEST</a>
  <a href="Homepage.html" style="float:right">LOGOUT</a>
  
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
  <br>
   
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/PARIKSHA"
         user = "root"  password = "svcdhoney1"/>

      
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT Subject_name,Test_name,Test_date from Tests;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>Subject</th>
            <th>Topic</th>
            <th>Scheduled on</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.Subject_name}"/></td>
               <td> <c:out value = "${row.Test_name}"/></td>
               <td> <c:out value = "${row.Test_date}"/></td>
               
            </tr>
         </c:forEach>
      </table>
      
<center>

 <sql:query dataSource = "${snapshot}" var = "result">
         SELECT Subject_name,Test_name from Tests where Test_id =  <%=(String) request.getParameter("Subject")%>;
      </sql:query>
       <c:forEach var = "row" items = "${result.rows}">
     

<FORM action="ScheduleServlet" method="post">

<br>Subject Name:<INPUT type="text" name="subjecttitle" size="35" value = "${row.Subject_name}" ><BR></br>
<br>Topic: <INPUT type="text" name="title" size="35" value = "${row.Test_name}"><BR></br>

<br>Test Date: <INPUT type="text" placeholder="yyyy-mm-dd" name="date" size="4"><BR></br>


<INPUT  class="button"type="submit" name="Submit" value="Add Test">

</c:forEach>
</center>

</FORM>

   </body>
</html>
</body>
</html>