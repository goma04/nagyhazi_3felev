package view;

import javax.swing.JOptionPane;

public class PopUpMessage {
	
	public PopUpMessage(String infoMessage, int type) {
		JOptionPane.showMessageDialog(null, infoMessage, "Információ", type);
	}
}
