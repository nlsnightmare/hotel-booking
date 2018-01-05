package org.teipir.ml.booking.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.TestCase;

public class TestBooking extends TestCase {
	public void testQuery() {
		String today = new SimpleDateFormat("y-M-d").format(Calendar.getInstance().getTime());
		Booking b = new Booking(1, "2101111111","123443211234", "TestName", "TestSurName", "", "1-1-1","2-1-1",200,true);
		String Expected = "INSERT INTO BOOKING(TELEPHONE,CREDITCARD,FIRSTNAME,SURNAME,BOOKDATE,CHECKIN,CHECKOUT,PREPAIDAMOUNT,ROOM,ISONLINE) "
				+ "VALUES('2101111111','123443211234','TestName','TestSurName','"+today+"','1-1-1','1-1-2',200,1,true)";
		assertEquals(b.toQuery(), Expected);
	}

}
