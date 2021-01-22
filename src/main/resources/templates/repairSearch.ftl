<#import "/spring.ftl" as spring/>

<head>
  <title>Service Search </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <link rel="stylesheet" type="text/css" href="/stylesear.css">
</head>

<body>


<#include "/navbar.ftl">

   <div class="container">
       <h1>Service Search</h1>
       <div class="row">
         <form  class="form-inline" action="/admin/repairSearch" method="post" name="repairSearchForm id=name="repairSearchForm">

           <div class="form-group">
              <@spring.bind "repairSearchForm.searchText"/>
             <input type="text" class="form-control" name="SearchText" id="SearchText" placeholder="Search by Date or plate number...">
             <span style="display: inline;" class="input-group-btn">
               <button class="btn btn-default btn-primary" type="submit">Search</button>
             </span>
           </div>

            </div>
          </form>
       <p>&nbsp;</p>

      <#if (repairList??) && (repairList?size > 0 )>
          <table id="repairTable" class="table" >
             <thead>
               <tr>
                    <th>#ID</th>
                    <th>Plate Number</th>
                    <th>Service Date</th>
                    <th>Service Time</th>
                    <th>Status</th>
                    <th>Type</th>
                    <th>Cost</th>
                    <th> &emsp;Actions</th>
               </tr>
             </thead>

             <tbody>

                 <#list repairList as repair>

                    <tr>
                        <th scope="row">${repair?counter}</th>
                        <td>${repair.vehiclePlateNo!""}</td>
                        <td>${repair.repairDate!""}</td>
                        <td>${repair.repairTime!""}</td>
                        <td>${repair.repairStatus!""}</td>
                        <td>${repair.repairType!""}</td>
                        <td>${repair.repairCost!""}</td>
                        <td>
                            <form style="float: left;" class="form"  action="/admin/repairSearch/${repair.repairId}/show" method="GET">
                                    <input class="btn btn-sm btn-info" type="submit" value="Show"/>&emsp;
                             </form>

                            <form style="float: left;" class="form" action="/admin/repairSearch/${repair.repairId}/edit" method="GET">
                                <input class="btn btn-sm btn-primary" type="submit" value="Edit"/>&emsp;
                            </form>

                            <form style="float: left;" class="form" action="/admin/repairSearch/${repair.repairId}/delete" method="POST">
                                 <input class="btn btn-sm btn-danger" type="submit" value="Delete"/>
                            </form>
                        </td>
                    </tr>
                 </#list>
             </tbody>
         </table>
       <#else>
            <div class="alert alert-danger">
              <strong>Error!</strong> No Services found.
             </div>
       </#if>
    </div>
<p></p>
<p></p>
</body>

<#include "footer.ftl"/>