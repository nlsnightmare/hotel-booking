package org.teipir.ml.booking.controller;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.teipir.ml.booking.views.RoomSearchResultsView;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RoomSearchController {
	public class SearchButtonController implements ActionListener {
		Choice numOfMeals;
		Choice numOfBeds;
		JCheckBox isStudio;
		JSlider costPerDay;
		JTextField from;
		JTextField till;

		public SearchButtonController(Choice numOfMeals,Choice numOfBeds,JCheckBox isStudio, JSlider costPerDay, JTextField from, JTextField till) {
			this.numOfMeals = numOfMeals;
			this.numOfBeds = numOfBeds;
			this.isStudio = isStudio;
			this.costPerDay = costPerDay;
			this.from = from;
			this.till = till;
		}

		public void actionPerformed(ActionEvent arg0) {			
			System.out.println("So you want a room: ");
			int numberOfBeds = numOfBeds.getSelectedIndex() + 1;
			System.out.println("With " + numberOfBeds + " beds");

			int numberOfMeals = numOfMeals.getSelectedIndex();
			System.out.println("With " + numberOfMeals + " meals");
			
			boolean isstudio = isStudio.isSelected();
			System.out.println(isstudio);
			
			int maximumPrice = costPerDay.getValue();
			System.out.println("Maximum cost: " + maximumPrice);
			
			String startingDate = from.getText();
			String finishDate = till.getText();
			System.out.println("From: " + startingDate);
			System.out.println("Till: " + finishDate);
			
			String query = "SELECT * FROM ROOMS WHERE numberofbeds=" + numberOfBeds + " && isstudio=" + isstudio;
			System.out.println(query);
			RoomSearchResultsView v = new RoomSearchResultsView(3);
			v.setVisible(true);
		}
	}
	

	public class ClearButtonController implements ActionListener {
		Choice numOfMeals;
		Choice numOfBeds;
		JCheckBox isStudio;
		JSlider costPerDay;
		JTextField from;
		JTextField till;

		public ClearButtonController(Choice numOfMeals,Choice numOfBeds,JCheckBox isStudio, JSlider costPerDay, JTextField from, JTextField till) {
			this.numOfMeals = numOfMeals;
			this.numOfBeds = numOfBeds;
			this.isStudio = isStudio;
			this.costPerDay = costPerDay;
			this.from = from;
			this.till = till;
		}

		public void actionPerformed(ActionEvent arg0) {
			numOfMeals.select(0);
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
