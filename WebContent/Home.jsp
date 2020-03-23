<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="Assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="Assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="Assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   
</head>
<body>

    <div class="nav-wrapper">
            <nav id="site-navigation" class="container-fluid navbar navbar-inverse" data-spy="affix" data-offset-top="160" style="margin:auto;">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#top" style="font-size: 30px;">FLIGHTS<b></b></a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href = "FlightSearch.jsp">Bookings</a>
                    <li><a href = "Login.jsp">Login</a>
                    <li><a href = "Register.jsp">Register</a>
                    <li><a href = "review.jsp">Reviews</a>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                </ul>
            </nav>
        </div>
        <div class = "section1">
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> Welcome Guest &nbsp; </div>
        </nav>   
        
       
    <!--/.SLIDESHOW END-->
        	<!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <section id="home" class="text-center">
         
                <div id="carousel-example" class="carousel slide" data-ride="carousel">

                    <div class="carousel-inner">
                        <div class="item active">

                            <img src="assets/img/aa.jpg" alt="" />
                            <div class="carousel-caption" >
                                <h4 class="back-light"></h4>
                            </div>
                        </div>
                        <div class="item">
                            <img src="Assets/images/aa1.jpg" alt="" />
                            <div class="carousel-caption ">
                                <h4 class="back-light"></h4>
                            </div>
                        </div>
                        <div class="item">
                            <img src="Assets/images/sw1.jpg" alt="" />
                            <div class="carousel-caption ">
                                <h4 class="back-light"></h4>
                            </div>
                        </div>
                    </div>

                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example" data-slide-to="1"></li>
                        <li data-target="#carousel-example" data-slide-to="2"></li>
                    </ol>
                </div>
           
       </section>
               
            </div>
            
        </nav>  
        <div id="page-wrapper" >
            <div id="page-inner">
                
                 <!-- /. ROW  -->
                 <hr />
                 
                 
                 <form action="/AirlineReservationSystem/ActionServlet" method="post" onsubmit="return checkMe();">
                 <input type="hidden" name="type" value="flightdetails">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Find Flights between two airports</h2>  
                                                                      
                        <h4>Enter Departure Airport Code :</h4> &nbsp;
                        <input type="text" name="dac" id="dac" />
                        <h4>Enter Arrival Airport Code :</h4> &nbsp;
                        <input type="text" name="aac" id="aac" />
                        
                        <br />
                        &nbsp;
                        <br />
                        
                        <input type="checkbox" name="stops" id="ch1" value="0" checked="checked">Direct Flights (Non-Stop)<br>
                        
						<input type="checkbox" name="stops" id="ch2" value="1">Flights with one stop
						<br> 
						<input type="checkbox" name="stops" id="ch3" value="2">Flights with two stops 
						
						<br />
						<br />                       
                        <input type="submit" name="submit"  value="Show Flights" class="btn btn-success ">
                      	
                      	
                      	
                    </div>
                </div>
                <hr />
                </form>
                
                <br />
                
                



                  <div class="row">                     
                      
                              <div class="col-md-6 col-sm-12 col-xs-12">                     
                    <div class="panel panel-default">
                 
                        <div class="panel-body">
                            <a href="AvailSeats.jsp" class="btn btn-danger square-btn-adjust">Get Available Seats Information</a>
                <br />
                <br />
                
                <a href="GetFareInfo.jsp" class="btn btn-danger square-btn-adjust">Get Fare Information</a>
                <br />
                <br />
                <a href="Passenger.jsp" class="btn btn-danger square-btn-adjust">Get Passenger List for a flight</a>
                <br />
                <br />
             
                <a href="viewFlightInstances.jsp" class="btn btn-danger square-btn-adjust">Get List of flights for a passenger</a>
              
                        </div>
                    </div>            
                </div> 
                      <div class="col-md-6 col-sm-12 col-xs-12">                     
                    <div class="panel panel-default">
                        
                        <div class="panel-body">
                        
                        <h2>Special Deals</h2>  
                                                                      
                        <h4>Fly anywhere in South Africa starting from R499</h4>
                        <h4>Earn 1000 Kilometers points for each flight with Super Airlines</h4>
                        </div>
                    </div>            
                </div> 
                
          
       
    
             <!-- /. PAGE INNER  -->
            
         <!-- /. PAGE WRAPPER  -->
        </div>
        </div>
        </div>
        </div>
        
        <script type="text/javascript" src="Assets/js/canvasjs.min.js"></script>
        
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="Assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="Assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="Assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="Assets/js/custom.js"></script>
    
   
</body>
</html>