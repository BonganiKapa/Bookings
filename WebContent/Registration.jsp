<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Registration</title>
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
<jsp:include page="Home.jsp" />
<div class="nav-wrapper">
            <nav id="site-navigation" class="container-fluid navbar navbar-inverse" data-spy="affix" data-offset-top="160" style="margin:auto;">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#top" style="font-size: 30px;"><b>Flight Search</b></a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href = "Home.jsp">Home</a>
                    <li><a href = "review.jsp">Reviews</a>
                    <li class="active"><a href="#top">Registration Page</a></li>
                    <li><a href="Login.jsp">Login</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                </ul>
            </nav>
        </div>
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