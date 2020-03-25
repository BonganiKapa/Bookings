package airline.booking.flight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import airline.bookings.flight.bean.FlightBean;

public class FlightDAO {

	public int registerFlight(FlightBean flight) throws ClassNotFoundException{
		
		String sql = "INSETR INTO flightdetails " +
				"(flight_name, flight_service, flight_number, departure_time, arrival_time) VALUES " +
				"(?,?,?,?,?);";
		
		int results = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useTimezone=true&serverTimezone=UTC", "root", "");
				
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, flight.getFlightName());
			ps.setString(2, flight.getFlightService());
			ps.setString(3, flight.getFlightNum());
			ps.setString(4, flight.getDepartTime());
			ps.setString(5, flight.getArrivalTime());
			
			System.out.println(ps);
			
			results = ps.executeUpdate();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return results;
	}
	
	private void printSQLException(SQLException ex) {
		 for (Throwable e: ex) {
			 if (e instanceof SQLException) {
	            e.printStackTrace(System.err);
	            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	            System.err.println("Message: " + e.getMessage());
	            Throwable t = ex.getCause();
	            while (t != null) {
	                System.out.println("Cause: " + t);
	                t = t.getCause();
	            }
	         }
	       }
	 	}
}
