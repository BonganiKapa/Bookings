package airline.bookings.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FlightSearch")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		List flightList = new ArrayList();
		
		String searchType = "";
		String search = "";
		
		String sqlStr = null;
		
		searchType = request.getParameter("searchType");
		search = request.getParameter("search");
		
		if(searchType.equals("date")) {
			sqlStr = "SELECT * FROM flightdetails " +
					"WHERE departure_time '" + search + "'; " ;
		}
		else if(searchType.equals("airport")) {
			sqlStr = "SELECT airportdeatils.name, flightdetails.flight_name " + 
					"FROM airportdetails a JOIN prices p ON a.airport_id = p.id_price " +  
					"JOIN flightdetails f ON p.id_price = f.flight_id WHERE '" + search + "';";
		}
		else if(searchType.equals("flightName")) {
			sqlStr = "SELECT * FROM flightdetails " +
					"WHERE flight_name LIKE '%" + search + "'% " + ";";
		}
		else {
			System.out.println("NO OPTION SELECTED FROM THE DROP DOWN OPTIONS!!!");
			System.out.println("PLEASE SELECT OPTIONS FROM THE DROP DOWN TAB AND CARRY ON WITH THE ADVANCED SEARCH...");
		}
		System.out.println(sqlStr); 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useTimezone=true&serverTimezone=UTC", "root", "");
			
			try {
				PreparedStatement ps = con.prepareStatement(sqlStr);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					List flight = new ArrayList();
					
					flight.add(rs.getString(1));
					flight.add(rs.getString(2));
					flight.add(rs.getString(4));
					flight.add(rs.getString(4));
					flight.add(rs.getString(5));
					
					flightList.add(flight);
					
				}
			}
			catch(SQLException e) {
				System.out.println();
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		request.setAttribute("flightLight", flightList);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchResults.jsp");
		rd.forward(request, response);
	}
}
	
