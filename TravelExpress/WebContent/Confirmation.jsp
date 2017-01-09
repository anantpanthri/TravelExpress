<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/confirmation.css"> 
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
$(document).ready(function(){
var header = $('body');

var backgrounds = new Array(
	 'url(images/7.jpg)'
  , 'url(hotels/3.jpg)'
  , 'url(images/5.jpg)'
  , 'url(hotels/6.jpg)'
  , 'url(images/1.jpg)'
  , 'url(hotels/2.jpg)'
  , 'url(images/9.jpg)'
  , 'url(images/8.jpg)'
  , 'url(hotels/10.jpg)'
  ,'url(images/4.jpg)'
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
</script> 
</head>
<body>
  <div class="intro">
</div>
<form name="form" method="post" action="Confirmation">
<input type="hidden" id="ppm" name="price_per_night" value="" />
<input type="hidden" id="sn" name="hotel_name" value="" />
  <h1 class="title" style="font-family:Franklin Gothic Medium;"> Confirmation </h1>
    <div class="pricetab">
      <h2>You are almost done, <c:out value="${username}"/> Total: <c:out value="${total_price}"/> </h2>
       <h2><input type="text" name="couponcode" placeholder="couponcode"/>  <input type="submit" name="coupon" value=" Apply Coupon"></h2> 
       
      <div class="pricefooter">
         <div class="button">
          <button class="button" id="submit" name="submit">Make Payment</button>   
        </div>
      </div>
  </div>
  </form>
</body>
</html>