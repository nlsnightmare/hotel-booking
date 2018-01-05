package org.teipir.ml.booking.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.teipir.ml.booking.models.Booking;
import org.teipir.ml.booking.views.RoomBookView;
import org.teipir.ml.booking.views.RoomSearchResultsView;

public class RoomResultsController {
	public class NextButtonController implements ActionListener {
		private RoomSearchResultsView view;

		public NextButtonController(RoomSearchResultsView view) {
			this.view = view;
		}
		public void actionPerformed(ActionEvent arg0) {
			view.nextRoom();
		}
		
	}
	public class PrevButtonController implements ActionListener {
		private RoomSearchResultsView view;

		public PrevButtonController(RoomSearchResultsView view) {
			this.view = view;
		}
		public void actionPerformed(ActionEvent arg0) {
			view.prevRoom();
		}
		
	}
	public class CostPerDayController implements ItemListener {

		private RoomSearchResultsView view;
		public CostPerDayController(RoomSearchResultsView view) {
			this.view = view;
		}
		public void stateChanged(ChangeEvent arg0) {
		}
		public void itemStateChanged(ItemEvent arg0) {
			view.UpdateCostLabel();
		}
		
	}
	public class BookRoomButton  implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			Booking b = Booking.createBooking(2, 2);
			RoomBookView view = new RoomBookView();
			view.setVisible(true);
		}
	}
}
