package airline.bookings.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

public class BookingDAO {


	Connection con;
	PreparedStatement ps;
	Statement s, st1, st2;
	
	public BookingDAO(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebooking?useTimezone=true&serverTimezone=UTC", "root", "");
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	public ResultSet searchSeat(String fNum, String date) {
	String sql = "SELECT available_seats, flight_number, date FROM flight_instance WHERE flight_number = '" 
				 + fNum + "' AND date = '" + date + "';";
	
	ResultSet rs = null;
	try {
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
				
	}
	catch(SQLException e){
		e.printStackTrace();
		
	}
	return rs;
	}
	
	
	public LinkedHashMap<String, ArrayList<ArrayList<String>>> dateFlightSearch(String dpt_code, String arr_code, String leg, String date) throws ParseException{
		
		ResultSet rs = null;
		
		String sql;
		
		LinkedHashMap<String, ArrayList<ArrayList<String>>> res = new LinkedHashMap<String, ArrayList<ArrayList<String>>>();
		ArrayList<ArrayList<String>> Rows = new ArrayList<ArrayList<String>>();
		
		ResultSetMetaData rsmd;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.DATE, 1);
		System.out.println(Calendar.DATE);
		String newDate = sdf.format(cal.getTime());
		
		try {
			ResultSet results = null;
			
			s = con.createStatement();
			if(leg.equals("both") || leg.equals("zero")) {
				sql = "SELECT DISTINCT f.flight_number, date, f.departure_airport_code, i.departure_time, f.arrival_airport_code, i.arrival_time, f.airline, f.weekdays " 
												+ "FROM flight f,flight_instance i "  
												+ "WHERE f.flight_number = i.flight_number AND f.departure_airport_code='"  
												+ dpt_code 
												+ "' AND f.arrival_airport_code = '" 
												+ arr_code + "' AND i.date = '" + date + "'";
				results = s.executeQuery(sql);
				rsmd = results.getMetaData();
				
				if(results.first()) {
					results.previous();
					while(results.next()) {
						ArrayList<String> row = new ArrayList<String>();
						for(int i = 1; i <= rsmd.getColumnCount(); i++) {
							row.add(results.getString(i));
						}
						Rows.add(row);
					}
					res.put("Direct", Rows);
				}
			}
			if(leg.equals("one") || leg.equals("both")) {
				sql = "SELECT DISTINCT f.arrival_airport_code, arrival_time FROM flight f, flight_instance i "
						+ "WHERE f.flight_number = i.flight_number AND f.departure_airport_code = '"
						+ dpt_code
						+ "' AND f.arrival_airport_code IN "
						+ "(SELECT Departure_airport_code from flight f, flight_instance i "
						+ "WHERE f.flight_number = i.flight_number AND Arrival_airport_code = '"
						+ arr_code
						+ "' "
						+ "AND (i.date='"
						+ date
						+ "' OR i.date='"
						+ newDate
						+ "'))"
						+ "AND (i.date='"
						+ date + "' OR i.date='" + date + "');";
				
				System.out.println("1 " + sql);
				
				rs = s.executeQuery(sql);
				
				while(rs.next()) {
					ResultSet rs1, rs2;
					Statement s1, s2;
					
					s1 = con.createStatement();
					s2 = con.createStatement();
					
					sql = "SELECT DISTINCT f.flight_number, date, departure_airport_code, departure_time, arrival_airport_code, arrival_time, f.airline, f.weekdays FROM flight f, flight_instance i "
							+ " WHERE f.flight_number = i.flight_number AND departure_airport_code = '"
							+ dpt_code
							+ "' AND arrival_airport_code = '"
							+ rs.getString(1) + "' AND (date='" + date + "');";
					
					System.out.println("2 " + sql);
					rs1 = s1.executeQuery(sql);
					
					sql = "SELECT DISTINCT f.flight_number, date, f.departure_airport_code, i.departure_time, f.arrival_airport_code, i.arrival_time, f.airline, f.weekdays"
							+ "	FROM flight f, flight_instance i"
							+ "	WHERE f.flight_number = i.flight_number AND f.departure_airport_code = '"
							+ rs.getString(1)
							+ "' AND f.arrival_airport_code = '"
							+ arr_code
							+ "' "
							+ "AND ((i.date = '"
							+ date
							+ "' AND TIME_TO_SEC(i.departure_time) > TIME_TO_SEC('"
							+ rs.getString(2)
							+ "')+3600) OR i.date = '"
							+ newDate + "');";
					
					System.out.println("3 " + sql);
					rs2 = s2.executeQuery(sql);
					rsmd = rs1.getMetaData();
					
					if(rs1.first()) {
						rs1.previous();
						while(rs1.next()) {
							ArrayList<String> row = new ArrayList<String>();
							for(int i = 1; i <= rsmd.getColumnCount(); i++) {
								row.add(rs1.getString(i));
							}
							Rows.add(row);
						}
						rsmd = rs2.getMetaData();
						
						while(rs2.next()) {
							ArrayList<String> row  = new ArrayList<String>();
							for(int i = 1; i <= rsmd.getColumnCount(); i++) {
								row.add(rs2.getString(i));
							}
							Rows.add(row);
						}
						res.put(rs.getString(1), Rows);
					}
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	public LinkedHashMap<String, List<ResultSet>> flightSearch(String dpt_code, String arr_code, String leg){
		
		ResultSet rs = null;
		ResultSet result = null;
		
		String sql;
		
		LinkedHashMap<String, List<ResultSet>> res = new LinkedHashMap<String, List<ResultSet>>();
		
		try {
			
			ResultSet rset = null;
			s = con.createStatement();
			st1 = con.createStatement();
			st2 = con.createStatement();
			if(leg.equals("01") || leg.equals("zero") || leg.equals("all") || leg.equals("02")) {
				
				List<ResultSet> Rows = new ArrayList<ResultSet>();
				
				sql = "SELECT flight_number, Departure_airport_code, Scheduled_departure_time, Arrival_airport_code, Scheduled_arrival_time, weekdays FROM flight f WHERE (f.departure_airport_code)='"
						+ dpt_code
						+ "' AND (f.arrival_airport_code)='"
						+ arr_code + "';";
				
				rset = st1.executeQuery(sql);
				System.out.println(sql);
				
				if(rset.next()) {
					rset.previous();
					while(rset.next()) {
						Rows.add(rset);
					}
					res.put("Direct", Rows);
				}
			}
			if(leg.equals("one") || leg.equals("01") || leg.equals("12") || leg.equals("all")) {
				
				List<ResultSet> Rows = new ArrayList<ResultSet>();
				
				sql = "SELECT DISTINCT f1.Flight_number, f2.Flight_number , f1.Departure_airport_code ,f1.Arrival_airport_code, f2.Arrival_airport_code , f1.weekdays, f2.weekdays "
						+ "FROM flight AS f1 JOIN flight AS f2 "
						+ "ON (f1.Arrival_airport_code=f2.Departure_airport_code) AND timediff(f2.Scheduled_Departure_time,f1.Scheduled_arrival_time)>'01:00:00'"
						+ "WHERE f1.Departure_airport_code='"
						+ dpt_code
						+ "' AND f2.Arrival_airport_code='" + arr_code + "' AND INSTR(TRIM(f2.Weekdays),f1.Weekdays)>-1;";
				rs = s.executeQuery(sql);
				
				if(rs.next()) {
					rs.previous();
					while(rs.next()) {
						Rows.add(rs);
					}
					res.put("Single", Rows);
				}
			}
			
			if(leg.equals("two") || leg.equals("12") || leg.equals("t02") || leg.equals("all")) {
				
				List<ResultSet> Rows = new ArrayList<ResultSet>();
				
				sql = "SELECT DISTINCT f1.Flight_number , f2.Flight_number , f3.Flight_number, f1.Departure_airport_code, f1.Arrival_airport_code, f2.Arrival_airport_code, f3.Arrival_airport_code, f1.weekdays, f2.weekdays, f3.weekdays  "
						+ "FROM flight AS f1 JOOIN flight AS f2 JOIN flight AS f3 "
						+ "ON (f1.Arrival_airport_code=f2.Departure_airport_code AND f2.Arrival_airport_code=f3.Departure_airport_code) "
						+ "AND timediff(f2.Scheduled_Departure_time,f1.Scheduled_arrival_time)>'01:00:00' and timediff(f3.Scheduled_Departure_time, f2.Scheduled_arrival_time)>'01:00:00' "
						+ "WHERE f1.Departure_airport_code='"
						+ dpt_code
						+ "' AND f3.Arrival_airport_code='"
						+ arr_code
						+ "' AND INSTR(TRIM(f2.Weekdays),f1.Weekdays)>-1 AND INSTR(TRIM(f3.Weekdays), f2.Weekdays)>-1;";
				
				rset = st2.executeQuery(sql);
				System.out.println(sql);
				
				if(rset.first()) {
					rset.previous();
					while(rset.next()) {
						Rows.add(rset);
					}
					res.put("Two", Rows);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	public ResultSet priceInfo(String flightNum) {
		
		ResultSet rs = null;
		
		try {
			s = con.createStatement();
			
			String sql = "SELECT flight_number, Fare_code, amount, restrictions " 
						+ "FROM prices " 
						+ "WHERE flight_number = '"
						+ flightNum + "';";
			rs = s.executeQuery(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public ResultSet flightList(String name) {
		
		ResultSet rs = null;
		
		try {
			s = con.createStatement();
			
			String sql = "SELECT flight_number, customer_name, seat_number, date"
						+ "FROM bookings" 
						+ "WHERE customer_name = '"
						+ name + "';";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public ResultSet passengerInfo(String flightNum, String date) {
		
		ResultSet rs = null;
		
		try {
			s = con.createStatement();
			
			String sql = "SELECT flight_number,customer_name,seat_number,date" 
						+ "FROM bookings" 
						+ "WHERE flight_number = '"
						+ flightNum + "' AND date ='" + date + "';";
			rs = s.executeQuery(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
