<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body> 
<jsp:include page="Home.jsp" /> 
<h1>Edit Form</h1>  
<form action="<%= request.getContextPath() %>/EditDetails" method="post">>  
<input type="hidden" name="id" value=""/>  
<table>  
<tr><td>Name:</td><td>  
<input type="text" name="name" value=""/></td></tr>
<tr><td>Surname:</td><td>  
<input type="text" name="lastName" value=""/></td></tr>
<tr><td>Cell Phone:</td><td>  
<input type="text" name="cell" value=""/></td></tr>
<tr><td>Phone:</td><td>  
<input type="text" name="phone" value=""/></td></tr>
<tr><td>Email:</td><td>  
<input type="email" name="email" value=""/></td></tr>
<tr><td>Address:</td><td>  
<input type="text" name="address" value=""/></td></tr>  
<tr><td>Password:</td><td>  
<input type="password" name="password" value=""/></td></tr>
<tr><td>Repeat Password:</td><td>  
<input type="password" name="repassword" value=""/></td></tr>  
<!-- <tr><td>Sex:</td><td> -->  
<!-- <input type="radio" name="sex" value="male"/>Male -->  
<!-- <input type="radio" name="sex" value="female"/>Female </td></tr> -->  
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  