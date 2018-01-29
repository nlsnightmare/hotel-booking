package org.teipir.ml.booking.models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Connection;

import junit.framework.TestCase;

public class DatabaseTest extends TestCase {
	private Connection conn = null;
	public void setUp() {
	    try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    } catch (Exception ex) {
	    	System.out.println("Failed to find 'com.mysql.jdbc.Driver'");
	    }
	    conn = null;
	    try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hotelbooking?user=root&password=root&useSSL=false");
		} catch (SQLException e) {
			System.out.println("Failed to connect to database!");
		}
	}

	public void tearDown() {
		ResultSet rs = null;
	    java.sql.Statement stmt = null;
	    try	{
	    	stmt = conn.createStatement();
	    	stmt.execute("DELETE FROM BOOKING WHERE CHECKIN='1-1-1'");
	    }
	    catch (SQLException e) {
	    	System.out.println(e.toString());
	    	assert(false);
	    }
	}
	public void testConnection() {
		assertEquals(Database.initialize("hotelbooking", "root", "root"), true);
	}
	
	public void testBooking() {
		assertEquals(Database.bookRoom(new Booking(1, "2101111111","123443211234", "TestName", "TestSurName", "", "1-1-1","2-1-1",200,true)),true);
		assertEquals(Database.bookRoom(new Booking(1, "","", "", "", "", "1-1-1","2-1-1",200,true)),false);
	}

	public void testSearchRoom() {
		HotelRoom r = Database.searchRoom(1);
		assertEquals(r.getRoomID(), 1);
		r = Database.searchRoom(-1);
		assertEquals(r, null);
	}
	
	public void testConvertDate() {
		assertEquals(Database.convertDateFormat("1/1/2018"), "2018-1-1");
		assertEquals(Database.convertDateFormat("4/6/2018"), "2018-6-4");
	}

	public void testQuery() {
		Vector<HotelRoom> v = Database.searchRoom("SELECT * FROM ROOMS","1/1/3000", "2/1/3000");
		assertEquals(v.size(), 10);
		v = Database.searchRoom("SELECT * FROM ROOMS WHERE 0","1/1/2050", "2/1/2050");
		assertEquals(v.size(), 0);

		Database.bookRoom(new Booking(1, "2101111111","123443211234", "TestName", "TestSurName", "", "1-1-1","2-1-1",200,true));
		v = Database.searchRoom("SELECT * FROM ROOMS WHERE ROOMID=1","1/1/1", "2/1/2050");
		assertEquals(v.size(),0);
	}

}
