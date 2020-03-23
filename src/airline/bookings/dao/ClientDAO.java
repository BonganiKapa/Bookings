package airline.bookings.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import airline.bookings.bean.ClientBean;

public class ClientDAO {
	
	public int registerClient(ClientBean client) throws ClassNotFoundException{
		
		String sql = "INSERT INTO personaldetails " +
				"(name, surname, id_number, gender, phone, cell, email, address, password, repassword) VALUES " +
				"(?,?,?,?,?,?,?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useTimezone=true&serverTimezone=UTC", "root", "");
				//Statement Using a connection OBJECT
				PreparedStatement ps = con.prepareStatement(sql)){

			ps.setString(1, client.getName());
			ps.setString(2, client.getSurname());
			ps.setString(3, client.getIdNm());
			ps.setString(4, client.getGender());
			ps.setString(5, client.getPhone());
			ps.setString(6, client.getCell());
			ps.setString(7, client.getEmail());
			ps.setString(8, client.getAddress());
			ps.setString(9, client.getPassword());
			ps.setString(10, client.getRepasssword());
			
			System.out.println(ps);
			
			//Execute Query
			result = ps.executeUpdate();
		} catch (SQLException e) {
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
