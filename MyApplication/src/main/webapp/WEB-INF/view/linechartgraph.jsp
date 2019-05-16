<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns:th="http://www.thymeleaf.org">

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

<head>
<meta charset="ISO-8859-1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />

</head>
<body>


<div id="piechart"></div>
<div id="barchart"></div>
<div id="linechart"></div>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);
google.charts.setOnLoadCallback(drawChart1);
// Draw the chart and set the chart values


function drawChart() {
	
	
	 
	 var data = google.visualization.arrayToDataTable([
		  ['Country', 'Time to upload'],
		  <c:forEach items="${udata}" var="entry">
		  [ '${entry.region}', ${entry.dbtime} ],
		  </c:forEach>
		  ]);


	 
 
  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Cache Uplaod data : This Line Diagram Represent the Time taken to upload to cache ,visualize a trend in data over intervals of time and	 files which are uploaded in diffent regions', 'width':1000, 'height':950,is3D: true,};
  var options1 = {'title':'Cache Uplaod data', legend: { position: 'none' },};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.LineChart(document.getElementById('piechart'));
  chart.draw(data, options);
 
  
 
}

function drawChart1() {
	
	
	 
	 var data1 = google.visualization.arrayToDataTable([
		  ['Country', 'Time to upload'],
		  <c:forEach items="${udata}" var="entry">
		  [ '${entry.region}', ${entry.awstime} ],
		  </c:forEach>
		  ]);


	 

// Optional; add a title and set the width and height of the chart
  var options = {'title':'Cache Uplaod data : This Line Diagram Represent the Time taken to upload to server ,visualize a trend in data over intervals of time and	 files which are uploaded in diffent regions', 'width':1000, 'height':950,is3D: true,};
var options1 = {'title':'AWS Uplaod data', legend: { position: 'none' },};

// Display the chart inside the <div> element with id="piechart"
var chart = new google.visualization.LineChart(document.getElementById('barchart'));
chart.draw(data1, options);



}
</script>




<c:forEach var="upload" items="${udata}">
								
									
									${upload.dbtime}
									
									${upload.region}
								
							</c:forEach>

</body>
</html>