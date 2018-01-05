package org.teipir.ml.booking.controller;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.teipir.ml.booking.models.Booking;
import org.teipir.ml.booking.views.RoomBookView;
import org.teipir.ml.booking.views.RoomResultsView;

import com.sun.glass.ui.View;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class RoomResultsController {
	public class NextButtonController implements ActionListener {
		private RoomResultsView view;

		public NextButtonController(RoomResultsView view) {
			this.view = view;
		}
		public void actionPerformed(ActionEvent arg0) {
			view.nextRoom();
		}
		
	}
	public class PrevButtonController implements ActionListener {
		private RoomResultsView view;

		public PrevButtonController(RoomResultsView view) {
			this.view = view;
		}
		public void actionPerformed(ActionEvent arg0) {
			view.prevRoom();
		}
		
	}
	public class CostPerDayController implements ItemListener {

		private RoomResultsView view;
		private Booking b;
		private Choice self;
		public CostPerDayController(RoomResultsView view, Choice s, Booking b) {
			this.self = s;
			this.b = b;
			this.view = view;
		}
		public void stateChanged(ChangeEvent arg0) {
		}
		public void itemStateChanged(ItemEvent arg0) {

			view.UpdateCostLabel();
			b.setNumMeals(self.getSelectedIndex());
		}
		
	}
	public class BookRoomButton  implements ActionListener {
		private Booking b;
		private RoomResultsView view;

		public BookRoomButton(RoomResultsView view, Booking b) {
			this.view = view;
			this.b = b;
		}
		public void actionPerformed(ActionEvent arg0) {
			b.setRoom(view.getCurrentRoomID());
			RoomBookView view = new RoomBookView(b);
			view.setVisible(true);
		}
	}
}
