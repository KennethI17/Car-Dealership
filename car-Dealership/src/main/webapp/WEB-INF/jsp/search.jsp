<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
    <div>
      <h3 class="float-md-start mb-0">Best Dealer West of the Mississippi!</h3>
      <nav class="nav nav-masthead justify-content-center float-md-end">
        <a class="nav-link active" aria-current="page" href="/">Index</a>
        <a class="nav-link" href="/users">Users</a>
        <a class="nav-link" href="/sign-up">Sign Up</a>
        <a class="nav-link" href="/login">Login</a>
      </nav>
    </div>
<body>
<div>
<h1>Shady Vic's Search</h1>
<div>
<form method="post" action="/searchEngine">
<label>Search Make or Model here!</label>
<input type="text" name="keyword" id="keyword" placeholder="Search Make or Model">
<a href="/search" class="text-info"><button type="submit" value="submit">Search</button></a>
</form>
</div>
<c:choose>
<c:when test="${not empty searchCar}">
<table style="width:80%">
<thead>
<tr>
<th>
#
</th>
<th>
Price
</th>
<th>
Year
</th>
<th>
Make
</th>
<th>
Model
</th>
<th>
Miles
</th>
<th>
State
</th>
<th>
Description
</th>
<th>
Picture
</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${searchCar}">
<tr>
<td>${searchCar.indexOf(item)+1}.</td>
<td>${item.getPrice()}</td>
<td>${item.getYear()}</td>
<td>${item.getMake()}</td>
<td>${item.getModel()}</td>
<td>${item.getMiles()}</td>
<td>${item.getState()}</td>
<td>${item.getDescription()}</td>
<td>
<a target="_blank" href="/resources/images/${item.carPic}">
<img style="border:1px solid #ddd; border-radius:4px; padding:5px;width:150px;" src="<spring:url value='/resources/images/${item.carPic}' />">
</a>
</td>
<td><a href="buycar-${item.sellerEmail}-${item.miles}-${item.price}">Purchase</a> </td>
</tr>
</c:forEach>
</tbody>
</table>
</c:when>
<c:otherwise>
<h3>No Auctions Found</h3>
</c:otherwise>
</c:choose>
</div>

</body>
</html>