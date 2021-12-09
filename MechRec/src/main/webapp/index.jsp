<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>MechRec</title>
	<link rel="stylesheet" href="index.css"/>
</head>
<body>
	<main>
		<nav>
			<div class="nav-center">
				<div class="nav-header">
					<div class="img-container">
						<img src="companyImg/logo.png" id="coLogo" alt ="">
						<div class="logo"><b>MechRec</b></div>
					</div>				
					<a href="index.jsp" class="button">Home</a>
					<div class="dropdown">
						<button class="dropbtn">USC Mechs</button>
						<div class="dropdown-content">
						    <button class="btn1"></button>
						    <button class="btn2"></button>
						    <button class="btn3"></button>
						</div>
					</div>	
					<div class="dropdown2">
						<button class="dropbtn2">UCLA Mechs</button>
						<div class="dropdown-content2">
						    <p>Coming Soon!</p>
						</div>
					</div>
					</div>				
					<a href="Login.jsp" class="logIn">LogIn</a>			
				</div>	
			</div>
		</nav>
		<section class = "container">
			<!-- static content -->
			<div class="intro">
				<h1>Find the Right Mechanic to Fit Your Needs!</h1>
				<h2>Search through our database of reviews and
				 information on all local USC mechanics.</h2>
			</div>
			<div class="row">
			  <div class="column-left">Services
			  	<p>Find services to fit your needs along with the corresponding pricing.</p>
				  <img src="companyImg/services.jpg" id="serImg" alt ="">
			  </div>
			  <div class="column-center">Mechanics
			  	<p>Compare mechanics in order to find the best one for your car maintenance.</p>
				  <img src="companyImg/mechanic.png" id="mecImg" alt ="">
		  	  </div>
			  <div class="column-right">Customer Reviews
			  	<p>Utilize customer reviews that detail specific services, pricing,
			  	 and overall opinion of each mechanic</p>
				  <img src="companyImg/customer_reviews.jpg" id="cusImg" alt ="">
			  </div>
			</div>
		</section>
	</main>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js""></script>
	<script src="index.js"></script>
</body>

</html>
