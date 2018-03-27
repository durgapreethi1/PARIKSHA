<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="Tests.css">
<body>
	<div class="home">
		<div class="container">
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

		
		</div>
		<div align="right">
		<form action = "Homepage.html">
		<input class = "button" type = "submit" value = "logout">
		</form>
		</div>
<br>
<br>



    <marquee>
      <h1>Welcome <%=request.getAttribute("user1") %></h1>
      
    </marquee>
  


		<!-- Columns -->

		<div class="container" id="quotes-container">
			<div class="row" id="row-1">
				<div class="three columns grid-cell">
					<div class="featured-image featured-image-books"></div>

					<div class="title" id="home-c">
					
						<h4><a href = "Instructions.html">C programing</a></h4>
						
						</form>
					</div>
				</div>
				<div class="three columns grid-cell">
					<div class="featured-image featured-image-relationships"></div>

					<div class="title" id="home-relationships">
						<h4><span>JAVA</span></h4>
					</div>
				</div>
				<div class="three columns grid-cell">
					<div class="featured-image featured-image-sports"></div>

					<div class="title" id="home-sports">
						<h4><span>PYTHON</span></h4>
					</div>
				</div>
				<div class="three columns grid-cell">
					<div class="featured-image featured-image-life"></div>

					<div class="title" id="home-life">
						<h4><span>DBMS</span></h4>
					</div>
				</div>
			</div>

		
</body>
</html>