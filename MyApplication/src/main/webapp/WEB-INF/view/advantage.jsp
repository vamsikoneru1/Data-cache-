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
<style type="text/css">

body {
  
 *{
  margin:0;
  padding:0;
}

body{
  margin:0;
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  font-size:17px;
  color:#926239;
  line-height:1.6;
}

#showcase{
  background-image:url('http://traversymedia.com/downloads/assets/beachshowcase.jpg');
  background-size:cover;
  background-position:center;
  height:100vh;
  display:flex;
  flex-direction:column;
  justify-content:center;
  align-items:center;
  text-align:center;
  padding:0 20px;
}

#showcase h1{
  font-size:50px;
  line-height:1.2;
}

#showcase p{
  font-size:20px;
}

#showcase .button{
  font-size:18px;
  text-decoration:none;
  color:#926239;
  border:#926239 1px solid;
  padding:10px 20px;
  border-radius:10px;
  margin-top:20px;
}

#showcase .button:hover{
  background:#926239;
  color:#fff;
}

#section-a{
  padding:20px;
  background:#926239;
  color:#fff;
  text-align:center;
}

#section-b{
  padding:20px;
  background:#f4f4f4;
  text-align:center;
}

#section-c{
  display:flex;
}

#section-c div{
  padding:20px;
}

#section-c .box-1, #section-c .box-3{
  background:#926239;
  color:#fff;
}

#section-c .box-2{
  background:#f9f9f9;
}

}
</style>
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
					<li><a href="/advantage">Advantage of cache</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	

<div class="container text-centered" id="showcase">

<div class="alert alert-success">
			<h1>Advantages</h1>
		</div>
<h2>

Improve Application Performance
</h2>
<h4>
Because memory is orders of magnitude faster than disk (magnetic or SSD), reading data from in-memory cache is extremely fast (sub-millisecond). 
This significantly faster data access improves the overall performance of the application.
</h4>

		
<h2>

Reduce Database Cost
</h2>
<h4>
A single cache instance can provide hundreds of thousands of IOPS (Input/output operations per second), potentially replacing a number of database instances, thus driving the total cost down. This is especially significant if the primary database charges per throughput.
 In those cases the price savings could be dozens of percentage points..
</h4>
		
<h2>

Reduce the Load on the Backend
</h2>
<h4>
By redirecting significant parts of the read load from the backend database to the in-memory layer, caching can reduce the load on your database, and protect it from slower performance under load, or even from crashing at times of spikes.
</h4>

</div>
		
			
		
		
		
		
		
		
		





	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>