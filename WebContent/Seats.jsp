<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Available Seats</title>
        <style>
            .affix {top: 0; width: 100%;}
            .affix + .container-fluid {padding-top: 50px;}
            .nav-wrapper {min-height: 50px;}
            #section1 {padding-top: 50px; min-height: 550px; background-color: #EFEFEF; border-bottom: 1px solid #D6D6D6;}
            #section2 {padding-top: 50px; min-height: 1000px; background-color: #EFEFEF; border-bottom: 1px solid #D6D6D6;}
            #section3 {padding-top: 20px; min-height: 400px; background-color: #EFEFEF; border-bottom: 1px solid #D6D6D6;}
            .add {width:600px;}
        </style>
        <script>
            //Smooth Scrolling
            $.fn.scrollBottom = function() { 
                return $(document).height() - this.scrollTop() - this.height(); 
            };
            window.onscroll = function() {myFunction()};
            $(document).ready(function(){
                $("a").on('click', function(event) {
                    if (this.hash !== "") {
                        event.preventDefault();
                        var hash = this.hash;
                        $('html, body').animate({
                            scrollTop: $(hash).offset().top
                        }, 400, function(){
                            window.location.hash = hash;
                        });
                    }
                });
            });
        </script>
    </head>
<body>
<div align="center">
	<div class="menuHead col-md-offset-3">Check Available Seat(s)</div>

	<div class="subBody">
		<form action="<%= request.getContextPath() %>/SeatSearch"
			method="post">
			<div class="form-group">
				<label for="inputFlighCode"
					class="col-sm-2 col-md-offset-2 control-label">Enter Flight
					Number</label>
				<div class="col-sm-3">
					<input type="text" required class="form-control" name="inputFlightCode" id="inputFlightCode"
						placeholder="E.g. E1215">
				</div>
			</div>
			<div class="form-group">
				<label for="inputFlightDate"
					class="col-sm-2 col-md-offset-2 control-label">Enter Flight
					Date</label>
				<div class="col-sm-3">
					<input type="date" required class="form-control" name="inputFlightDate" id="inputFlightDate"
						placeholder="Enter flight Date here...">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-10">
					<button type="submit" class="btn btn-primary">Search</button>
				</div>
			</div>
		</form>

		<div class="col-md-4 col-md-offset-2">
			<%
				if (request.getAttribute("Result") != "Invalid"
						&& request.getAttribute("Result") != null) {
					ResultSet rs = (ResultSet) request.getAttribute("Result");
			%>

			<h4>Available seat on given Flight</h4>
			<table class="table table-hover">

				<tr>
					<th>Flight Number</th>
					<th>No.Of Available Seat</th>
					<th>Date</th>
				</tr>
				<%
					while (rs.next()) {
				%>
				<tr>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(3)%></td>
				</tr>

				<%
					}
				%>
			</table>
			<%
				} else if (request.getAttribute("Result") == "Invalid") {
			%>
			<h4>Sorry no result found for your request..!!</h4>
			<%
				}
			%>

		</div>

	</div>
	</div>
</body>
</html>