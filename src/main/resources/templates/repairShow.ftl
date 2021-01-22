<#import "/spring.ftl" as spring/>

<head>
 <title>Service Details</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/stylesh.css">
</head>

<body>

<#include "/navbar.ftl">

 <div class="container">

	<h1>Service Details</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">Plate Number:</label>
		<div class="col-sm-10">${repairDetails.vehiclePlateNo}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Service Date:</label>
		<div class="col-sm-10">${repairDetails.repairDate!""}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Service Time:</label>
		<div class="col-sm-10">${repairDetails.repairTime!""}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Status:</label>
		<div class="col-sm-10">${repairDetails.repairStatus!""}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Type:</label>
		<div class="col-sm-10">${repairDetails.repairType!""}</div>
	</div>

		<div class="row">
    		<label class="col-sm-2">Description:</label>
    		<div class="col-sm-10">${repairDetails.repairDescription!""}</div>
    	</div>

</div>


</body>
 <#include "footer.ftl"/>