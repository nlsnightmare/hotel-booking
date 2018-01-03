package org.teipir.ml.booking.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class RoomSearchResultsView extends JFrame {
	private Vector<HotelRoom> results;
	private int currentRoomIndex;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RoomSearchResultsView(Vector<HotelRoom> v) {
		System.out.println();
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
		nextRoomButton.setEnabled(v.size() > 1);
		nextRoomButton.setBounds(370, 300, 160, 50);
		contentPane.add(nextRoomButton);
		
		JButton BookRoomButton = new JButton("Κράτηση Δωματίου");
		BookRoomButton.setBounds(180, 300, 180, 50);
		contentPane.add(BookRoomButton);
		
		JLabel resultsCountLabel = new JLabel("Βλέπετε δωμάτιο " + (currentRoomIndex + 1) + " από " + v.size());
		resultsCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultsCountLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultsCountLabel.setBounds(0, 60, 250, 22);
		contentPane.add(resultsCountLabel);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("roompics/" + results.get(currentRoomIndex).getRoomID() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel RoomPhoto = new JLabel();
		RoomPhoto.setBounds(62, 93, 217, 173);
		Image dimg = img.getScaledInstance(RoomPhoto.getWidth(), RoomPhoto.getHeight(),
		        Image.SCALE_SMOOTH);
		RoomPhoto.setIcon(new ImageIcon(dimg));
		System.out.println(img == null);
		contentPane.add(RoomPhoto);

	}

	public void DisplayRoom(HotelRoom r) {
	}

}