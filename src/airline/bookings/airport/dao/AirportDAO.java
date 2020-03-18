package airline.bookings.airport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import airline.bookings.airport.bean.AirportBean;

public class AirportDAO {
	
	public int registerAirport(AirportBean airport) throws ClassNotFoundException{
		
		String sql = "INSERT INTO airportdetails" +
				"(name, city, province, aiport_code, iata) VALUES " +
				"(?,?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useSSL=false", "root", "");
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, airport.getAirportName());
			ps.setString(2, airport.getCity());
			ps.setString(3, airport.getProvince());
			ps.setString(4, airport.getCode());
			ps.setString(5, airport.getIata());
			
			System.out.println(ps);
			
			//Execute Query 
			result = ps.executeUpdate();
			
		}catch (SQLException e) {
			printSQLException(e);
		}
		return result;
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
