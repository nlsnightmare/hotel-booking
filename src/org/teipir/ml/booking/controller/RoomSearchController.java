package org.teipir.ml.booking.controller;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.teipir.ml.booking.models.Database;
import org.teipir.ml.booking.models.HotelRoom;
import org.teipir.ml.booking.views.RoomSearchResultsView;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RoomSearchController {
	public class SearchButtonController implements ActionListener {
		Choice numOfBeds;
		JCheckBox isStudio;
		JSlider costPerDay;
		JTextField from;
		JTextField till;
		JLabel is_check_in_Valid, is_check_out_Valid;

		public SearchButtonController(Choice numOfBeds,JCheckBox isStudio, JSlider costPerDay, JTextField from, JTextField till, JLabel is_check_in_Valid, JLabel is_check_out_Valid) {
			this.numOfBeds = numOfBeds;
			this.isStudio = isStudio;
			this.costPerDay = costPerDay;
			this.from = from;
			this.till = till;
			this.is_check_in_Valid = is_check_in_Valid;
			this.is_check_out_Valid = is_check_out_Valid;
			
		}

		public void actionPerformed(ActionEvent arg0) {			
			int numberOfBeds = numOfBeds.getSelectedIndex() + 1;
			boolean isstudio = isStudio.isSelected();
			int maximumPrice = costPerDay.getValue();
			
			String startingDate = from.getText();
			String finishDate = till.getText();
			SimpleDateFormat ft = new SimpleDateFormat("d/mm/yyyy");
			ft.setLenient(false);
			try {
				Date d1 = ft.parse(startingDate);
				Date d2 = ft.parse(finishDate);
				if(!d1.before(d2)) {
					JOptionPane.showMessageDialog(null, "Η ημερομηνία άφιξης πρέπει να είναι πριν την ημερομηνία αποχώρησης!");
					return;
				}
			} catch (ParseException e) {
				is_check_in_Valid.setText("X");
				is_check_out_Valid.setText("X");
				return;
			}

			is_check_in_Valid.setText("");
			is_check_out_Valid.setText("");
			
			String query = "SELECT * FROM ROOMS WHERE numberofbeds=" + numberOfBeds + " && isstudio=" + isstudio + " && price < " + maximumPrice;
			Vector<HotelRoom> v = Database.searchRoom(query, startingDate, finishDate);
			if( v.size() > 0) {
				RoomSearchResultsView view = new RoomSearchResultsView(v);
				view.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null, "No available rooms found!");
		}
	}

	public class ClearButtonController implements ActionListener {
		Choice numOfMeals;
		Choice numOfBeds;
		JCheckBox isStudio;
		JSlider costPerDay;
		JTextField from;
		JTextField till;

		public ClearButtonController(Choice numOfBeds,JCheckBox isStudio, JSlider costPerDay, JTextField from, JTextField till) {
			//this.numOfMeals = numOfMeals;
			this.numOfBeds = numOfBeds;
			this.isStudio = isStudio;
			this.costPerDay = costPerDay;
			this.from = from;
			this.till = till;
		}

		public void actionPerformed(ActionEvent arg0) {
			//numOfMeals.select(0);
			numOfBeds.select(0);
			isStudio.setSelected(false);
			costPerDay.setValue(costPerDay.getMinimum());
			from.setText("");
			till.setText("");
		}
	}

	public class CostPerDaySliderController implements ChangeListener {
		private JLabel costPerDay;

		public CostPerDaySliderController(JLabel costPerDay) {
			this.costPerDay = costPerDay;
		}

			
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
			costPerDay.setText(source.getValue() + "€");
		}
	}
}
