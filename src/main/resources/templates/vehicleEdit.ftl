<#import "/spring.ftl" as spring/>

<head>
  <title> Vehicle Edit Form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <link rel="stylesheet" type="text/css" href="/styleedit.css">
</head>

<body>


<#include "/navbar.ftl">

<div class="container">

<#if (editSuccess??) >
 <div class="alert alert-success">
      <strong>Success!</strong> ${createSuccess!""}
 </div>
</#if>

<#if (duplicatePlateFailure??) >
 <div class="alert alert-danger">
      <strong>Error!</strong> ${duplicatePlateFailure!""}
 </div>
</#if>

<#if (editError??) >
 <div class="alert alert-danger">
      <strong>Error!</strong> ${editError!""}
 </div>
</#if>


 <form class="form-horizontal" action="/admin/vehicleSearch/{id}/edit" method="post" id="vehicleToEdit" name="vehicleToEdit">

    <fieldset>

<!-- Form Name -->
<legend>Edit existing vehicle:</legend>


<!-- userID input-->
<div>
    <@spring.bind "vehicleToEdit.vehicleId"/>
    <input type="hidden" name="vehicleId" value="${vehicleToEdit.vehicleId}"/>
</div>

<!-- afm output-->
<div class="form-group">
  	<@spring.bind "vehicleToEdit.afm"/>
  	<label class="col-sm-2 control-label">Owner Tax Id:</label>
  	<div class="col-sm-10">
   		 <input  name="afm" id="afm" value="${vehicleToEdit.afm!""}" class="form-control"  type="text" readonly>
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>
  	</div>
</div>


<!-- plateNo input-->
<div class="form-group">
  	<@spring.bind "vehicleToEdit.plateNo"/>
  	<label class="col-sm-2 control-label">Plate Number:</label>
  	<div class="col-sm-10">
   		 <input  name="plateNo" id="plateNo" value="${vehicleToEdit.plateNo!""}"  placeholder="Plate Number.." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>
  	</div>
</div>



<!-- carModel input-->
<div class="form-group">
  	<@spring.bind "vehicleToEdit.carModel"/>
  	<label class="col-sm-2 control-label">Car Model:</label>
  	<div class="col-sm-10">
   		 <input  name="carModel" id="carModel" value="${vehicleToEdit.carModel!""}"  placeholder="Car Model..." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- year input-->
<div class="form-group">
  	<@spring.bind "vehicleToEdit.year"/>
  	<label class="col-sm-2 control-label">Car year:</label>
  	<div class="col-sm-10">
   		 <input  name="year" id="year" value="${vehicleToEdit.year!""}"  placeholder="Car year..." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- color input-->
<div class="form-group">
  	<@spring.bind "vehicleToEdit.color"/>
  	<label class="col-sm-2 control-label">Color:</label>
  	<div class="col-sm-10">
   		 <input name="color" id="color" value="${vehicleToEdit.color!""}"  placeholder="Car color..."  class="form-control"  type="text"/>
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- Submit-->

  <div class="form-group">
              <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-primary btn-lg">Edit vehicle
              </div>


                </fieldset>
 </form>


        </div>


</body>
 <#include "footer.ftl"/>