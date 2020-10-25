<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="../common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="register-form">
<form method="post">
    <div class="container">
      <h1>Register</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <div>
      <label>Name</label>
      <input id="name" type="text" placeholder="Enter Name" name="name" required>
      </div>
      <div>
      <label>Email</label>
      <input id="email" type="text" placeholder="Enter Email" name="email"  required>
      </div>
      <div>
      <label for="phone-number">Phone number</label>
      <input id="phoneno" type="tel" placeholder="Enter Phone number" name="phonenumber" required>
      </div>
      <div>
      <label for="psw">Password</label>
      <input id="password" type="password" placeholder="Enter Password" name="password"required>
      </div>
      <div>
      <label for="psw-repeat">Repeat Password</label>
      <input id="rpass" type="password" placeholder="Repeat Password" name="repass" required>
      </div>
      <hr class="light">
      <div><font color="red">${error_message}</font></div>
  
      <button type="submit" class="btn btn-primary register-button">Register</button>
    </div>
    <div class="container signin">
      <p>Already have an account? <a href="/login">Sign in</a>.</p>
 	</div>
  </form>
</div>
</body>
</html>