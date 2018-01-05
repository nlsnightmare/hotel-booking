package org.teipir.ml.booking.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking {
	
	private int bookingID;
	private String telephone;
	private String creditCard;
	private String name;
	private String surname;
	private Date bookDate;
	private Date checkIn;
	private Date checkOut;
	private int prepaidAmount;
	private int roomId;
	private int numMeals = 0;
	private boolean isOnline;

	public Booking() {
		
	}
	
	public Booking(int roomId, String telephone, String creditCard, String name, String surname, String bookDate,
			String checkIn, String checkOut, int prepaidAmount, boolean isOnline) {

		SimpleDateFormat ft = new SimpleDateFormat("d-M-y");
		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		try {
			if(checkIn != "") {
				d1 = ft.parse(checkIn);
			}
			if(checkOut != "") {
				d2 = ft.parse(checkOut);
			}
			if(bookDate != "")
				d3 = ft.parse(bookDate);
		} catch (ParseException e) {
			System.out.println("Failed to parse dates");
		}
		this.roomId = roomId;
		this.telephone = telephone;
		this.creditCard = creditCard;
		this.name = name;
		this.surname = surname;
		this.bookDate = d3;
		this.checkIn = d1;
		this.checkOut = d2;
		this.prepaidAmount = prepaidAmount;
		this.isOnline = isOnline;
	}

	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date startingDate) {
		this.checkIn = startingDate;
	}
	public void setCheckIn(String checkIn) {
		SimpleDateFormat ft = new SimpleDateFormat("d/M/y");
		try {
			this.checkIn = ft.parse(checkIn);
		} catch (ParseException e) {
		}
		
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date finishDate) {
		this.checkOut = finishDate;
	}
	public void setCheckOut(String checkOut) {
		SimpleDateFormat ft = new SimpleDateFormat("d/M/y");
		try {
			this.checkOut = ft.parse(checkOut);
		} catch (ParseException e) {
		}
		
	}
	public int getPrepaidAmount() {
		return prepaidAmount;
	}
	public void setPrepaidAmount(int prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
	}
	public int getRoom() {
		return roomId;
	}
	public void setRoom(int roomId) {
		this.roomId = roomId;
	}
	public void setRoom(HotelRoom room) {
		this.roomId = room.getRoomID();
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	
	public String toQuery() {
		String today = "";
		Date d = Calendar.getInstance().getTime();
		SimpleDateFormat ft = new SimpleDateFormat("y-M-d");
		today = ft.format(d);
		String query = "INSERT INTO BOOKING(TELEPHONE,CREDITCARD,FIRSTNAME,SURNAME,BOOKDATE,CHECKIN,CHECKOUT,PREPAIDAMOUNT,ROOM,ISONLINE) "
				+ "VALUES('" + getTelephone() + "','" + getCreditCard() + "','" + getName() + "','" + getSurname() + "','" + today +
				"','" + ft.format(getCheckIn()) + "','" + ft.format(getCheckOut()) + "'," + getPrepaidAmount() + "," + getRoom() + ",true)";
		return query;
	}

	public int getNumMeals() {
		return numMeals;
	}

	public void setNumMeals(int numMeals) {
		this.numMeals = numMeals;
	}
}
