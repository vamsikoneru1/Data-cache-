<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Ualbany | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">UAlbany</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/uploaddata">uploaded data</a></li>
					<li><a href="/show-users">All Users</a></li>
					<li><a href="/corenetwork">Core network</a></li>
					<li><a href="/Edgenetwork">Edge network</a></li>
					<li><a href="/allimages2">Downloaded details</a></li>
					<li><a href="/dl">download demo</a></li>
					<li><a href="/index">Upload demo</a></li>
					<li><a href="/uploaddata">uploaded data</a></li>
					<li><a href="/advantage">Advantage of cache</a></li>
					
				</ul>
			</div>
		</div>
		
	</div>

		
		
		
		






	<c:choose>
		
		
		<c:when test="${mode=='ALL_DATA' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Data</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>UserName</th>
								<th>File Name</th>
								<th>hash value</th>
								<th>time to upload to cache</th>
								<th>time to upload to cloud</th>
								<th>Region</th>
								<th>Type</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="upload" items="${udata}">
								<tr>
									<td>${upload.id}</td>
									<td>${upload.username}</td>
									<td>${upload.filename}</td>
									<td>${upload.hashvalue}</td>
									<td>${upload.dbtime}</td>
									<td>${upload.awstime}</td>
									<td>${upload.region}</td>
									<td>${upload.type}</td>
									<td><a href="/delete-cache?id=${upload.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>

		

		
	</c:choose>
	
<div class="container" id="homediv">
				<div class="jumbotron text-center">
						This PieChart graph Represent and compare the time to upload to AWS or Server and cache. User can understand in the pictorial way using various parameters which can be observed by scrolling on the image
						
						<form action="/piechartgraph">
<input type="submit" value="PieChart" class="btn btn-primary">
</form>
						</div>
						
						</div>
	
	<div class="container" id="homediv">
				<div class="jumbotron text-center">
						This LineChart graph Represent and compare the time to upload to AWS or Server and cache. User can see the various graphs and the time to upload to cache in diffent graphs types
						
						<form action="/linechartgraph">
<input type="submit" value="LineChart" class="btn btn-primary">
</form>
						</div>
						
						</div>

<div class="container" id="homediv">
				<div class="jumbotron text-center">
						This Bar graph Represent and compare the time to upload to AWS or Server and cache. User can see the various graphs and the time to upload to cache in diffent graphs types
						
						<form action="/bargraph">
<input type="submit" value="BarGraph" class="btn btn-primary">
</form>
						</div>
						
						</div>
						<div class="container" id="homediv">
				<div class="jumbotron text-center">
						This GeoChart graph Represent and compare the time to upload to AWS or Server and cache. User can see the various graphs and the time to upload to cache in diffent graphs types
						
						<form action="/geochartgraph">
<input type="submit" value="GeoChart" class="btn btn-primary">
</form>
						</div>
						
						</div>



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>