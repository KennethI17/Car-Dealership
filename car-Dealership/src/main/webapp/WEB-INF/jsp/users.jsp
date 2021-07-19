<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <meta charset="utf-8">
    <title>Student Portal</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/cover/">

    <!-- Bootstrap core CSS -->
<link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
  </head>


<body class="text-center">
    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Welcome, ${seller.getFirstName()} ${seller.getLastName()} </h3>
      <nav class="nav nav-masthead justify-content-center">
         <a class="nav-link active" href="/">Home</a>
         <a class="nav-link active" href="/profile">My Profile</a>
         <a class="nav-link active" href="/auctions">Store</a>
         <a class="nav-link active" href="/add-vic">Create Auction</a>
         <a class="nav-link active" href="/login">Logout</a>

        
      </nav>
    </div>
  </header>

  <main role="main" class="inner cover">
    <h1 class="cover-heading">Meet up with other Sellers</h1>
  </main>
<div>
<c:choose>
<c:when test="${not empty sellers}">
<table>
<thead>
<tr>
<th>#</th>
<th>
Price
</th>
<th>
Last Name
</th>
<th>
E-Mail
</th>
<th>
Phone Number
</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${sellers}">
<tr>
<td>${sellers.indexOf(item)+1}.</td>
<td>${item.getFirstName()}</td>
<td>${item.getLastName()}</td>
<td>${item.getEmail()}</td>
<td>${item.getPhone()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</c:when>
<c:otherwise>
<h3>No Users found</h3>
</c:otherwise>
</c:choose>
</div>
  <footer class="mastfoot mt-auto">
    <div class="inner">
    </div>
  </footer>
</div>