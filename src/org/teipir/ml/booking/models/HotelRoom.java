package org.teipir.ml.booking.models;


import java.util.Date;
import java.util.Vector;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HotelRoom {
	private int roomID;
	private int numberOfBeds;
	private boolean isStudio;
	private int numberOfMeals;
	private int[] priceWithMeals;
	
	public static Vector<HotelRoom> getRoomFromQuery(String query){
		Vector<HotelRoom> res = new Vector();
		res.add(new HotelRoom());
		res.get(0).roomID = 5;
		res.add(new HotelRoom());
		res.get(1).roomID = 1;
		return res;
	}
	public int calculatePrice(int numOfMeals, int days) {
		return priceWithMeals[numOfMeals] * days;
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

	public int[] getPriceWithMeals() {
		return priceWithMeals;
	}

	public void setPriceWithMeals(int[] priceWithMeals) {
		this.priceWithMeals = priceWithMeals;
	}

	public int getNumberOfMeals() {
		return numberOfMeals;
	}

	public void setNumberOfMeals(int numberOfMeals) {
		this.numberOfMeals = numberOfMeals;
	}
}
