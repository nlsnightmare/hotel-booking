package org.teipir.ml.booking.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    } catch (Exception ex) {
	    }
	    Connection conn = null;
	    try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelbooking?" + "user=root&password=root&useSSL=false");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    java.sql.Statement stmt = null;
	    ResultSet rs = null;
	    try {
	        stmt = conn.createStatement();
	        if (stmt.execute("SELECT * FROM Rooms")) {
	            rs = stmt.getResultSet();
	            while(rs.next())
	            	System.out.println("Room number: " + rs.getString("roomid") + " " + rs.getBoolean("isAvailable") );
	        }

	        // Now do something with the ResultSet ....
	    }
	    catch (SQLException ex){
	        // handle any errors
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	    }
	    finally {
	        // it is a good idea to release
	        // resources in a finally{} block
	        // in reverse-order of their creation
	        // if they are no-longer needed

	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException sqlEx) { } // ignore

	            rs = null;
	        }

	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException sqlEx) { } // ignore

	            stmt = null;
	        }
	    }
 

	}

}
