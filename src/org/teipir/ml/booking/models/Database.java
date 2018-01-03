package org.teipir.ml.booking.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Statement;


public class Database {

	private static Connection conn = null;

	public static void initialize() {
		// TODO Auto-generated method stub
	    try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    } catch (Exception ex) {
	    	System.out.println("Failed to find 'com.mysql.jdbc.Driver'");
	    }
	    conn = null;
	    try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelbooking?" + "user=root&password=root&useSSL=false");
		} catch (SQLException e) {
			System.out.println("Failed to connect to database!");
		}
	}

	public static Vector<HotelRoom> runQuery(String query) {
	    java.sql.Statement stmt = null;
	    ResultSet rs = null;
		Vector<HotelRoom> res = new Vector<HotelRoom>();
	    try {
	        stmt = conn.createStatement();
	        if (stmt.execute(query))
	            rs = stmt.getResultSet();
				try {
					while(rs.next()) {
						res.add(new HotelRoom());
						res.get(0).setRoomID(rs.getInt("roomId"));
						res.get(0).setStudio(rs.getBoolean("isStudio"));
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
