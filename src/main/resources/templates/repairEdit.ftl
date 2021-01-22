<#import "/spring.ftl" as spring/>

<head>
  <title>Edit Service</title>
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

    <#if (success??) >
     <div class="alert alert-success">
          <strong>Success!</strong> Service has been Edited.
     </div>
    </#if>

    <#if (error??) >
     <div class="alert alert-danger">
          <strong>Error!</strong> Could not edit service.
     </div>
    </#if>


     <form class="form-horizontal" action="/admin/repairSearch/{id}/edit" method="post" id="repairToEdit" name="repairToEdit">

        <fieldset>

            <!-- Form Name -->
            <legend>Edit Existing Service:</legend>

            <!-- repairID input-->
            <div>
                <@spring.bind "repairToEdit.repairId"/>
                <input type="hidden" name="repairId" value="${repairToEdit.repairId}"/>
            </div>

     <!-- Vehicle's plateNo input-->
                 <div class="form-group">
                     <@spring.bind "repairToEdit.vehiclePlateNo"/>
                     <label class="col-sm-2 control-label">Plate Number:</label>
                     <div class="col-sm-10">
                         <input  name="vehiclePlateNo" value="${repairToEdit.vehiclePlateNo!""}" id="vehiclePlateNo"  placeholder="Plate Number..." class="form-control"  type="text" readonly>
                         <#list spring.status.errorMessages as error>
                             <span> <h5 style="color:red;">${error}</h5> </span>
                         </#list>

                     </div>

                 </div>

                 <!-- Repair Date input-->
                 <div class="form-group">
                     <@spring.bind "repairToEdit.repairDate"/>
                     <label class="col-sm-2 control-label">Service Date:</label>
                     <div class="col-sm-10">
                         <input  name="repairDate" value="${repairToEdit.repairDate!""}" id="repairDate"  placeholder="Service Date..." class="form-control"  type="date" >
                         <#list spring.status.errorMessages as error>
                             <span> <h5 style="color:red;">${error}</h5> </span>
                         </#list>

                     </div>

                 </div>

                 <!-- Repair Time input-->
                 <div class="form-group">
                     <@spring.bind "repairToEdit.repairTime"/>
                     <label class="col-sm-2 control-label">Service Time:</label>
                     <div class="col-sm-10">
                         <input  name="repairTime" value="${repairToEdit.repairTime!""}" id="repairTime"  placeholder="example: hh:mm:ss" class="form-control"  type="time">
                         <#list spring.status.errorMessages as error>
                             <span> <h5 style="color:red;">${error}</h5> </span>
                         </#list>

                     </div>

                 </div>


                 <!-- Repair Status input-->
                     <div class="form-group">
                         <@spring.bind "repairToEdit.repairStatus"/>
                         <label class="col-sm-2 control-label">Service Status:</label>
                         <div class="col-sm-10">
                                 <select class="form-control" id="repairStatus" name="repairStatus">
                                     <option value="On_Hold" selected="selected">On_Hold</option>
                                     <option value="In_Progress" >In_Progress</option>
                                     <option value="Completed" >Completed</option>
                                 </select>
                         <#list spring.status.errorMessages as error>
                             <span> <h5 style="color:red;">${error}</h5> </span>
                         </#list>
                         </div>
                     </div>

                 <!-- Repair Type input-->
                 <div class="form-group">
                     <@spring.bind "repairToEdit.repairType"/>
                     <label class="col-sm-2 control-label">Service Type:</label>
                     <div class="col-sm-10">
                                 <select class="form-control" id="repairType" name="repairType">
                                     <option value="Small"  selected="selected">Small</option>
                                     <option value="Big" >Big</option>
                                 </select>
                         <#list spring.status.errorMessages as error>
                             <span> <h5 style="color:red;">${error}</h5> </span>
                         </#list>

                     </div>

                 </div>

                 <!-- Repair Cost input-->
                 <div class="form-group">
                     <@spring.bind "repairToEdit.repairCost"/>
                     <label class="col-sm-2 control-label">Service Cost:</label>
                     <div class="col-sm-10">
                         <input name="repairCost" value="${repairToEdit.repairCost!""}" id="repairCost"  placeholder="Service Cost..."  class="form-control"  type="text"/>
                         <#list spring.status.errorMessages as error>
                             <span> <h5 style="color:red;">${error}</h5> </span>
                         </#list>

                     </div>

                 </div>

                 <!-- Repair Description input-->
                 <div class="form-group">
                     <@spring.bind "repairToEdit.repairDescription"/>
                     <label class="col-sm-2 control-label">Service Description:</label>
                     <div class="col-sm-10">
                         <textarea  name="repairDescription" value="${repairToEdit.repairDescription!""}" id="repairDescription"  placeholder="Service Description..." class="form-control"  type="text"></textarea>
                         <#list spring.status.errorMessages as error>
                             <span> <h5 style="color:red;">${error}</h5> </span>
                         </#list>

                     </div>

                 </div>


        <!-- Submit-->
          <div class="form-group">
                      <div class="col-md-12 text-right">
                        <button type="submit" class="btn btn-primary btn-lg">Edit Service
                        </button>
                     </div>
           </div>

       </fieldset>
     </form>
    </div>
</body>
 <#include "footer.ftl"/>