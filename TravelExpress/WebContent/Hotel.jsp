<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/hotel.css"> 
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script language="javascript"> 

$(document).ready(function(){
	var header = $('body');

	var backgrounds = new Array(
		 'url(hotels/7.jpg)'
	  , 'url(hotels/3.jpg)'
	  , 'url(hotels/5.jpg)'
	  , 'url(hotels/6.jpg)'
	  , 'url(hotels/1.jpg)'
	  , 'url(hotels/2.jpg)'
	  , 'url(hotels/9.jpg)'
	  , 'url(hotels/8.jpg)'
	  , 'url(hotels/10.jpg)'
	  ,'url(hotels/4.jpg)'
	  , 'url(hotels/11.jpg)'
	  );

	var current = 0;

	function nextBackground() {
	    current++;
	    current = current % backgrounds.length;
	    header.css('background-image', backgrounds[current]);
	}
	setInterval(nextBackground, 2000);

	header.css('background-image', backgrounds[0]);
	});
	
function access(s,y){ 
	document.getElementById('sn').value= s;
	document.getElementById('ppm').value= y;
} 


</script> 
</head>
<body>
  
<form name="form" method="post" action="PreConfirmation">
<input type="hidden" id="ppm" name="price_per_night" value="" />
<input type="hidden" id="sn" name="hotel_name" value="" />
  <h1 class="title" style="font-family:Franklin Gothic Medium;"> Select Hotels </h1>
  <div id="container">
    <div class="pricetab">
     <c:forEach items="${hotelPriceList}" var="gm" begin="0" end="0">
      <h1> <c:out value="${itobj.ARRIVAL_CITY}"/> </h1>
      <div class="price"> 
   
        <h2> <c:out value="${gm.price_per_night}"/>$</h2> 
      </div>
      <div class="infos">
        <h3> RATING- <c:out value="${gm.user_ratings}"/></h3>
        <h3> HOTEL- <c:out value="${gm.hotel_name}"/></h3>
        <h3> ADDRESS- <c:out value="${gm.address_line1}"/></h3>
       </div>
    
      <div class="pricefooter">
        <div class="button">
          <button class="button" id="submit" name="submit" onclick="javascript:access('${gm.hotel_name}','${gm.price_per_night}');" >Get started</button>  
        </div>
      </div>
      </c:forEach>
    </div>
    <div class="pricetab">
     <c:forEach items="${hotelPriceList}" var="gm" begin="1" end="1">
      <h1> <c:out value="${itobj.ARRIVAL_CITY}"/> </h1>
      <div class="price"> 
       <h2> <c:out value="${gm.price_per_night}"/>$</h2>  
      </div>
      <div class="infos">
        <h3> RATING- <c:out value="${gm.user_ratings}"/></h3>
        <h3> HOTEL- <c:out value="${gm.hotel_name}"/></h3>
        <h3> ADDRESS- <c:out value="${gm.address_line1}"/> </h3>
      </div>
     
      <div class="pricefooter">
        <div class="button">
          <button class="button" id="submit" name="submit" onclick="javascript:access('${gm.hotel_name}','${gm.price_per_night}');" >Get started</button>  
        </div>
      </div>
       </c:forEach>
    </div>
    <div class="pricetabmid">
    <c:forEach items="${hotelPriceList}" var="gm" begin="2" end="2">
      <h1> <c:out value="${itobj.ARRIVAL_CITY}"/>  </h1>
      <div class="pricemid"> 
       <h2> <c:out value="${gm.price_per_night}"/>$</h2> 
      </div>
      <div class="infos">
        <h3>  RATING- <c:out value="${gm.user_ratings}"/> </h3>
        <h3>HOTEL- <c:out value="${gm.hotel_name}"/> </h3>
        <h3> ADDRESS- <c:out value="${gm.address_line1}"/> </h3>
      </div>
      <div class="pricefootermid">
         <div class="buttonmid">
          <button class="button" id="submit" name="submit" onclick="javascript:access('${gm.hotel_name}','${gm.price_per_night}');" >Get started</button>  
        </div>
      </div>
      </c:forEach>
    </div>
    <div class="pricetab">
     <c:forEach items="${hotelPriceList}" var="gm" begin="3" end="3">
      <h1> <c:out value="${itobj.ARRIVAL_CITY}"/> </h1>
      <div class="price"> 
       <h2> <c:out value="${gm.price_per_night}"/>$</h2> 
      </div>
      <div class="infos">
        <h3>  RATING- <c:out value="${gm.user_ratings}"/> </h3>
        <h3>HOTEL- <c:out value="${gm.hotel_name}"/> </h3>
        <h3> ADDRESS- <c:out value="${gm.address_line1}"/> </h3>
      </div>
      <div class="pricefooter">
        <div class="button">
          <button class="button" id="submit" name="submit" onclick="javascript:access('${gm.hotel_name}','${gm.price_per_night}');" >Get started</button>  
        </div>
      </div>
      </c:forEach>
    </div>
    <div class="pricetab">
      <c:forEach items="${hotelPriceList}" var="gm" begin="4" end="4">
      <h1> <c:out value="${itobj.ARRIVAL_CITY}"/> </h1>
      <div class="price"> 
       <h2> <c:out value="${gm.price_per_night}"/>$ </h2> 
      </div>
      <div class="infos">
       <h3>  RATING- <c:out value="${gm.user_ratings}"/> </h3>
        <h3>HOTEL- <c:out value="${gm.hotel_name}"/> </h3>
        <h3> ADDRESS- <c:out value="${gm.address_line1}"/> </h3>
      </div>
      <div class="pricefooter">
         <div class="button">
          <button class="button" id="submit" name="submit" onclick="javascript:access('${gm.hotel_name}','${gm.price_per_night}');" >Get started</button>   
        </div>
      </div>
      </c:forEach>
    </div>
  </div>
  </form>
</body>
</html>