<#import "/spring.ftl" as spring/>

<head>
 <title> Owner Details </title>
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



	<h1>Owner Details</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID:</label>
		<div class="col-sm-10">${userDetails.userID}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Tax Number:</label>
		<div class="col-sm-10">${userDetails.afm}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Fisrt Name:</label>
		<div class="col-sm-10">${userDetails.firstname}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Last Name:</label>
		<div class="col-sm-10">${userDetails.lastname}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email:</label>
		<div class="col-sm-10">${userDetails.email}</div>
	</div>

    <div class="row">
        <label class="col-sm-2">Address:</label>
        <div class="col-sm-10">${userDetails.address}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">User Type:</label>
        <div class="col-sm-10">${userDetails.role}</div>
    </div>


</div>


</body>
 <#include "footer.ftl"/>