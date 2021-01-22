<#import "/spring.ftl" as spring/>

<head>
  <title> Vehicle Details Form</title>
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



	<h1>Vehicle Details</h1>
	<br />

    <#if (showFailure??) >
     <div class="alert alert-danger">
          <strong>Error!</strong> ${showFailure!""}
     </div>
    </#if>


	<div class="row">
		<label class="col-sm-2">OWNER TAX ID:</label>
		<div class="col-sm-10">${vehicleDetails.afm}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">PLATE NUMBER:</label>
		<div class="col-sm-10">${vehicleDetails.plateNo}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">CAR MODEL:</label>
		<div class="col-sm-10">${vehicleDetails.carModel}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">CAR YEAR:</label>
		<div class="col-sm-10">${vehicleDetails.year}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">CAR COLOR:</label>
		<div class="col-sm-10">${vehicleDetails.color}</div>
	</div>

</div>

</body>
 <#include "footer.ftl"/>