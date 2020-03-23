package airline.bookings.airport.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airline.bookings.airport.bean.AirportBean;
import airline.bookings.airport.dao.AirportDAO;


@WebServlet("/Airport")
public class Airport extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private AirportDAO airportDao;
	
	public void init() {
		airportDao = new AirportDAO();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String code = request.getParameter("code");
		String iata = request.getParameter("iata");
		
		AirportBean airport = new AirportBean();
		airport.setAirportName(name);
		airport.setCity(city);
		airport.setProvince(province);
		airport.setCode(code);
		airport.setIata(iata);
		
		try {
			airportDao.registerAirport(airport);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
