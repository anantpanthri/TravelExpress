<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/road.css"> 
<script language="javascript"> 

function access(s,y){ 
	
	
	document.getElementById('sn').value= s;
	document.getElementById('ppm').value= y;
  
} 

</script> 
</head>
<form name="form" method="post" action="hotel">
<input type="hidden" id="sn" name="service_name" value="" />
<input type="hidden" id="ppm" name="price_per_mile" value="" />
<c:forEach items="${databaseBusList}" var="dal">
<div id="pricing-table" >
    <div class="plan">
        <h3><c:out value="${dal.service_name}" /><span><c:out value="${dal.price_per_mile}" />$</span></h3>
        <button class="signup" id="submit" name="submit" onclick="javascript:access('${dal.service_name}','${dal.price_per_mile}');" >GoRoad</button>         
        <ul>
            <li> </li>
            			
        </ul> 
    </div>
    
</div>
</c:forEach>

  
  
</form>
</html>