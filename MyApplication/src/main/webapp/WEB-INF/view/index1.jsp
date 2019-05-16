<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@page import="com.vikash.modal.Fileupload"%>
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
			<h1>What is Caching</h4>
		</div>
<h4>
In computing, a cache is a high-speed data storage layer which stores a subset of data, typically transient in nature, 
		so that future requests for that data are served up faster than is possible by accessing the data’s 
		primary storage location. Caching allows you to efficiently reuse previously retrieved or computed data.

</h4>
</div>

<div class="container" id="core div">
		
		<div>
		
		</div>
		
		<div class="container text-centered">
		<div class="alert alert-success">
		<h1>How does Caching work?</h1>
		</div>
		<h3>
		The data in a cache is generally stored in fast access hardware such as RAM (Random-access memory) and may also be used in correlation with a software component. A cache's primary purpose is to increase data retrieval performance by reducing the need to access the underlying slower storage layer.

Trading off capacity for speed, a cache typically stores a subset of data transiently, in contrast to databases whose data is usually complete and durable.
		</h3>
		</div>
		
			
		
		
		
		<div class="alert alert-success">
<h1>
		
		What is Different between Caching and non Caching??????
		</h1>
		</div>
		<img src="static/images/c2.png" width="800" height="600" >
		
		<h1>
		Post Method or Uploading a data 
		</h1>
		<img src="static/images/post.png" width="800" height="600" >
		
		
		
		
		



<div class="container text-center">
				<h3>Upload the File</h3>
				<hr>
				<form action="/uploadurban"  method="post" enctype="multipart/form-data">
					
					<div class="form-group">
						<label class="control-label col-md-3">Please upload the file Here</label>
						<div class="form-group ">
	
   						 <input type="file" class="btn btn-primary" name="file" required/><br><br>
   						 <select name="region">
  						<option value="Virginia">Virginia</option>
  						<option value="India">India</option>
  						<option value="Australia">Australia</option>
  						<option value="Franfurt">Franfurt</option>
  						<option value="South america">South america</option>
						</select>
						
						
						<%
						String s=new String();
						Fileupload fileupload=new Fileupload();
						s=request.getParameter("region");
						fileupload.setRegion(s);
						
						
						%>
   						 
   						
   						<ul>
  								<li> please enter the number of bytes to  reduce the band width   								
								</ul>
								<input type="text" class="form-control" name="rurbytes"
								value="${rurbyt.rurbytes }" required/>
								
    					<input type="submit" value="Click here to upload" class="btn btn-primary"/>
   					
					</div>
					</div>
					</form>
					</div>
				
			




	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>