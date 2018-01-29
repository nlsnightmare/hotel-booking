package org.teipir.ml.booking.models;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.TestCase;

public class TestBooking extends TestCase {
	public void testQuery() {
		String today = new SimpleDateFormat("y-M-d").format(Calendar.getInstance().getTime());
		Booking b = new Booking(1, "2101111111","123443211234", "TestName", "TestSurName", "", "1-1-1","2-1-1",200,true);
		String Expected = "INSERT INTO BOOKING(TELEPHONE,CREDITCARD,FIRSTNAME,SURNAME,BOOKDATE,CHECKIN,CHECKOUT,PREPAIDAMOUNT,ROOM,ISONLINE,NUMMEALS) "
				+ "VALUES('2101111111','123443211234','TestName','TestSurName','"+today+"','1-1-1','1-1-2',200,1,true,0)";
		assertEquals(b.toQuery(), Expected);
	}
	
	public void testSetAndGet() {
		Booking b = new Booking();
		Date t = new Date(1);
		b.setBookDate(t);
		assertEquals(b.getBookDate(), t);
		
		b.setTelephone("1234");
		assertEquals(b.getTelephone(), "1234");

		b.setBookingID(1);
		assertEquals(b.getBookingID(),1);
		
		b.setCheckIn(t);
		assertEquals(b.getCheckIn(),t);

		b.setCheckOut(t);
		assertEquals(b.getCheckOut(),t);
		
		
		b.setCreditCard("111");
		assertEquals(b.getCreditCard(),"111");
		
		b.setName("test");
		assertEquals(b.getName(), "test");
		
		b.setNumMeals(2);
		assertEquals(b.getNumMeals(),2);
		
		b.setOnline(true);
		assertEquals(b.isOnline(),true);
		
		b.setPrepaidAmount(20);
		assertEquals(b.getPrepaidAmount(),20);
		
		b.setSurname("AAA");
		assertEquals(b.getSurname(), "AAA");
		
		
	}

}
