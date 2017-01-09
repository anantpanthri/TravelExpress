<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>

function add_fields() {    
document.getElementById("myTable").insertRow(0).innerHTML = '<tr><td><textarea name="dependentname" placeholder="dependent name" th:field="${questionAnswerSet.question}" id="dn" style = "resize: none; width:100%;"></textarea></td><td><textarea name="dependentrelationship" placeholder="relationship" th:field="${questionAnswerSet.question}" id="dr" style = "resize: none; width:100%;"></textarea></td><td><textarea name="dependentsex" placeholder="sex" th:field="${questionAnswerSet.question}" id="ds" style = "resize: none; width:100%;"></textarea></td><td><textarea name="dependentage" placeholder ="age" th: field="${questionAnswerSet.answer}" id="da" style="resize:none;width: 100%;"></textarea></td ></tr>';

}
</script>
<link rel="stylesheet" href="css/dependent.css">
</head>
<form name="form" method="post" action="Confirmation">
<div class="set-form" align="center">
		<h1>Enter Dependent Details</h1>
  <table id="myTable" class="tbl-header" align="center">
    <tr>
      <td>
        <textarea name="dependentname" placeholder="dependent name" th:field="" id="dn" style="resize: none; width: 100%;"></textarea>
      </td>
      <td>
        <textarea name="dependentrelationship" placeholder="relationship" th:field="" id="dr" style="resize: none; width: 100%;"></textarea>
      </td>
      <td>
        <textarea name="dependentsex" placeholder="sex" th:field="" id="ds" style="resize: none; width: 100%;"></textarea>
      </td>
      <td>
        <textarea name="dependentage" placeholder="age" th:field="" id="da" style="resize: none; width: 100%;"></textarea>
      </td>
    </tr>
  </table>
  <div class="set-form" >
    <input type="button" id="more_fields" onclick="add_fields();" value="Add More" class="btn btn-info" align="center" />
    <button class="submit" id="submit" name="done">Done</button>
</div>

 
</div>
</html>
