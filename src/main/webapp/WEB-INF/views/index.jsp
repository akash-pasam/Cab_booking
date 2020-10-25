<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="../common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VCABS</title>
<link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"> </script>
<script src="webjars/popper.js/1.16.0/umd/popper.min.js"> </script>
 <span id="id">${param.message}</span>
<div id="slides" class="carousel slide" data-ride="carousel">
<div class="carousel-inner">
	<div class="carousel-item active">
		<img src="img/1.jpg">
		<div class="carousel-caption">
		<h1 >BOOK A CAB NOW</h1>
		</div>
	</div>
	<div class="carousel-item">
		<img src="img/3.jpg">
		<div class="carousel-caption two">
		<h1 >NOW BOOK A RIDE AT YOUR DOOR STEP</h1>
		</div>
	</div>
	<div class="carousel-item">
		<img src="img/4.jpg">
		<div class="carousel-caption three">
		<h1>Ride Out Of Town with Low Costs</h1>
		</div>
	</div>
</div>
</div>
<hr>
<div class="container-fluid padding">
<div class="row welcome text-center">
<h1 class="display-7">A CAR FOR EVERY OCCASSION</h1>
</div>
</div>
<hr>
<div class="card-deck">
  <div class="card">
    <img class="card-img-top" src="img/1.jpg" alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">City Taxi</h5>
      <p class="card-text">The perfect way to get through your everyday travel needs.City taxis are available 24/7 
      and you can book and travel in an instant. With rides starting from as low as Rs. 6/km, you can choose 
      from a wide range of options!</p>
    </div>
  </div>
  <div class="card">
    <img class="card-img-top" src="img/2.png" alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">Outstation</h5>
      <p class="card-text"> Ride out of town at affordable one-way and round-trip fares with Vcabs
      intercity travel service. Choose from a range of AC cabs driven by top partners, available in 1 hour or book.
      We have you covered across India with presence in 90+ cities with over 500 one way routes.</p>
    </div>
  </div>
  <div class="card">
    <img class="card-img-top" src="img/3.jpg" alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">Rentals</h5>
      <p class="card-text"> With Vcabs Rentals you get a cab at your disposal. So be it a day long business meeting,
      a shopping trip with your friends or just a day out in a new city, we have you covered. 
      Packages start at 1 hour and can be extended upto 12 hours!</p>
    </div>
  </div>
</div>
<div class="container-fluid padding">
<h2 class="section-heading">Why Vcabs</h2>
 <div class="wd-70">
     <h4 class="heading">
      Cabs for Every Pocket
     </h4>
      <p class="info">
      From Sedans and SUVs to Luxury cars for special occasions, we have cabs to suit every pocket
     </p>
    </div>
</div>
<footer>
<div class="container-fluid padding">
	<div class="row text-center">
		<div class="col-md-12">
		<hr class="light">
		<a id="left"class="title">Discover VCABS </a>
		<a>Features&nbsp;</a>
		<a>contact</a>
		</div>
		<div class="col-12">
			<hr class="light">
			<h5>&copy; Vcabs.com</h5>
		</div>
	</div>
</div>
</footer>



</body>
</html>