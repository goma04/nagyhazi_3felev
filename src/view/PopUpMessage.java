package view;

import javax.swing.JOptionPane;

public class PopUpMessage {
	
	public PopUpMessage(String infoMessage) {
		JOptionPane.showMessageDialog(null, infoMessage, "Inform�ci�", JOptionPane.INFORMATION_MESSAGE);
	}
}
