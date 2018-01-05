package org.teipir.ml.booking.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.teipir.ml.booking.controller.RoomResultsController;
import org.teipir.ml.booking.models.HotelRoom;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class RoomSearchResultsView extends JFrame {
	private Vector<HotelRoom> results;
	private int currentRoomIndex;
	private JPanel contentPane;
	JButton nextRoomButton;
	JButton prevRoomButton;
	JLabel resultsCountLabel;
	JLabel RoomPhoto;
	private JLabel totalCostLabel;
	Choice numOfMeals;
	/**
	 * Create the frame.
	 */
	public RoomSearchResultsView(Vector<HotelRoom> v) {
		results = v;
		currentRoomIndex = 0;
		setResizable(false);
		setBounds(100, 100, 555, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Αποτελέσματα Αναζήτησης");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 11, 539, 38);
		contentPane.add(label);
		
		prevRoomButton = new JButton("Προηγούμενο Δωμάτιο");
		prevRoomButton.setEnabled(false);
		prevRoomButton.setBounds(10, 300, 160, 50);
		contentPane.add(prevRoomButton);
		
		nextRoomButton = new JButton("Επόμενο Δωμάτιο");
		nextRoomButton.setBounds(370, 300, 160, 50);
		contentPane.add(nextRoomButton);
		
		JButton bookRoomButton = new JButton("Κράτηση Δωματίου");
		bookRoomButton.setBounds(180, 300, 180, 50);
		contentPane.add(bookRoomButton);
		
		resultsCountLabel = new JLabel();
		resultsCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultsCountLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultsCountLabel.setBounds(0, 60, 250, 22);
		contentPane.add(resultsCountLabel);
		
		numOfMeals = new Choice();
		numOfMeals.add("Kανένα");
		numOfMeals.add("Ημιδιατροφή");
		numOfMeals.add("Πλήρης Διατροφή");
		numOfMeals.setBounds(412, 93, 118, 20);
		contentPane.add(numOfMeals);

		RoomPhoto = new JLabel();
		RoomPhoto.setBackground(Color.BLUE);
		RoomPhoto.setBounds(62, 93, 217, 173);
		contentPane.add(RoomPhoto);
		
		JLabel costLabel = new JLabel("Τιμή διανυκτέρευσης:");
		costLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		costLabel.setBounds(289, 143, 139, 22);
		contentPane.add(costLabel);
		
		JLabel numOfMealsLabel = new JLabel("Αριθμός Γευμάτων");
		numOfMealsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numOfMealsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numOfMealsLabel.setBounds(285, 93, 114, 17);
		contentPane.add(numOfMealsLabel);
		
		totalCostLabel = new JLabel("totalCost");
		totalCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalCostLabel.setBounds(432, 143, 69, 20);
		contentPane.add(totalCostLabel);

		RoomResultsController c = new RoomResultsController();
		numOfMeals.addItemListener(c.new CostPerDayController(this));
		bookRoomButton.addActionListener(c.new BookRoomButton());
		nextRoomButton.addActionListener(c.new NextButtonController(this));
		prevRoomButton.addActionListener(c.new PrevButtonController(this));
		currentRoomIndex = 0;
		DisplayRoom();
	}
	
	public void prevRoom() {
		currentRoomIndex--;
		DisplayRoom();
	}
	public void nextRoom() {
		currentRoomIndex++;
		DisplayRoom();
	}

	private void DisplayRoom() {
		nextRoomButton.setEnabled(results.size() > currentRoomIndex + 1);
		prevRoomButton.setEnabled(currentRoomIndex > 0);
		resultsCountLabel.setText(("Βλέπετε δωμάτιο " + (currentRoomIndex + 1) + " από " + results.size()));
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("roompics/" + results.get(currentRoomIndex).getRoomID() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(RoomPhoto.getWidth(), RoomPhoto.getHeight(),
		        Image.SCALE_SMOOTH);
		RoomPhoto.setIcon(new ImageIcon(dimg));
		
		UpdateCostLabel();
	}
	
	public void UpdateCostLabel() {
		totalCostLabel.setText(results.get(currentRoomIndex).calculatePrice(numOfMeals.getSelectedIndex(), 1) + "€");
	}
}