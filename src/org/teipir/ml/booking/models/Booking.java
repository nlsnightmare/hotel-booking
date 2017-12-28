package org.teipir.ml.booking.models;

import java.util.Date;

public class Booking {
	
	private int bookingID;
	private String telephone;
	private String creditCard;
	private String name;
	private String surname;
	private Date bookDate;
	private Date startingDate;
	private Date finishDate;
	private int prepaidAmount;
	private HotelRoom room;
	private boolean isOnline;
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
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public int getPrepaidAmount() {
		return prepaidAmount;
	}
	public void setPrepaidAmount(int prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
	}
	public HotelRoom getRoom() {
		return room;
	}
	public void setRoom(HotelRoom room) {
		this.room = room;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
}
