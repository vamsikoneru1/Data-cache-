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
					<li><a href="/edgenetwork">Edge network</a></li>
					<li><a href="/allimages2">Downloaded details</a></li>
					<li><a href="/dl">download demo</a></li>
					<li><a href="/index">Upload demo</a></li>
					<li><a href="/uploaddata">uploaded data</a></li>
					<li><a href="/advantage">Advantage of cache</a></li>
				</ul>
			</div>
		</div>
	</div>


<div class="container text-center">
				<h3>Upload the File</h3>
				<hr>
				<form action="/downlaod" >
					
					<div class="form-group">
						<label class="control-label col-md-3">Please enter the file you want to download</label>
						<div class="form-group ">
	
   						 
   						 
   						 <input type="text" class="form-control" name="filename" value="${fileupload.filename}" required="required">
   						
   						 
    					<input type="submit" class="btn btn-primary"/>
   					
   					

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