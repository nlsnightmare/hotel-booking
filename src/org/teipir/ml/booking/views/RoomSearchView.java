package org.teipir.ml.booking.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.teipir.ml.booking.controller.RoomSearchController;
import org.teipir.ml.booking.models.Database;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Choice;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Checkbox;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class RoomSearchView extends JFrame {

	private JPanel contentPane;
	private JTextField arrivalDate;
	private JTextField departureDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Database.initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomSearchView frame = new RoomSearchView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RoomSearchView() {
		setResizable(false);
		RoomSearchController c  = new RoomSearchController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{107, 186, 0, 0, 0, 28, 0};
		gbl_contentPane.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel label = new JLabel("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u0394\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u0394\u03C9\u03BC\u03B1\u03C4\u03AF\u03C9\u03BD");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		contentPane.add(label_1, gbc_label_1);
		
		Choice numOfBeds = new Choice();
		numOfBeds.add("Μονόκλινο");
		numOfBeds.add("Δίκλινο");
		numOfBeds.add("Τρίκλινο");
		GridBagConstraints gbc_numOfBeds = new GridBagConstraints();
		gbc_numOfBeds.anchor = GridBagConstraints.WEST;
		gbc_numOfBeds.insets = new Insets(0, 0, 5, 5);
		gbc_numOfBeds.gridx = 1;
		gbc_numOfBeds.gridy = 2;
		contentPane.add(numOfBeds, gbc_numOfBeds);
		
		JLabel lblStudio = new JLabel("Studio");
		lblStudio.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStudio = new GridBagConstraints();
		gbc_lblStudio.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudio.gridx = 0;
		gbc_lblStudio.gridy = 3;
		contentPane.add(lblStudio, gbc_lblStudio);
		
		JCheckBox isStudio = new JCheckBox("");
		isStudio.setToolTipText("\u0391\u03BD \u03C4\u03BF \u03B4\u03C9\u03BC\u03AC\u03C4\u03B9\u03BF \u03B8\u03B1 \u03AD\u03C7\u03B5\u03B9 \u03BA\u03B1\u03B9 \u03BA\u03BF\u03C5\u03B6\u03AF\u03BD\u03B1/\u03BA\u03B1\u03B8\u03B9\u03C3\u03C4\u03B9\u03BA\u03CC");
		isStudio.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_isStudio = new GridBagConstraints();
		gbc_isStudio.anchor = GridBagConstraints.WEST;
		gbc_isStudio.insets = new Insets(0, 0, 5, 5);
		gbc_isStudio.gridx = 1;
		gbc_isStudio.gridy = 3;
		contentPane.add(isStudio, gbc_isStudio);
		
		JLabel label_2 = new JLabel("\u03A4\u03B9\u03BC\u03AE \u0394\u03B9\u03B1\u03BD\u03C5\u03BA\u03C4\u03AD\u03C1\u03B5\u03C5\u03C3\u03B7\u03C2");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 4;
		contentPane.add(label_2, gbc_label_2);
		
		JLabel costPerDay = new JLabel("0.00\u20AC");
		costPerDay.setHorizontalAlignment(SwingConstants.CENTER);
		costPerDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_costPerDay = new GridBagConstraints();
		gbc_costPerDay.insets = new Insets(0, 0, 5, 5);
		gbc_costPerDay.gridx = 4;
		gbc_costPerDay.gridy = 4;
		contentPane.add(costPerDay, gbc_costPerDay);

		JSlider costPerDaySlider = new JSlider();
		costPerDaySlider.setMaximum(500);
		costPerDaySlider.setMinimum(20);
		costPerDaySlider.addChangeListener(c.new CostPerDaySliderController(costPerDay));
		costPerDaySlider.setValue(0);
		GridBagConstraints gbc_costPerDaySlider = new GridBagConstraints();
		gbc_costPerDaySlider.insets = new Insets(0, 0, 5, 5);
		gbc_costPerDaySlider.gridx = 1;
		gbc_costPerDaySlider.gridy = 4;
		contentPane.add(costPerDaySlider, gbc_costPerDaySlider);
		
		
		JLabel label_3 = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0386\u03C6\u03B9\u03BE\u03B7\u03C2");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 5;
		contentPane.add(label_3, gbc_label_3);
		
		arrivalDate = new JTextField();
		GridBagConstraints gbc_arrivalDate = new GridBagConstraints();
		gbc_arrivalDate.insets = new Insets(0, 0, 5, 5);
		gbc_arrivalDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_arrivalDate.gridx = 1;
		gbc_arrivalDate.gridy = 5;
		contentPane.add(arrivalDate, gbc_arrivalDate);
		arrivalDate.setColumns(5);
		
		JLabel label_4 = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0391\u03C0\u03BF\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7\u03C2");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 6;
		contentPane.add(label_4, gbc_label_4);
		
		departureDate = new JTextField();
		departureDate.setColumns(5);
		GridBagConstraints gbc_departureDate = new GridBagConstraints();
		gbc_departureDate.insets = new Insets(0, 0, 5, 5);
		gbc_departureDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_departureDate.gridx = 1;
		gbc_departureDate.gridy = 6;
		contentPane.add(departureDate, gbc_departureDate);
		
		JLabel is_check_in_Valid = new JLabel("");
		is_check_in_Valid.setForeground(Color.RED);
		GridBagConstraints gbc_is_check_in_Valid = new GridBagConstraints();
		gbc_is_check_in_Valid.gridwidth = 2;
		gbc_is_check_in_Valid.insets = new Insets(0, 0, 5, 5);
		gbc_is_check_in_Valid.gridx = 2;
		gbc_is_check_in_Valid.gridy = 5;
		contentPane.add(is_check_in_Valid, gbc_is_check_in_Valid);
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.insets = new Insets(0, 0, 5, 5);
		gbc_searchButton.gridx = 0;
		gbc_searchButton.gridy = 7;

		JLabel is_check_out_Valid = new JLabel("");
		is_check_out_Valid.setForeground(Color.RED);
		GridBagConstraints gbc_is_check_out_Valid = new GridBagConstraints();
		gbc_is_check_out_Valid.gridwidth = 2;
		gbc_is_check_out_Valid.insets = new Insets(0, 0, 5, 5);
		gbc_is_check_out_Valid.gridx = 2;
		gbc_is_check_out_Valid.gridy = 6;
		contentPane.add(is_check_out_Valid, gbc_is_check_out_Valid);
	
		JButton searchButton = new JButton("Αναζήτηση");
		searchButton.addActionListener(c.new SearchButtonController(numOfBeds, isStudio, costPerDaySlider, arrivalDate, departureDate, is_check_in_Valid, is_check_out_Valid));
		contentPane.add(searchButton, gbc_searchButton);
		
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		
		SimpleDateFormat ft = new SimpleDateFormat("d/m/y");
		arrivalDate.setText(ft.format(today));
		departureDate.setText(ft.format(tomorrow));
		
		JButton clearButton = new JButton("Απαλοιφή Φίλτρων");
		GridBagConstraints gbc_clearButton = new GridBagConstraints();
		gbc_clearButton.insets = new Insets(0, 0, 5, 5);
		gbc_clearButton.gridx = 1;
		gbc_clearButton.gridy = 7;
		contentPane.add(clearButton, gbc_clearButton);
	}
}
