<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel free/aesthetic/serene/around the world/TravelExpress</title>
<meta name="keywords" content="this is not useful in page ranks"> 
<meta name="description" content="travel/lifestyle/living">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
$(document).ready(function(){
var header = $('body');

var backgrounds = new Array(
	 'url(images/7.jpg)'
  , 'url(images/3.jpg)'
  , 'url(images/5.jpg)'
  , 'url(images/6.jpg)'
  , 'url(images/1.jpg)'
  , 'url(images/2.jpg)'
  , 'url(images/9.jpg)'
  , 'url(images/8.jpg)'
  , 'url(images/10.jpg)'
  ,'url(images/4.jpg)'
  , 'url(images/11.jpg)'
  );

var current = 0;

function nextBackground() {
    current++;
    current = current % backgrounds.length;
    header.css('background-image', backgrounds[current]);
}
setInterval(nextBackground, 6000);

header.css('background-image', backgrounds[0]);
});
</script>
</head>
<body>
<div align="center">
<p style="color:white" ><font size="6">TravelExpress</font><p/>
</div>
<form name="myform" method="post" action="NewPassword">

<div class="form">
  <div class="forceColor"></div>
  <div class="topbar">
    <div class="spanColor"></div>
    <input type="text" class="input" id="email_id" name="email_id" placeholder="email ID"/>
    <input type="password" class="input" id="password" name="password" placeholder="Password"/>
    <input type="password" class="input" id="confpassword" name="confpassword" placeholder="ConfirmPassword"/>
  </div>
  <button class="submit" id="submit" name="submit" >ChangePassword</button>
  
</div>


</form>

</body>
</html>