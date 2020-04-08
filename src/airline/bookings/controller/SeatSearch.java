package airline.bookings.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airline.bookings.dao.BookingDAO;

@WebServlet("/SeatSearch")
public class SeatSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String fNum;
	String date;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		fNum = request.getParameter("inputFlightCode");
		date = request.getParameter("inputFlightDate");
		BookingDAO seat = new BookingDAO();
		ResultSet rs = seat.searchSeat(fNum, date);
		try {
			if(rs.next()) {
				rs.previous();
				request.setAttribute("results", rs);
			}
			else {
				request.setAttribute("results", "invalid");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("Seats.jsp");
		rd.forward(request, response);
	}
}
