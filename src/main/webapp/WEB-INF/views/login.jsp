<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="../common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<link href="css/style.css" rel="stylesheet">
<div class="login borderLeft">
<h1 class="signin-text">Sign in</h1>
    <form  method="post" class="px-4 py-3">
      <div class="form-group">
        <label>UserName:</label>
        <input type="email"  name="username"placeholder="email@example.com">
      </div>
      <div class="form-group">
        <label>Password:</label>
        <input type="password" name="password" placeholder="Password">
      </div>
      <input class="btn btn-primary login-button" type="submit">
      <div><font color="red">${error_message}</font></div>
    </form>
    <div class="login-set">
    <a href="/register">New around here? Sign up</a>
    <div><a href="/reset-password">Forgot password?</a></div>
    </div>
</div>
</body>
</html>