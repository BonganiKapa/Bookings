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
        <title>Login</title>
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
<div class="nav-wrapper">
            <nav id="site-navigation" class="container-fluid navbar navbar-inverse" data-spy="affix" data-offset-top="160" style="margin:auto;">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#top" style="font-size: 30px;"><b>Flight Search</b></a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href = "Home.jsp">Home</a>
                    <li><a href = "review.jsp">Reviews</a>
                    <li><a href = "Registration.jsp">Register</a></li>
                    <li class="active"><a href="#top">Login Page</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                </ul>
            </nav>
        </div>
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