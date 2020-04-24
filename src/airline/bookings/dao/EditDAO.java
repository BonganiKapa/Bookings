package airline.bookings.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import airline.bookings.bean.EditBean;

public class EditDAO {

	public int updateClient(EditBean edit) throws ClassNotFoundException{
		
		String sql = "UPDATE personaldetails set name = ?, surname = ?, phone = ?, cell = ?, email = ?, address = ?, password=?, repassword = ? WHERE id_number = ?;";
		
		int results = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useTimezone=true&serverTimezone=UTC", "root", "");
				//Statement Using a connection OBJECT
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, edit.getName());
			ps.setString(2, edit.getLastName());
			ps.setString(3, edit.getPhone());
			ps.setString(4, edit.getCell());
			ps.setString(5, edit.getEmail());
			ps.setString(6, edit.getAddres());
			ps.setString(7, edit.getPhone());
			ps.setString(8, edit.getPassword());
			ps.setString(9, edit.getRepassowrd());
			
			int i = ps.executeUpdate();
			
			if(i != 0) {
				System.out.println("<br> Your Personal Details Where Successfully Updated");
			}
			
			else {
				System.out.println("Failed to Update Your Personal Details. Please Try Again.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
