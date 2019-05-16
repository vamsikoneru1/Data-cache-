
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    
<title>profile</title>
<style> 
.float-my-children > * {
    float:left;
    margin-right:5px;
}

/* this is called a clearfix. it makes sure that the container's children floats are cleared, without using extra markup */

.clearfix {
    *zoom:1 /* for IE */
}
.navbar-brand {
  padding: 0px;
}
.navbar-brand>img {
  height: 100%;
  padding: 15px;
  width: auto;
}
.clearfix:before,
.clearfix:after {
    content: " ";
    display: table;
}

.clearfix:after {
    clear: both;
}
.fonts
{
  color:blue;
  font-weight: bold;
  font-family: garamond;
  font-size:150%;
}

/* end clearfix*/

/* below is just to make things easier to see, not required */

</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Ualbany</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/logout">logout</a></li>
					<li><a href="/show-users">All Users</a></li>
					<li><a href="/corenetwork">Core network</a></li>
					<li><a href="/Edgenetwork">Edge network</a></li>
					<li><a href="/dl">download demo</a></li>
					<li><a href="/index">Upload demo</a></li>
					<li><a href="/uploaddata">uploaded data</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	




<div class="container text-centered" id="showcase">

<div class="alert alert-success">
			<h1>What is Caching</h1>
		</div>
<h4>
In computing, a cache is a high-speed data storage layer which stores a subset of data, typically transient in nature, 
		so that future requests for that data are served up faster than is possible by accessing the data’s 
		primary storage location. Caching allows you to efficiently reuse previously retrieved or computed data.

</h4>
</div>


<div class="container text-centered" id="showcase">

<div class="alert alert-success">
			<h1>What is CACHE HIT</h1>
		</div>
<h4>
A cache hit is a state in which data requested for processing by a component or application is found in the cache memory.
 It is a faster means of delivering data to the processor, as the cache already contains the requested data

</h4>
</div>


<div class="container text-centered" id="showcase">

<div class="alert alert-success">
			<h1>What is CACHE MISS</h1>
		</div>
<h4>
	A cache miss is a state in which data requested for processing by a component or application is not found in the cache memory.
 	
 	It causes execution delays by requiring the program or application to fetch the data from Servers.

</h4>
</div>



<div class="container text-centered" id="showcase">

<div class="alert alert-success">
			<h1>Cacje Hit and Cache Miss flow Diagram</h1>
		</div>

<img src="static/images/c1.png" width="800" height="600" >
<br>
<img src="static/images/cache.png" width="800" height="600" >

</div>




				
				
				<c:choose>
		
		
		<c:when test="${mode=='DOWNLOAD_DATA' }">
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
								<th>Region</th>
								<th>Type</th>
								<th>hit or miss </th>
								<th>dbtime</th>
								<th>awstime</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="download" items="${ddata}">
								<tr>
									<td>${download.id}</td>
									<td>${download.username}</td>
									<td>${download.filename}</td>
									<td>${download.hashvalue}</td>
									
									<td>${download.region}</td>
									<td>${download.type}</td>
									<td>${download.hitormiss}</td>
									<td>${download.dbdoownload}</td>
									<td>${download.cachedownload}</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>

		

		
	</c:choose>
	<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								
							</tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${check eq 1}">
							<c:forEach var="image" items="${allimages1 }">
								<tr>
									
									
									  	<a href = "${image.awspath}" download>
   										<img src="${image.awspath}" width="200px" height="200px" >
   										</a>
								</tr>
							</c:forEach>
							</c:when>
							</c:choose>
						</tbody>
					</table>
				</div>
				<a  href="data:image/jpeg;base64,${img123}" download>
				<  <img src="data:image/jpeg;base64,${img123}" id="myimg" />
				</a>
				
				
				<div class="container" id="homediv">
				<div class="jumbotron text-center">
						This PieChart graph Represent and compare the time to upload to AWS or Server and cache. User can see the various graphs and the time to upload to cache in diffent graphs types
						
						<form action="/downloadbargraph">
<input type="submit" value="barchart" class="btn btn-primary">
</form>
						</div>
						
						</div>
				
				

</body>
</html>