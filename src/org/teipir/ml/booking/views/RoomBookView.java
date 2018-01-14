package org.teipir.ml.booking.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.teipir.ml.booking.controller.RoomBookController;
import org.teipir.ml.booking.models.Booking;
import org.teipir.ml.booking.models.Database;
import org.teipir.ml.booking.models.HotelRoom;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class RoomBookView extends JFrame {
	private Booking b;
	private HotelRoom r;
	public JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField telephoneField;
	private JTextField creditField;
	public RoomBookView(Booking b) {
		this.b = b;
		r = Database.searchRoom(b.getRoom());
		int days = b.getDuration();
		contentPane = new JPanel();
		setBounds(100, 100, 523, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstNameLabel = new JLabel("Όνομα:");
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstNameLabel.setBounds(10, 65, 95, 22);
		contentPane.add(firstNameLabel);
		
		JLabel surnameLabel = new JLabel("Επώνυμο:");
		surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		surnameLabel.setBounds(10, 98, 95, 22);
		contentPane.add(surnameLabel);
		
		JLabel title = new JLabel("Κράτηση Δωματίου");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		title.setBounds(10, 16, 273, 38);
		contentPane.add(title);
		
		nameField = new JTextField();
		nameField.setBounds(115, 65, 145, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(115, 98, 145, 20);
		contentPane.add(surnameField);
		
		JLabel telephoneLabel = new JLabel("Τηλέφωνο:");
		telephoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telephoneLabel.setBounds(10, 131, 95, 22);
		contentPane.add(telephoneLabel);
		
		telephoneField = new JTextField();
		telephoneField.setColumns(10);
		telephoneField.setBounds(115, 131, 145, 20);
		contentPane.add(telephoneField);
		
		JLabel creditCardLabel = new JLabel("Πιστωτική:");
		creditCardLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		creditCardLabel.setBounds(10, 164, 95, 22);
		contentPane.add(creditCardLabel);
		
		creditField = new JTextField();
		creditField.setColumns(10);
		creditField.setBounds(115, 164, 145, 20);
		contentPane.add(creditField);
		
		JButton confirmButton = new JButton("Ολοκλήρωση");
		confirmButton.setBounds(16, 215, 110, 23);
		contentPane.add(confirmButton);
		
		JButton cancelButton = new JButton("Ακύρωση");
		cancelButton.setBounds(150, 215, 110, 23);
		contentPane.add(cancelButton);
		
		JLabel sumOfPriceLabel = new JLabel("Συνολική τιμή: " + (r.getPrice() + (b.getNumMeals() * 5) * b.getDuration()) + "€");
		sumOfPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sumOfPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sumOfPriceLabel.setBounds(301, 160, 196, 31);
		contentPane.add(sumOfPriceLabel);
		
		JLabel mealPriceLabel = new JLabel("Κόστος Γευμάτων: "+ b.getNumMeals() * 5 * days + "€");
		mealPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mealPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mealPriceLabel.setBounds(301, 122, 196, 31);
		contentPane.add(mealPriceLabel);
		
		JLabel perPerDayLabel = new JLabel("Τιμή διανυκτέρευσης: "+ r.getPrice()+"€");
		perPerDayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		perPerDayLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		perPerDayLabel.setBounds(301, 89, 196, 31);
		contentPane.add(perPerDayLabel);
		
		RoomBookController c = new RoomBookController();
		confirmButton.addActionListener(c.new ConfirmButton(b, nameField, surnameField, telephoneField, creditField,this));
	}
}
