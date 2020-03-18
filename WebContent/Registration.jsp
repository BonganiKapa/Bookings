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
  <h1 align = center><font color =#0FC263><strong><u>REGISTRATION FORM</u></strong></font></h1> 
  <form action="<%= request.getContextPath() %>/Registration" method="post">
   <table style="with: 85%" borderColor =#5EC20F cellSpacing =15 align = center border =10>
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" placeholder = "NAME" required = "required" /></td>
    </tr>
    <tr>
     <td>Surname</td>
     <td><input type="text" name="surname" placeholder = "SURNAME" required = "required"/></td>
    </tr>
    <tr>
     <td>ID Number</td>
     <td><input type="text" name="idNum" placeholder = "ID NUMBER" required = "required" /></td>
    </tr>
    <tr>
     <td>Gender</td>
     <td><input type="text" name="gender" placeholder = "GENDER" required = "required"/></td>
    </tr>
    <tr>
     <td>Cell-Phone</td>
     <td><input type="text" name="cell" placeholder = "CELL PHONE" required = "required"/></td>
    </tr>
    <tr>
     <td>Phone</td>
     <td><input type="text" name="phone" placeholder = "PHONE" required = "required"/></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" placeholder = "EMAIL" required = "required"/></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" placeholder = "ADDRESS" required = "required"/></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" placeholder = "PASSWORD" required = "required"/></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="repassword" placeholder = "REPEAT PASSWORD" required = "required"/></td>
    </tr>
   </table>
   <td borderColor = #0DA6EE >
   <p align = center><input id = button1 type="submit" value="Submit" name = button1/></p>
   </td>
  </form>
 </div>
</body>
</html>