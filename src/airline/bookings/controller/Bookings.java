package airline.bookings.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Bookings")
public class Bookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/HTML");
		PrintWriter prnt = response.getWriter();
		String dprtur = request.getParameter("departure");
		String[] dpt = dprtur.split("-");
		String dptr = dpt[1];
		request.setAttribute("from", dptr);
		String arrvl = request.getParameter("arrival");
		String[] dest = arrvl.split("-");
		String destnt = dest[1];
		request.setAttribute("to", destnt);
		
		String dt = request.getParameter("fromAirport");
		
		
		try {
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
			Date date = simple.parse(dt);
			DateFormat dFormat = new SimpleDateFormat("EEEE");
			
			String dow = dFormat.format(date);
			
			java.sql.Date d = new java.sql.Date(date.getTime());
			request.setAttribute("date", d);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useTimezone=true&serverTimezone=UTC", "root", "");
			
			if(dow.equals("Sunday") || dow.equals("Tuesday") || dow.equals("Thursday") || dow.equals("Fridays")) {
				if((dptr.equals("") && destnt.equals("")) || (dptr.equals("") && destnt.equals("")) || (dptr.equals("") && destnt.equals(""))) {
					String noFlight = "NO FLIGHT AVAILABLE ON ";
					
					request.setAttribute("noFlight", noFlight);
					
				}
				
			}
		}
		catch(Exception e) {
			
		}
	}

}
