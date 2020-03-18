<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Login</title>
</head>
<body>
<div align="center" background-color = #94BBCD >
  <h1 align = center><font color =#0FC263><strong><u>LOGIN</u></strong></font></h1>
  <form action="<%=request.getContextPath()%>/Login" method="post">
   <table style="with: 100%" borderColor =#5EC20F cellSpacing =15 align = center border =10">
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Login" />
  </form>
 </div>
</body>
</html>