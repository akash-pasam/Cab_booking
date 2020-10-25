<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="../common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>waiting</title>
</head>
<body>
<link href="css/style.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<form method="post">
<table border="1">
<h2>Waiting For The Driver To Pick Your Ride</h2>
 <% response.setIntHeader("Refresh", 10);%>
  <c:forEach items="${list}" var="name">
    <tr>
    	<th>Phone Number</th>
    	<td>${name.phonenumber}</td>
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
      <th>status</th>
      <td>${name.status}</td>
      </tr>
      <tr>
      <th>Passengers</th>
      <td>${name.passengers}</td>
      </tr>
      <div>
      <c:if test = "${name.status == 'waiting'}">
      <th></th>
      <td><a href="cancelled?number=${name.phonenumber}">cancel</a></td>
      </c:if>
     </div>
     <c:if test="${name.status == 'confirmed'}">
      <c:redirect url="/currentride"/>
      </c:if>
     </c:forEach>
</table>
</form>
</body>
</html>