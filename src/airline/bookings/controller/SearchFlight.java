package airline.bookings.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import airline.bookings.dao.BookingDAO;

@WebServlet("/FlightSearchDate")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	String dpt_code = null;
	String arr_code =null;
	String date = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dpt_code = request.getParameter("");
		arr_code = request.getParameter("");
		date = request.getParameter("date");
		
		String leg_value = null;
		String leg[] = request.getParameterValues("leg");
		
		if(leg.length > 1) {
			leg_value = "both";
		}
		
		else if(leg[0].equals("0")) {
			leg_value = "zero";
		}
		else if(leg[0].equals("1")) {
			leg_value = "one";
		}
		
		BookingDAO b = new BookingDAO();
		
		LinkedHashMap<String, ArrayList<ArrayList<String>>> rs;
		
		try {
			rs = b.dateFlightSearch(dpt_code, arr_code, leg_value, date);
			
			if (!rs.isEmpty()) {
				
				Iterator<Entry<String, ArrayList<ArrayList<String>>>> it = rs.entrySet().iterator();
				
				Entry<String, ArrayList<ArrayList<String>>> entry = it.next();
				
				entry.getValue();
				
				try{
					if(entry.getValue().size() != 0) {
						request.setAttribute("Result", rs);
					}
					else {
						request.setAttribute("Result", "Invalid");
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("SearchResults.jsp");
				rd.forward(request, response);
			}
			
			else {
				request.setAttribute("Result", "Invalid");
				RequestDispatcher rd = request.getRequestDispatcher("SearchResults.jsp");
				rd.forward(request, response);
			}
		}
		catch(ParseException  p) {
			p.printStackTrace();
		}
	}
}
	
