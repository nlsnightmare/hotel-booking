package org.teipir.ml.booking.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RoomSearchResultsView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public RoomSearchResultsView(int i) {
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton prevRoomButton = new JButton("Προηγούμενο Δωμάτιο");
		prevRoomButton.setEnabled(false);
		prevRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		prevRoomButton.setBounds(10, 300, 160, 50);
		contentPane.add(prevRoomButton);
		
		JButton nextRoomButton = new JButton("Επόμενο Δωμάτιο");
		nextRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		nextRoomButton.setBounds(370, 300, 160, 50);
		contentPane.add(nextRoomButton);
		
		JButton BookRoomButton = new JButton("Κράτηση Δωματίου");
		BookRoomButton.setBounds(180, 300, 180, 50);
		contentPane.add(BookRoomButton);
		
		textField = new JTextField();
		textField.setBounds(137, 122, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("" + i);
	}
}
