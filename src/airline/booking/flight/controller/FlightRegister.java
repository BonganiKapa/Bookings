package airline.booking.flight.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airline.booking.flight.dao.FlightDAO;
import airline.bookings.flight.bean.FlightBean;

@WebServlet("/FlightRegister")
public class FlightRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//private static final long serialVersionUID = 1L;
	
	private FlightDAO flightDao;
	
	public void init() {
		flightDao = new FlightDAO();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("fname");
		String fservice = request.getParameter("fService");
		String fNum = request.getParameter("fNum");
		String timeArr = request.getParameter("arrTime");
		String timeDprt = request.getParameter("dprtTime");
		
		//CREATING NEW FLIGHT INFORMATION
		FlightBean flight = new FlightBean();
		
		flight.setFlightName(name);
		flight.setFlightService(fservice);
		flight.setFlightNum(fNum);
		flight.setDepartTime(timeDprt);
		flight.setArrivalTime(timeArr);
		
		try {
			flightDao.registerFlight(flight);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		response.sendRedirect("Airport.jsp");
	}
}
