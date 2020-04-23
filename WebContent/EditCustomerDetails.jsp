<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="edit" name="editClient" method="get" action="EditServlet">
        <p><em>Please edit any client details</em></p>
            Enter Street: <input type="text" name="street"  /> 
            <br><br> 
            Enter city: <input type="text" name="city"  /> 
            <br><br> 
            Enter Name: <input type="text" name="listingNum"  /> 
            <br><br> 
            Id NUmber: <input type="text" name="styleId"  /> 
            <br><br> 
            <input type="submit" value="Edit Details" name="editDetails" />
        </form>

</body>
</html>