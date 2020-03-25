package airline.bookings.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchFlight")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		
		List flightList = new ArrayList();
		
		String searchType = "";
		String search = "";
		
		String sqlStr = "";
		
		searchType = request.getParameter("searchType");
		search = request.getParameter("search");
		
		if(searchType.equals("date")) {
			sqlStr = "SELECT * FROM flightdetails " +
					"WHERE departure_time LIKE '%" + search + "'% " + ";";
		}
	
	}

}
