<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search Flight</title>

</head>

<body>

<form method="post" action="/search">

<table>

<tr>

<td>Date:</td>

<td><input type="text" name="date" size="10" /></td>

<td>Time:</td>

<td><input type="text" name="time" size="10" /></td>

<td>Flight Type:</td>

<td><select name="flightcategories">

<option value="-1">-Select Category-</option>

<option value="economy">Economy</option>

<option value="business">Business</option>

</select></td>

<td>Seat Selection:</td>

<td><select name="bookcategories">

<option value="-2">-Select Seat-</option>

<option value="winright">Window(Left)</option>

<option value="winleft">Window(Right)</option>

<option value="passage">Passage</option>


</select></td>

<td><input type="submit" value="Search flight" /></td>

</tr>

</table>

</form>

</body>

</html>