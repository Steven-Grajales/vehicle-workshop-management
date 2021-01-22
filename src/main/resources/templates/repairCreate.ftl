<#import "/spring.ftl" as spring/>

<head>
     <title> Service Registration Form</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="/stylecreat.css">
</head>

<body>


<#include "/navbar.ftl">

    <div class="container">

        <#if (success??) >
         <div class="alert alert-success">
              <strong>Success!</strong> Service has been Created.
         </div>
        </#if>

        <#if (error??) >
         <div class="alert alert-danger">
              <strong>Error!</strong> Vehicle with the specified Plate Number not found.
         </div>
        </#if>

        <form class="form-horizontal" action="/admin/repairCreate" method="post" id="repairCreateForm" name="repairCreateForm">

            <fieldset>

                <!-- Form Name -->
                <legend>Create new Service:</legend>

                <!-- Vehicle's plateNo input-->
                <div class="form-group">
                    <@spring.bind "repairCreateForm.vehiclePlateNo"/>
                    <label class="col-sm-2 control-label">Plate Number:</label>
                    <div class="col-sm-10">
                        <input  name="vehiclePlateNo" id="vehiclePlateNo"  placeholder="Plate Number..." class="form-control"  type="text">
                        <#list spring.status.errorMessages as error>
                            <span> <h5 style="color:red;">${error}</h5> </span>
                        </#list>

                    </div>

                </div>

                <!-- Repair Date input-->
                <div class="form-group">
                    <@spring.bind "repairCreateForm.repairDate"/>
                    <label class="col-sm-2 control-label">Service Date:</label>
                    <div class="col-sm-10">
                        <input  name="repairDate" id="repairDate"  placeholder="Service Date..." class="form-control"  type="date">
                        <#list spring.status.errorMessages as error>
                            <span> <h5 style="color:red;">${error}</h5> </span>
                        </#list>

                    </div>

                </div>

                                <!-- Repair Time input-->
                                <div class="form-group">
                                    <@spring.bind "repairCreateForm.repairTime"/>
                                    <label class="col-sm-2 control-label">Service Time:</label>
                                    <div class="col-sm-10">
                                        <input  name="repairTime" id="repairTime"  placeholder="example: hh:mm:ss" class="form-control"  type="time">
                                        <#list spring.status.errorMessages as error>
                                            <span> <h5 style="color:red;">${error}</h5> </span>
                                        </#list>

                                    </div>

                                </div>


                <!-- Repair Status input-->
                    <div class="form-group">
                        <@spring.bind "repairCreateForm.repairStatus"/>
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
                    <@spring.bind "repairCreateForm.repairType"/>
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
                    <@spring.bind "repairCreateForm.repairCost"/>
                    <label class="col-sm-2 control-label">Service Cost:</label>
                    <div class="col-sm-10">
                        <input name="repairCost" id="repairCost"  placeholder="Service Cost..."  class="form-control"  type="text"/>
                        <#list spring.status.errorMessages as error>
                            <span> <h5 style="color:red;">${error}</h5> </span>
                        </#list>

                    </div>

                </div>

                <!-- Repair Description input-->
                <div class="form-group">
                    <@spring.bind "repairCreateForm.repairDescription"/>
                    <label class="col-sm-2 control-label">Service Description:</label>
                    <div class="col-sm-10">
                        <textarea  name="repairDescription" id="repairDescription"  placeholder="Service Description..." class="form-control"  type="text"></textarea>
                        <#list spring.status.errorMessages as error>
                            <span> <h5 style="color:red;">${error}</h5> </span>
                        </#list>

                    </div>

                </div>


                <div class="form-group">
                    <div class="col-md-12 text-right">
                        <button type="submit" class="btn btn-primary btn-lg" onClick="GetSelectedItems('repairStatus','repairType');">Create Service</button>
                    </div>

                </div>
            </fieldset>
        </form>


    </div>


</body>
 <#include "footer.ftl"/>