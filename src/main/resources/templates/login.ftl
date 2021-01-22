<#import "/spring.ftl" as spring/>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <link rel="stylesheet" type="text/css" href="/style.css">
  <title>Login</title>
</head>

<body>

<h2>${message!""}</h2>
<h4>
     Welcome   to   CAR   REPAIR   webApp
</h4>

<#if (errorMessage??)>
       <div class="alert alert-danger">
           <strong>Error!</strong> ${errorMessage}.
       </div>
    </#if>

<div class="containerl">
<div class="panel panel-default">
  <div class="panel-heading"><h3 class="panel-title"><strong>Sign In </strong></h3></div>
  <div class="panel-body">

    <form role="form" action="/login" method="post" id="loginForm" name="loginForm">
     <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
      </div>

      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-md btn-primary">Sign in</button>
    </form>

      </div>
        </div>
      </div>
      </div>
</body>
 <#include "footer.ftl"/>