package airline.bookings.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatSearchDAO {

	public ResultSet searchSeat(String fNum, String date) {
	String sql = "SELECT available_seats, flight_number, date FROM flight_instance WHERE flight_number = '" 
				 + fNum + "' AND date = '" + date + "';";
	
	ResultSet result = null;
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useTimezone=true&serverTimezone=UTC", "root", "");
			
			PreparedStatement ps = con.prepareStatement(sql)){
				
				result = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return result;
	}
}
