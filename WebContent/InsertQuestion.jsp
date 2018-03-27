<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method = "post" action="InertQuestionServlet">
  Question Id:<br>
  <input type="text" name="qid" id = "qid">
  <br>
  Subject Id:<br>
  <input type="text" name="sid" id = "sid">
  <br>
  Test Id:<br>
  <input type="text" name="tid" id = "tid">
  <br>
  Question :<br>
  <input type="text" name="question" id = "question">
  <br>
  Option1:<br>
  <input type="text" name="op1" id = "op1">
  <br>
  Option 2:<br>
  <input type="text" name="op2" id = "op2">
  <br>
  Option 3:<br>
  <input type="text" name="op3" id = "op3">
  <br>
  Option 4:<br>
  <input type="text" name="op4" id = "op4">
  <br>
  Solution:<br>
  <input type="text" name="solution" id = "solution">
  <br>
  	<input class = "button" align = "right"  type = "submit" value = "Insert">
</form> 

</body>
</html>