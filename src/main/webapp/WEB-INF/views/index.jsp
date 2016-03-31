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
		<img class = "title-logo" src = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSQEcCeE5E1GCBkXHQwR_cTlK6MJnWImhOGaTJ4cO00thCosl1X"/>
			<h4><div class = "text-center">
				<c:if test="${sessionScope.login!= null}">
				<b>Hello, <c:out value="${sessionScope.login}"/>!</b>
				</c:if>
				<c:if test="${sessionScope.login == null}">
				<b>Hello, <c:out value="guest"/>!</b>
				</c:if>
				<a href="#" class = "myLink"> log Out</a>
			</div></h4>
		</div>
		<div class = "col-md-9">
			<h1><p class="text-center text-capitalize title-super">Welcome to Phonebook</p></h1>
			<h4 class ="text-center">Test assignment for lardi</h4>
		
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
			<form action="" class = form method = "post">
			<div class = "col-md-12">
            			<c:forEach var = "news" items = "${sessionScope.news}">
            				
            				<div class = "col-md-11, news_block">	
            				<input type = "checkbox" name = "selected" value = "${news.title}" class = "text-right">
            					<a href = <c:out value = "${news.link}"/>> <h1 class = "h3"><c:out value = "${news.title}"/></h1></a>		
            					<c:out value = "${news.description}" escapeXml = "false"/>
            				</div>
            			</c:forEach>
            			<div class = "col-md-12, text-center">	
            			<input type = "submit" value = "    Save to Archive   ">
            			</div>
            			</div>
			</form>
		
	
	
	
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