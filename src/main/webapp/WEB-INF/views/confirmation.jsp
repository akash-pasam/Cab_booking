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
<body onload="getLocation();">
<link href="css/style.css" rel="stylesheet">
<% response.setIntHeader("Refresh", 10);%>
<form method="post">
<table border="1">
  <thead>
    <tr>
    	<th>Phone Number</th>
      <th>From Location</th>
      <th>To Location</th>
      <th>Passengers</th>
      <th>Confirm</th>
    </tr>

  </thead>
  <tbody>
     <c:forEach items="${list}" var="name">
       <tr>
       <td>${name.phonenumber}</td>
         <td>${name.fromlocation}</td>
         <td>${name.tolocation}</td>
         <td>${name.passengers}</td>
         <input type="hidden" name="number" value="${name.phonenumber}">
         <td><input type="submit"></td>
       </tr>
     </c:forEach>
  </tbody>
</table>
</form>
</body>
</html>