<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<p id="demo"></p>

<body>

<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/PARIKSHA"
         user = "root"  password = "svcdhoney1"/>
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from multipleTests where subject_id = <%=request.getParameter("sub")%>;
      </sql:query>
<% String s = (String) request.getParameter("sub");
session.setAttribute("s1",s );%>
      <table border = "1" width = "100%">
         <tr>
            <th> Select Questions</th>
           
            <th>Question</th>
            <th>Option1</th>
            <th>Option2</th>
            <th>Option3</th>
            <th>Option4</th>
            <th>correct_option</th>
         </tr>
         <form action = "createtestservlet" method = "post">
         <label for="testName">Topic *</label>
      <input type="text"  placeholder="Topic" required name = "Topic"/>
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><input type="checkbox" name="cname" value = "${row.q_id}"></input><br/></td>
               
               <td> <c:out value = "${row.question}"/></td>
               <td> <c:out value = "${row.option1}"/></td>
               <td> <c:out value = "${row.option2}"/></td>
               <td> <c:out value = "${row.option3}"/></td>
               <td> <c:out value = "${row.option4}"/></td>
               <td> <c:out value = "${row.correct_option}"/></td>
            </tr>
         </c:forEach>
      </table>
      Schedule on : 
      <br>Test Date: <INPUT type="text" placeholder="yyyy-mm-dd" name="date" size="4"><BR></br>
	  <input type = "submit" name = "submit" value = "submit">	  
	</form>
	  
   </body>


</html>