<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.*"
    import="java.io.*"
    %>


<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Advanced Flight Search</title>
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
                    <a class="navbar-brand" href="#top" style="font-size: 30px;"><b>Flight Search</b></a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href = "booking.jsp">Bookings</a>
                    <li><a href = "review.jsp">Reviews</a>
                    <li class="active"><a href="#top">Serach Page</a></li>
                    <li><a href="updateanddelete.jsp">Update&sol;Delete</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                </ul>
            </nav>
        </div>

        <section id="section1" class="container-fluid">
            <legend><h1 style="text-align: center;">Advanced search</h1></legend>

            <form action="FlightSearch" method="post">
                    <div class="form-group">
                        <label for="searchType">Search by: <input type="hidden" class="form-control add" required></label>
                            <select name="searchType">
                                <option value = "date">Date & Time:</option>
                                <option value = "airport">Airport:</option>
                                <option value = "flightName">Flight Name:</option>
                            </select>
                        <input type = "submit" value = "Search">
                    </div>
                    <div class="form-group">
                    <label for="query">Search<input type="text" class="form-control add" name="search" placeholder="search" /></label>
                    </div>
                </form>


</body>
</html>