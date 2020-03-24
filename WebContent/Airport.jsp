<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<div align="center">
  <h1 align = center><font color =#0FC263><strong><u>INSERT AIRPORT</u></strong></font></h1> 
  <form action="<%= request.getContextPath() %>/Airport" method="post">
   <table style="with: 85%" borderColor =#5EC20F cellSpacing =15 align = center border =10>
    <tr>
     <td>Airport Name:</td>
     <td><input type="text" name="name" placeholder = "AIRPORT NAME" required = "required" /></td>
    </tr>
    <tr>
     <td>Airport City:</td>
     <td><input type="text" name="city" placeholder = "AIRPORT CITY" required = "required"/></td>
    </tr>
    <tr>
     <td>Airport Province:</td>
     <td><input type="text" name="province" placeholder = "AIRPORT PROVINCE" required = "required" /></td>
    </tr>
    <tr>
     <td>Airport Code:</td>
     <td><input type="text" name="code" placeholder = "AIRPORT CODE" required = "required"/></td>
    </tr>
    <tr>
     <td>IATA:</td>
     <td><input type="text" name="iata" placeholder = "IATA"/></td>
    </tr>
   </table>
   <td borderColor = #0DA6EE >
   <p align = center><input id = button1 type="submit" value="Submit" name = button1/></p>
   </td>
  </form>
 </div>
</body>
</html>