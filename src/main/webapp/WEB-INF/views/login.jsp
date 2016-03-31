<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
 <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.css">
 <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
 <link rel="stylesheet" type="text/css" href="resources/css//bootstrap-theme.min.css">
 <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
 <link href='http://fonts.googleapis.com/css?family=Alegreya+Sans:400,700,500italic' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" type="text/css" href="resources/css/stylesCSS.css">
 <script src = "http://code.jquery.com/jquery-2.1.4.js"></script>


<title></title>
</head>
<body>
<div class = "container">
	<div class = "row">
		
		<div class = "col-md-3">
		<img class = "title-logo" src = "resources/images/logo.png"/>
			<h4><div class = "text-center">
				<c:if test="${sessionScope.login!= null}">
				<b>Hello, <c:out value="${sessionScope.login}"/>!</b>
				</c:if>
				<c:if test="${sessionScope.login == null}">
				<b>Hello, <c:out value="quest"/>!</b>
				</c:if>
			</div></h4>
		</div>
		<div class = "col-md-9">
			<h1><p class="text-center text-capitalize title-super">Welcome to Phonebook</p></h1>
			<h4 class ="text-center"> Test assignment for lardi</h4>
		
	</div class = "button_class">
	
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
			<div class="btn-group" role="group">
				<a href="index" id="btn">
					<button type="button" class="btn btn-default">Main</button>
				</a>
		</div>
		<div class="btn-group" role="group">
			<a href="login" id="btn">
				<button type="button" class="btn btn-default" >LogIN</button>
			</a>
		</div>
		<div class="btn-group" role="group">
			<a href="about" id="btn">
				<button type="button" class="btn btn-default">About</button>
			</a>
		</div>
	</div>
	
	<div class = "col-md-12">
		<div class = "loginPass">
			<form class="form-inline"  method = "post" action = "logining">
  				<div class="form-group">
    			<label class="sr-only" for="exampleInputEmail3">Email address</label>
   			 <input class="form-control" placeholder="Email" name = "login" >
 			 </div>
  			<div class="form-group">
    			<label class="sr-only" for="exampleInputPassword3">Password</label>
    		<input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
  		</div>
  			<div class="checkbox">
    			<label>
    		  <input type="checkbox"> Remember me
   			 </label>
  			</div>
  			<button type="submit" class="btn btn-default regLink">Sign in</button>
  			<a href="registration" id = "btn" class = "regLink"> Register </a>
			</form>
			
		</div>		
		
	</div>
	<div class = "footer">
		<div class = "row">
		
			<div class = "col-md-8">
			</div >
			<div class = "col-md-4">
			
				<address>
				<strong>Kiev, Ukraine</strong><br>
				<a href="mailto:#">volokhink@gmail.com</a>
				</address>
		    </div>
		</div>
	</div>
	
</div>
</div>
</body>
</html>