package view;

import javax.swing.JOptionPane;

public class PopUpMessage {
	
	public PopUpMessage(String infoMessage) {
		JOptionPane.showMessageDialog(null, infoMessage, "Információ", JOptionPane.INFORMATION_MESSAGE);
	}
}
