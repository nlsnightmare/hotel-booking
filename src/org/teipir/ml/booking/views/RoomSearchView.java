package org.teipir.ml.booking.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.teipir.ml.booking.controller.RoomSearchController;

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
import java.awt.event.ActionEvent;

public class RoomSearchView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{107, 186, 0, 28, 0};
		gbl_contentPane.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel label_5 = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u0393\u03B5\u03C5\u03BC\u03AC\u03C4\u03C9\u03BD");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 3;
		contentPane.add(label_5, gbc_label_5);
		
		Choice numOfMeals = new Choice();
		numOfMeals.add("Kανένα");
		numOfMeals.add("Ημιδιατροφή");
		numOfMeals.add("Πλήρης Διατροφή");
		GridBagConstraints gbc_numOfMeals = new GridBagConstraints();
		gbc_numOfMeals.anchor = GridBagConstraints.WEST;
		gbc_numOfMeals.insets = new Insets(0, 0, 5, 5);
		gbc_numOfMeals.gridx = 1;
		gbc_numOfMeals.gridy = 3;
		contentPane.add(numOfMeals, gbc_numOfMeals);
		
		JLabel lblStudio = new JLabel("Studio");
		lblStudio.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStudio = new GridBagConstraints();
		gbc_lblStudio.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudio.gridx = 0;
		gbc_lblStudio.gridy = 4;
		contentPane.add(lblStudio, gbc_lblStudio);
		
		JCheckBox isStudio = new JCheckBox("");
		isStudio.setToolTipText("\u0391\u03BD \u03C4\u03BF \u03B4\u03C9\u03BC\u03AC\u03C4\u03B9\u03BF \u03B8\u03B1 \u03AD\u03C7\u03B5\u03B9 \u03BA\u03B1\u03B9 \u03BA\u03BF\u03C5\u03B6\u03AF\u03BD\u03B1/\u03BA\u03B1\u03B8\u03B9\u03C3\u03C4\u03B9\u03BA\u03CC");
		isStudio.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_isStudio = new GridBagConstraints();
		gbc_isStudio.anchor = GridBagConstraints.WEST;
		gbc_isStudio.insets = new Insets(0, 0, 5, 5);
		gbc_isStudio.gridx = 1;
		gbc_isStudio.gridy = 4;
		contentPane.add(isStudio, gbc_isStudio);
		
		JLabel label_2 = new JLabel("\u03A4\u03B9\u03BC\u03AE \u0394\u03B9\u03B1\u03BD\u03C5\u03BA\u03C4\u03AD\u03C1\u03B5\u03C5\u03C3\u03B7\u03C2");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 5;
		contentPane.add(label_2, gbc_label_2);
		
		JSlider costPerDaySlider = new JSlider();
		costPerDaySlider.setValue(0);
		GridBagConstraints gbc_costPerDaySlider = new GridBagConstraints();
		gbc_costPerDaySlider.insets = new Insets(0, 0, 5, 5);
		gbc_costPerDaySlider.gridx = 1;
		gbc_costPerDaySlider.gridy = 5;
		contentPane.add(costPerDaySlider, gbc_costPerDaySlider);
		
		JLabel costPerDay = new JLabel("0.00\u20AC");
		costPerDay.setHorizontalAlignment(SwingConstants.CENTER);
		costPerDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_costPerDay = new GridBagConstraints();
		gbc_costPerDay.insets = new Insets(0, 0, 5, 5);
		gbc_costPerDay.gridx = 2;
		gbc_costPerDay.gridy = 5;
		contentPane.add(costPerDay, gbc_costPerDay);
		
		JLabel label_3 = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0386\u03C6\u03B9\u03BE\u03B7\u03C2");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 6;
		contentPane.add(label_3, gbc_label_3);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 6;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(5);
		
		JLabel label_4 = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0391\u03C0\u03BF\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7\u03C2");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 7;
		contentPane.add(label_4, gbc_label_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(5);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 7;
		contentPane.add(textField_1, gbc_textField_1);
		
		RoomSearchController c  = new RoomSearchController();

		JButton searchButton = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		searchButton.addActionListener(c.new SearchButtonController());
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.insets = new Insets(0, 0, 0, 5);
		gbc_searchButton.gridx = 0;
		gbc_searchButton.gridy = 9;
		contentPane.add(searchButton, gbc_searchButton);
		
		JButton clearButton = new JButton("\u0391\u03C0\u03B1\u03BB\u03BF\u03B9\u03C6\u03AE \u03A6\u03AF\u03BB\u03C4\u03C1\u03C9\u03BD");
		GridBagConstraints gbc_clearButton = new GridBagConstraints();
		gbc_clearButton.insets = new Insets(0, 0, 0, 5);
		gbc_clearButton.gridx = 1;
		gbc_clearButton.gridy = 9;
		contentPane.add(clearButton, gbc_clearButton);
		
	
	}
}
