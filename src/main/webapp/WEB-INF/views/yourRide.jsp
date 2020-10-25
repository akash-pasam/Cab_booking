<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../common/driverheader.jspf"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
<link href="css/style.css" rel="stylesheet">
<form method="post">
<table border="1">
  <c:forEach items="${list}" var="name">
    <tr>
    	<th>Booking Id</th>
    	<td>${name.bookingid}</td>
    	</tr>
    	<tr>
      <th>From Location</th>
      <td>${name.fromlocation}</td>
      </tr>
      <tr>
      <th>To Location</th>
       <td>${name.tolocation}</td>
       </tr>
       <tr>
      <th>Phone Number</th>
      <td>${name.u_phonenumber}</td>
      </tr>
      <tr>
      <th>price</th>
      <td>${name.price}</td>
      </tr>
      <div>
      <td><a href="cancelled">completed</a></td>
     </div>
     </c:forEach>
</table>
</form>
</body>
</html>