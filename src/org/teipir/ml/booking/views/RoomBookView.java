package org.teipir.ml.booking.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.teipir.ml.booking.models.Booking;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class RoomBookView extends JFrame {
	public JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public RoomBookView() {
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
		
		textField = new JTextField();
		textField.setBounds(115, 65, 145, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 98, 145, 20);
		contentPane.add(textField_1);
		
		JLabel telephoneLabel = new JLabel("Τηλέφωνο:");
		telephoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telephoneLabel.setBounds(10, 131, 95, 22);
		contentPane.add(telephoneLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 131, 145, 20);
		contentPane.add(textField_2);
		
		JLabel creditCardLabel = new JLabel("Πιστωτική:");
		creditCardLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		creditCardLabel.setBounds(10, 164, 95, 22);
		contentPane.add(creditCardLabel);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(115, 164, 145, 20);
		contentPane.add(textField_3);
		
		JButton confirmButton = new JButton("Ολοκλήρωση");
		confirmButton.setBounds(16, 215, 110, 23);
		contentPane.add(confirmButton);
		
		JButton cancelButton = new JButton("Ακύρωση");
		cancelButton.setBounds(150, 215, 110, 23);
		contentPane.add(cancelButton);
		
		JLabel sumOfPriceLabel = new JLabel("Συνολική τιμή: 0.00€");
		sumOfPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sumOfPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sumOfPriceLabel.setBounds(301, 160, 196, 31);
		contentPane.add(sumOfPriceLabel);
		
		JLabel mealPriceLabel = new JLabel("Κόστος Γευμάτων: 0.00€");
		mealPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mealPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mealPriceLabel.setBounds(301, 122, 196, 31);
		contentPane.add(mealPriceLabel);
		
		JLabel perPerDayLabel = new JLabel("Τιμή διανυκτέρευσης: 0.00€");
		perPerDayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		perPerDayLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		perPerDayLabel.setBounds(301, 89, 196, 31);
		contentPane.add(perPerDayLabel);
	}
}
