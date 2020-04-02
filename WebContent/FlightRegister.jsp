<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Details</title>
</head>
<body>
<div align="center">
  <h1 align = center><font color =#0FC263><strong><u>INSERT FLIGHT DEATILS</u></strong></font></h1> 
  <form action="<%= request.getContextPath() %>/FlightRegister" method="post">
   <table style="with: 85%" borderColor =#5EC20F cellSpacing =15 align = center border =10>
    <tr>
     <td>Flight Name:</td>
     <td><input type="text" name="fname" placeholder = "Flight Name" required = "required" /></td>
    </tr>
    <tr>
     <td>Service Type:</td>
     <td><input type="text" name="fService" placeholder = "Service Type" required = "required"/></td>
    </tr>
    <tr>
     <td>Flight Number:</td>
     <td><input type="text" name="fNum" placeholder = "Flight Number" required = "required" /></td>
    </tr>
    <tr>
     <td>Arrival Time:</td>
     <td><input type="text" name="arrTime" placeholder = "Arrival Time" required = "required"/></td>
    </tr>
    <tr>
     <td>Departure Time:</td>
     <td><input type="text" name="dprtTime" placeholder = "Departure Time" required = "required"/></td>
    </tr>
   </table>
   <td borderColor = #0DA6EE >
   <p align = center><input id = button1 type="submit" value="Submit" name = button1/></p>
   </td>
  </form>
 </div>
</body>
</html>