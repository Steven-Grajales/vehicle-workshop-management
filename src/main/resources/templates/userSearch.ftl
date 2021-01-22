<#import "/spring.ftl" as spring/>

<head>
 <title> User Search Form</title>
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
   <#if (success??) >
    <div class="alert alert-success">
         <strong>Success!</strong> New User has been registered.
    </div>
   </#if>

   <#if (error??) >
    <div class="alert alert-danger">
         <strong>Error!</strong> User with the specified afm not found.
    </div>
   </#if>
       <h1>Admin</h1>
       <div class="row">
         <form  class="form-inline" action="/admin/userSearch" method="post" name="UserSearchForm id="UserSearchForm">

           <div class="form-group">
             <input type="text" class="form-control" name="SearchText" id="SearchText" placeholder="Search with AFM or Email...">
             <span style="display: inline;" class="input-group-btn">
               <button class="btn btn-default btn-primary" type="submit">Search</button>
             </span>
           </div>

            </div>
    <p>&nbsp;</p>
           <!-- /input-group -->
           <!--
          <div class="col-sm-4 col-sm-offset-7">
           <div class="form-group ">
             <label class="col-sm- control-label">Search by:</label>
 				<label class="radio-inline">
                   <input type="radio" name="afm" id="userSearchType" value="afm" />Tax Id
 				</label>
                <label class="radio-inline">
                   <input type="radio" checked="checked" name="afm" id="afm" value="email" />Email
 				</label> <br />
 			</div>
 		  </div>  -->
 		  </form>

<#if (users??) && (users?size>0)>
       <table class="table" >
         <thead>
           <tr>
             <th>#ID</th>
             <th>First Name</th>
             <th>Last Name</th>
             <th>Afm</th>
             <th>Email</th>
             <th>Address</th>
             <th>User Type</th>
             <th>Actions</th>
           </tr>
         </thead>
         <tbody>

          <#list users as user>
           <tr>
             <th scope="row">${user?counter}</th>
             <td>${user.firstname!""}</td>
             <td>${user.lastname!""}</td>
             <td>${user.afm}</td>
             <td>${user.email}</td>
             <td>${user.address!""}</td>
             <td>${user.role}</td>
             <td>
              <form style="float: left;" class="form"  action="/admin/userSearch/${user.afm}/show" method="GET">
                      <input class="btn btn-sm btn-info" type="submit" value="Show"/>&emsp;
               </form>

             <form style="float: left;" class="form"  action="/admin/userUpdate/${user.afm}" method="GET">
                   <input class="btn btn-sm btn-default" type="submit" value="Edit"/>&emsp;
             </form>

             <form style="float: left;" class="form"  action="/admin/userDelete/${user.afm}" method="POST">
                   <input class="btn btn-sm btn-danger" type="submit" value="Delete"/>
             </form>
             </td>


           </tr>
          </#list>
           </tbody>
         </table>
             <#else>
                  <div class="alert alert-danger">
                        <strong>Error!</strong> No Users found.
                  </div>
          </#if>
   </div>
 </body>
 <#include "footer.ftl"/>

