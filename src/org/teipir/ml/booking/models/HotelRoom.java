package org.teipir.ml.booking.models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HotelRoom {
	private int roomID;
	private int numberOfBeds;
	private boolean isStudio;
	private int numberOfMeals;
	private int price;
	

	public int calculatePrice(int numOfMeals, int days) {
		return (price + numOfMeals * 10) * days;
	}
	
	public boolean checkAvailability(Date from, Date till) {
		throw new NotImplementedException();
	}


	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public boolean isStudio() {
		return isStudio;
	}

	public void setStudio(boolean isStudio) {
		this.isStudio = isStudio;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfMeals() {
		return numberOfMeals;
	}

	public void setNumberOfMeals(int numberOfMeals) {
		this.numberOfMeals = numberOfMeals;
	}
}
