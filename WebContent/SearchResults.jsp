<%@page import="airline.bookings.controller.SearchFlight"%>
<%@page import="java.util.*" %> 

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Flight Search Results</title>
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
        <%
        // Show username on page
        %>
       
        <div class="nav-wrapper">
            <nav id="site-navigation" class="container-fluid navbar navbar-inverse" data-spy="affix" data-offset-top="160" style="margin:auto;">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#top" style="font-size: 30px;"><b>Flights Results</b></a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href = "booking.jsp">Bookings</a>
                    <li><a href = "review.jsp">Reviews</a>
                    <li class="active"><a href="#top">Search Results Page</a></li>
                    <li><a href="updateanddelete.jsp">Update&sol;Delete</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                </ul>
            </nav>
        </div>
        <div class = "section1">
        <table width = "700px" align="center" style = "boder:1px solid #000000">
        <tr>
        	<td colspan = 4 align = "center" 
        		style = "background-color:teal">
        		<b>Rusults</b></td>
        </tr>
        <tr style = "background-color: lightgrey;">
        	<td><b>Airport Name:</b></td>
        	<td><b>Flight Time:</b></td>
        	<td><b>Destination:</b></td>
        	<td><b>Arrival Time:</b></td>
        	<td><b>Duration Time:</b></td>
        </tr>
        <%
			int count = 0;
        	String color = "#F9EBB3";
        if(request.getAttribute("flightList") != null){
        	ArrayList flight = (ArrayList)request.getAttribute("flightList");
        	Iterator ite = flight.iterator();
        	
        	while(ite.hasNext()){
        		if ((count % 2) == 0){
        			color = "#effee";
        		}
        		else{
        			color = "#F9EBB3";
        		}
        		count++;
        		
        		ArrayList flightList = (ArrayList)ite.next();
        		%>
        		<h2 align="center">Result</h2>

        <tr>

           <tr>

        <td><%=flightList.get(1) %></td>

        <td><%=flightList.get(2) %></td>

        <td><%=flightList.get(3) %></td>

        <td><%=flightList.get(4) %></td>

        <td><%=flightList.get(5) %></td>

        </tr>

        </tr>
       <%  		
        	}
        }
        %>
        
        <%
			if(count == 0){
				%>
				<tr>
				<td colspan = 8 align = "center"
				style= "background-color:eeffee"><b>NO RECORD</b></td>
				</tr>
				<% } 
				%>				
        </table>
        </div>
    </body>

</html>