<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="style.css">
        <script src="login.js"></script>
        
    </head>
  </head>
  <body>
          <div>
               <img src="hrc-logo.jpg">
          </div>
<div class="paragraph">
<B>ORDER MANAGEMENT APPLICATION</B>
</div>  
<div>  <form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
 
<div class="login-box">
  <h1>Sign in</h1>
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="text" name="username" placeholder="Username" >
  </div>

  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" name="password" placeholder="Password" >
  </div>

  <input type="button" class="btn" value="Sign in">
</div>
 </form>  
</div>
  </body>
</html>