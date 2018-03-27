<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>

<!doctype html>
<html lang="en">

<head>
<style>
body {
  min-width: 320px;
  height: 100%;
  margin: 0;
  padding: 20px 20px;
  background-color: #ffffff;

}

.back span {
		font-size:0.8em;
		color:#F2C640;
		background:#262B37;
		display:table-cell;
		box-shadow:inset 0 0 5px rgba(0,0,0,0.3), 0 5px 0 #FDD700;
		padding: 0 15px;
		line-height: 40px;
		
	}
	@keyframes constant {
		0% {
			transform:translateY(0px)
		}
		50% {
			transform:translateY(-30px);
			box-shadow:0 15px 0 rgb(255, 191, 0);
		}
		100% {
			transform:translateY(0px)	
		}
	}
	

body{
background-color: #FFDAB9;
}
#button1{
width: 300px;
height: 100px;
padding: 10px 10px;
}
#button2{
width: 300px;
height: 100px;
padding: 10px 10px;
}
</style>

<meta charset="utf-8">
<meta name="Homepage" content="Starting page for the survey website ">

 <title>Survey HomePage</title>
</head>
<link rel="stylesheet" type="text/css" href="logo.css">
<body>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
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


 <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/PARIKSHA"
         user = "root"  password = "svcdhoney1"/>

      

      <sql:query dataSource = "${snapshot}" var = "result">
      
         SELECT Subject_name,Subject_id from Subjects;
      </sql:query>
      
      <center>
      
      <c:forEach var = "row" items = "${result.rows}">
     <form action="adminquestion.jsp">
    <br><button type="submit" id="button2" name = "sub" value = "${row.Subject_id}"> <c:out value = "${row.Subject_name}"/></button>
</form>
      
      </c:forEach>
      </center>

</body> 
 </html>

