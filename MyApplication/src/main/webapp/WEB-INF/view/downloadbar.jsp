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
	<div class="container">
		<h2 align="center">Download graph</h2>

		


<div id="piechart"></div>
<div id="barchart"></div>
<div id="linechart"></div>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values


function drawChart() {
	
	
	 
	 var data = google.visualization.arrayToDataTable([
		  ['Country', 'Time to download'],
		  <c:forEach items="${udata}" var="entry">
		  [ '${entry.region}', ${entry.dbtime} ],
		  </c:forEach>
		  ]);


	 
 
  // Optional; add a title and set the width and height of the chart
  var options = {'title':' download data : this represents various graphs which takes the details of downloaded data and represtes in graphs such as Geo,Line,Bar etc ', 'width':1000, 'height':950,is3D: true,};
  var options1 = {'title':'AWS download data', legend: { position: 'none' },};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.BarChart(document.getElementById('piechart'));
  chart.draw(data, options);
  
  var chart = new google.visualization.LineChart(document.getElementById('linechart'));
  chart.draw(data, options);
  
  var chart = new google.visualization.GeoChart(document.getElementById('barchart'));
  chart.draw(data, options);
  
 
}
</script>




<c:forEach var="upload" items="${udata}">
								
									
									${upload.dbtime}
									
									${upload.region}
								
							</c:forEach>

</body>


</html>