<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en" class="h-100">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">
<title>Creating an Auction</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/cover/">



<!-- Bootstrap core CSS -->
<link href="/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="/docs/5.0/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg"
	color="#7952b3">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link rel="stylesheet" type ="text/css" href="assets/css/style.css">
</head>
<body class="d-flex h-100 text-center text-white bg-dark">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="mb-auto">
			<div>
				<h3 class="float-md-start mb-0">Creating An Auction</h3>
				<nav class="nav nav-masthead justify-content-center float-md-end">
				</nav>
			</div>
		</header>

		<main class="px-3">
			<h1>Input your car's info.</h1>
			<form:form action="/add-vic" method="post" modelAttribute="carInfo" enctype="multipart/form-data">

				<div class="form-row">
						<div class="form-group col-md-6">
						<label for="inputPrice">Price</label>
						<form:input type="text" class="form-control" id="pirce"
							path="price" placeholder="$0.00" /><br><br>
					</div> 
					<div class="form-group col-md-6">
						<label for="inputYear">Year</label>
						<form:input type="text" class="form-control" id="year"
							path="year" placeholder="Year" /><br><br>
					</div> 
					<div class="form-group col-md-6">
						<label for="inputModel">Model</label>
						<form:input type="text" class="form-control" id="model"
							path="model" placeholder="Model" /><br><br>
					</div>
					
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="Make">Make</label>
						<form:input class="form-control" path="make" placeholder="Make"/><br><br>
					</div>
					
					<div class="form-group col-md-6">
						<label for="inputMiles">Miles</label>
						<form:input type="text" class="form-control" id="miles"
							path="miles" placeholder="Miles" /><br><br>
					</div> 
					<div class="form-group col-md-12">
						<label for="inputMiles">Description</label>
						<form:input type="text" class="form-control" id="textboxid"
							path="description" placeholder="Short description of vehicle" /><br><br>
					</div>
					<div class="form-group col-md-4">
						<label for="inputState">State</label>
						<form:select id="inputState" class="form-control"
							path="state">
							  <option selected>Choose...</option>
						        <option value="AL">AL</option><option value="AK">AK</option><option value="AZ">AZ</option><option value="AR">AR</option>
								<option value="CA">CA</option><option value="CO">CO</option><option value="CT">CT</option><option value="DE">DE</option>
								<option value="DC">DC</option><option value="FL">FL</option><option value="GA">GA</option><option value="HI">HI</option>
								<option value="ID">ID</option><option value="IL">IL</option><option value="IN">IN</option><option value="IA">IA</option>
								<option value="KS">KS</option><option value="KY">KY</option><option value="LA">LA</option><option value="ME">ME</option>
								<option value="MD">MD</option><option value="MA">MA</option><option value="MI">MI</option><option value="MN">MN</option>
								<option value="MS">MS</option><option value="MO">MO</option><option value="MT">MT</option><option value="NE">NE</option>
								<option value="NV">NV</option><option value="NH">NH</option><option value="NJ">NJ</option><option value="NM">NM</option>
								<option value="NY">NY</option><option value="NC">NC</option><option value="ND">ND</option><option value="OH">OH</option>
								<option value="OK">OK</option><option value="OR">OR</option><option value="PA">PA</option><option value="RI">RI</option>
								<option value="SC">SC</option><option value="SD">SD</option><option value="TN">TN</option><option value="TX">TX</option>
								<option value="UT">UT</option><option value="VT">VT</option><option value="VA">VA</option><option value="WA">WA</option>
								<option value="WV">WV</option><option value="WI">WI</option><option value="WY">WY</option>
						</form:select><br><br>
					</div>
					<div class="form-group col-md-6">
	     				 <label for="img">Select image:</label>
	  	  				<form:input path="carPicture" type="file" class="form-control" accept="image/*"/>
	   				</div>
					
				</div>
				<div class="form-group">
				<div class="form-check">
				</div>
				</div>
				<br><br><button type="submit" class="btn btn-primary">Ready to Sell</button>
			</form:form>
		</main>

		<footer class="mt-auto text-white-50">
			<p>
				Cover template for <a href="https://getbootstrap.com/"
					class="text-white">Bootstrap</a>, by <a
					href="https://twitter.com/mdo" class="text-white">@mdo</a>.
			</p>
		</footer>
	</div>



</body>
</html>