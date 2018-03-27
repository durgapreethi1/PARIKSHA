
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
body{
background-color: #F0F8FF;
}
</style>
 
<script>
function myFunction() {
    alert('Hello');
}
</script>
<head>
<title>Instructions</title>
</head>
<body>
<center>
<h1><p>INSTRUCTIONS</p></h1>
</center>
<hr>
<h2>Please read the instructions carefully:</h2>
 <ol>
  <li>Each module has a fixed number of questions and an allotted time. The time remaining for the module is shown on the right corner of the screen throughout the test.</li>
  <li>You are allowed to use a scratch paper to take down notes, do calculations, however you are strictly prohibited to refer to books, copies or any other material.</li>
  <li>Be at your seat until the completion of the test. Don't talk and do not indulge in any cheating. Your candidature may be CANCELLED for any infractions.</li>
  <li>In case of any problem with a question please note it down somewhere to share it with us via email after you finish the test.</li>
</ol>
<h2>How to answer a question:</h2>
<ul>
  <li>Each question has a direction on how to answer the question</li>
  <li>You can choose an appropriate answer by clicking the checkbox next to it</li>
  <li>Once you have answered, please press the 'CONFIRM ANSWER' again.</li>
  <li>At this point, you can still change your answer and press 'CONFIRM ANSWER' again</li>
  <li>Once you have decided on your answer, press next button to go to the next question.</li>
  <li>You are required to answer each question to go to the next question.</li>
</ul>
<center>
<% String subject1 = (String) request.getParameter("Subject");%>

<%session.setAttribute("subject2",subject1 );%>
<form action = "Qpage.jsp">

<button type="submit"  >Start The Exam</button></form>
</center>
</body>
</html>