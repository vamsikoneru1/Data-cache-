<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li><a href="/edgenetwork">WEge network</a></li>
					<li><a href="/allimages2">Downloaded details</a></li>
					<li><a href="/dl">Download demo</a></li>
					<li><a href="/index">Upload demo</a></li>
					<li><a href="/uploaddata">uploaded data</a></li>
					<li><a href="/advantage">Advantage of cache</a></li>
					<li><a href="/Graph">Graphs</a></li>
				</ul>
			</div>
		</div>
	</div>
<div class="container" id="homediv">
		<div class="jumbotron text-center">
		
			<h1> Welcome to UAlbany Demo about Core Network,Edge Network and Data Cache presentation</h1>
			<h3></h3>
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
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='CORE_NETWORK'}">
		
	
		<div class="container text-centered">
		
		<div class="alert alert-success">
			<h4>Please watch this Tutorial before proceding</h4>
		</div>
		<iframe width="800" height="600"
			src="https://www.youtube.com/embed/ObNYlm7HJs8" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
			
			
			<div >
			<h4>This video Introduces you about What is network</h4>
		</div>
		</div>
		
		
		<div class="container" id="core div">
		
		<div>
		
		</div>
		<div class="alert alert-success">
			<h2>What is Core Network???</h2>
			
			<img src="static/images/questionmark.jpg" width="200" height="200">
			
			
		</div>
		
		<div>
		<h3>Network core is nothing but Inter connected routers</h3>
		
		<img src="static/images/dil.jpg" width="200" height="200" >	UMMMMMM.......But what is Router now???????</img>
		</div>
		<iframe width="400" height="400"
			src="https://www.youtube.com/embed/k75BOtb4xMg" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
			<iframe width="400" height="400"
			src="https://www.youtube.com/embed/6AqZRbcWKQA" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
			
		<div>
				<h3>A router is a networking device that forwards data packets between computer networks. Routers perform the traffic directing functions on the Internet.</h3></h3> 
		<img src="static/images/cn1.jpg" width="400" height="400" >
		<img src="static/images/1.JPG" width="400" height="400" >
		
		
		
		
		</div>
		<div>
		<h3> This is how packet move in network</h3>
		<iframe width="400" height="400"
			src="https://www.youtube.com/embed/O7CuFlM4V54" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
		
		</div>
		
		
		<div>
		<h3> Watch This video to know more about CORE NETWORK</h3>
		<iframe width="400" height="400"
			src="https://www.youtube.com/embed/OlbQ88lx7J0" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
	</div>
		</div>
		
		
		</c:when>
		<c:when test="${mode=='EDGE_NETWORK'}">
		
	
		<div class="container text-centered">
		
		<div class="alert alert-success">
			<h4>Please watch this Tutorial before proceding</h4>
		</div>
		<iframe width="800" height="600"
			src="https://www.youtube.com/embed/ObNYlm7HJs8" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
			
			
			<div >
			<h4>This video Introduces you about What is network</h4>
		</div>
		</div>
		
		
		<div class="container" id="core div">
		
		<div>
		
		</div>
		<div class="alert alert-success">
			<h2>What is Edge Network???</h2>
			
			<img src="static/images/q2.jpg" width="200" height="200">
			
			
		</div>
		
		<div>
		<h3>Network edge is nothing but the network which has end Systems , access networks , links etc.</h3>
		
		<img src="static/images/dil.jpg" width="200" height="200" >	UMMMMMM.......But what is end Systems now???????</img>
		</div>
		
			
		<div>
		<img src="static/images/es.jpg" width="400" height="400" >
		<img src="static/images/1.JPG" width="400" height="400" >
		
		
		
		
		</div>
		<div>
		<h3> This is how packet move in network</h3>
		<iframe width="400" height="400"
			src="https://www.youtube.com/embed/O7CuFlM4V54" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
		
		</div>
		
		
		<div>
		<h3> Watch This video to know more about EDGE NETWORK</h3>
		<iframe width="400" height="400"
			src="https://www.youtube.com/embed/tEMB7iAygWo" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
	</div>
		</div>
		
		</c:when>
</c:choose>

	

	

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>