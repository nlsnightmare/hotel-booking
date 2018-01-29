package org.teipir.ml.booking.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.teipir.ml.booking.models.Booking;
import org.teipir.ml.booking.models.Database;

public class RoomBookController {
	public class ConfirmButton implements ActionListener {
		private Booking b;
		private JTextField nameField;
		private JTextField surnameField;
		private JTextField telephoneField;
		private JTextField creditField;
		JFrame frame;
		public ConfirmButton(Booking b,JTextField nameField, JTextField surnameField, JTextField telephoneField, JTextField creditField,JFrame f) {
			this.b = b;
			this.nameField = nameField;
			this.surnameField = surnameField;
			this.telephoneField = telephoneField;
			this.creditField = creditField;
			this.frame = f;
		}

		public void actionPerformed(ActionEvent arg0) {
			b.setTelephone(telephoneField.getText());
			b.setSurname(surnameField.getText());
			b.setName(nameField.getText());
			b.setCreditCard(creditField.getText());
			
			System.out.println(b.toQuery());
			if	(!Database.bookRoom(b)) {
				JOptionPane.showMessageDialog(null, "Υπήρξε ένα εσωτερικό πρόβλημα... Παρακαλώ προσπαθήστε ξανά");
			}
			else {
				JOptionPane.showMessageDialog(null, "Η κράτηση πραγματοποιήθηκε με επιτυχία. Σας ευχαριστούμε πολύ!");
				frame.setVisible(false);
			}
			
		}
		
	}
}
