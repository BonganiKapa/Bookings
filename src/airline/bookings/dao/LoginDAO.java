package airline.bookings.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import airline.bookings.bean.LoginBean;

public class LoginDAO {
	
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException{
		
		String sql = "SELECT * FROM personaldetails WHERE email = ? AND password = ?;";
		
		boolean status = false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useTimezone=true&serverTimezone=UTC", "root", "");
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, loginBean.getEmail());
			ps.setString(2, loginBean.getPassword());
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
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
