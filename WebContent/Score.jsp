<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PARIKSHA</title>
</head>
<style>
@charset "UTF-8";



body {
  min-width: 320px;
  height: 100%;
  margin: 0;
  padding: 50px 50px;
  background-color: #FFDAB9;
}

.back span {
		font-size:1.0em;
		color:#F2C640;
		background:#262B37;
		display:table-cell;
		box-shadow:inset 0 0 5px rgba(0,0,0,0.3), 10px 5px 0 #FDD700;
		padding: 10px 20px;
		line-height: 40px;
		
	}
	@keyframes constant {
		0% {
			transform:translateY(0px)
		}
		50% {
			transform:translateY(-30px);
			box-shadow:0px 15px 0;
		}
		100% {
			transform:translateY(0px)	
		}
	}
	
.button {
    background-color: #262B37;
    border: none;
    color: #F2C640;
    padding: 15px 32px;
    text-align: center;
    font-size: 20px;
    margin: 170px 2px;
    cursor: pointer;
}

</style>
<body>
<meta charset="UTF-8">
<title>PARIKSHA</title>
</head>
<link rel="stylesheet" type="text/css" href="logo.css">
<center>
<body>
 
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
</center>

<%int score = (int) request.getAttribute("result");
					%>
<p align="justify"><font size="5">Your score is: </font><font size="10"><%=score%></font></p>

<center>
<form action = "TableTests.jsp">
<button class="button">OK</button>
</form>
</center>

</body>
</html>