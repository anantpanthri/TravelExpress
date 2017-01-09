<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NewUserLogin</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
$(document).ready(function(){
var header = $('body');

var backgrounds = new Array(
	 'url(images/11.jpg)'
  ,'url(images/7.jpg)'
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
setInterval(nextBackground, 8000);

header.css('background-image', backgrounds[0]);
});
</script>
</head>
<body>
<form name="myform" method="post" action="NewUser">

<div class="form">
  <div class="forceColor"></div>
  <div class="topbar">
    <div class="spanColor"></div>
    <input type="text" class="input" name="name" placeholder="Name"/>
    <input type="text" class="input" name="address" placeholder="Address"/>
    <input type="text" class="input" name="emailId" placeholder="Email Address"/>
    <input type="text" class="input" name="contact" placeholder="Contact info"/>
    <input type="password" class="input" name="password" placeholder="Password"/>
     <input type="password" class="input" name="confPassword" placeholder="Confirm Password"/>
  </div>
  <button class="submit" id="submit" name="submit" >OK</button>
  
</div>


</form>
</body>
</html>