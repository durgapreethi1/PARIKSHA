<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="Question.css">
<!--   <script src="Question.js"></script> -->
<body  bgcolor= "#FFDAB9">
<body1>
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
</body1>
  
	
		<div class="wrapper">
			<div id="quiz">


				<div class="questions" name="Questions">
				
					<%
						String Q_no1 = (String) session.getAttribute("Q_no");
					%>
					<%
						String Question1 = (String) session.getAttribute("Question");
					%>
					<p><%=Q_no1%>.<%=Question1%></p>



				</div>

				<div class="answers" align="left">
					<%
						String op1 = (String) session.getAttribute("option1");
					%>
					<%
						String op2 = (String) session.getAttribute("option2");
					%>
					<%
						String op3 = (String) session.getAttribute("option3");
					%>
					<%
						String op4 = (String) session.getAttribute("option4");
					%>

		<form action="ResponseServlet" method = "get">
					<p>
						<input type="radio"  name="options"onclick="javascript: submit()" value = "option1"><%=op1%></p>
					<p>
						<input type="radio"  name="options"onclick="javascript: submit()" value = "option2"><%=op2%></p>
					<p>
						<input type="radio"  name="options"onclick="javascript: submit()" value = "option3"><%=op3%></p>
					<p>
						<input type="radio"  name="options"onclick="javascript: submit()" value = "option4"><%=op4%></p>
						
					</form>	
				</div>
				<% String subject = (String) session.getAttribute("subject2");%>

<%session.setAttribute("subject3",subject);%>
	
<div>

	<form action="PreviousQuestionServlet" method="post" >
		<input class="button button1" name="prev" type="submit"
			value="Previous">
	</form>
	<form action="NextQuestionServlet" method="post">

		<input class="button button1" name="next" type="submit" value="NEXT">
	</form>

</div>
	</div>
	</div>
	<form action="ScoreServlet" method="post">

		<input class="button button1" name="next" type="submit" value="END TEST">
	</form>
	
</body>
</html>