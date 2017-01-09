<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/itenary.css"> 
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script language="javascript"> 

$(document).ready(function(){
	var header = $('body');

	var backgrounds = new Array(
		 'url(hotels/hero.jpg)'
	  	  );

	var current = 0;

	function nextBackground() {
	    current++;
	    current = current % backgrounds.length;
	    header.css('background-image', backgrounds[current]);
	}
	setInterval(nextBackground, 200000);

	header.css('background-image', backgrounds[0]);
	});
	
function access(s,y){ 
	document.getElementById('sn').value= s;
	document.getElementById('ppm').value= y;
} 


</script> 
<link rel="stylesheet" href="css/itenary.css"> 
</head>

<body>
	<div class="container">
	<div class="calendar-container">


	<header>
				
				<div class="day">30 November</div>
				<div class="month">ITINERARY</div>

	</header>
	<form name="form" method="post" action="Welcome.jsp">
<table class="calendar">

 <thead>
 <tr> <h1>User: <c:out value="${username}"/></h1></tr>
 </thead>
 <tbody>
 	<tr>
       <td><h2>DEPARTURE CITY: <c:out value="${itobj.DEPARTURE_CITY}"/></h2></td>
    </tr>
    <tr>
     <td><h2>TRANSPORT: <c:out value="${itobj.MODE_OF_TRANSPORT}"/></h2></td>
     </tr>
     <tr>
       <td><h2>HOTEL NAME: <c:out value="${itobj.HOTEL_NAME}"/></h2></td>
       </tr>
       <tr>
       <td><h2>HOTEL PRICE: <c:out value="${itobj.HOTEL_PRICE}"/></h2></td>
       </tr>
       <tr>
       <td><h2>DEPENDENTS: <c:out value="${itobj.NUMBER_OF_DEPENDENTS}"/></h2></td>
       </tr>
      <tr>
         <td> <button class="button" id="submit" name="logout">LogOut</button>  </td> 
        </tr>
  </tbody> 
  </table>
  </form>
  <div class="ring-left"></div>
<div class="ring-right"></div>
  </div>
  </div>
</body>
</thead>
</html>