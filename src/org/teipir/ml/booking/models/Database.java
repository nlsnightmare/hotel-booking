package org.teipir.ml.booking.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Statement;


public class Database {

	private static Connection conn = null;

	public static boolean initialize() {
		// TODO Auto-generated method stub
	    try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    } catch (Exception ex) {
	    	System.out.println("Failed to find 'com.mysql.jdbc.Driver'");
	    	return false;
	    }
	    conn = null;
	    try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelbooking?" + "user=root&password=root&useSSL=false");
		} catch (SQLException e) {
			System.out.println("Failed to connect to database!");
			return false;
		}
	    return true;
	}

	public static String convertDateFormat(String date) {
		String dt;
		String[] parts = date.split("/");
		dt = parts[2] + "-" + parts[1] + "-" + parts[0];
		return dt;
	}
	public static boolean isRoomAvailable(int roomId,String checkin, String checkout) {
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) AS A FROM BOOKING WHERE " + 
							"room = " + roomId + " and (" + 
					        "STARTINGDATE > date '" + checkout +"' or " + 
					        "FINISHDATE < date '"+ checkin + "')";
		System.out.println(query);
		int amount = 0 , total = 1;
		try {
			stmt = conn.createStatement();

			if(stmt.execute(query))
			{
				rs = stmt.getResultSet();
				rs.next();
				amount = rs.getInt("A");
			}

			stmt = conn.createStatement();

			if(stmt.execute("SELECT COUNT(*) AS A FROM BOOKING WHERE ROOM="+ roomId))
			{
				rs = stmt.getResultSet();
				rs.next();
				total = rs.getInt("A");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return amount - total == 0;
	}

	public static Vector<HotelRoom> searchRoom(String query, String checkin, String checkout) {
	    java.sql.Statement stmt = null;
	    ResultSet rs = null;
		Vector<HotelRoom> res = new Vector<HotelRoom>();
	    try {
	        stmt = conn.createStatement();
	        if (stmt.execute(query))
	            rs = stmt.getResultSet();
				try {
					while(rs.next()) {
						int id = rs.getInt("roomId");
						if(!isRoomAvailable(id, Database.convertDateFormat(checkin), Database.convertDateFormat(checkout))) 
							continue;
						res.add(new HotelRoom());
						res.lastElement().setRoomID(rs.getInt("roomId"));
						res.lastElement().setStudio(rs.getBoolean("isStudio"));
						res.lastElement().setNumberOfBeds(rs.getInt("numberOfBeds"));
						res.lastElement().setPrice(rs.getInt("price"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

	    }
	    catch (SQLException ex){
	        // handle any errors
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	    }
	    finally {
	       if( stmt != null && rs != null) {
	            try {
	            	rs.close();
	                stmt.close();
	            } catch (SQLException sqlEx) { }
	            stmt = null;
	        }
	    }
	    return res;
	}
}
