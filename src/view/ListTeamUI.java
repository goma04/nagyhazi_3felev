package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListTeamUI {
	private JPanel top;
	private JPanel center;
	private JFrame frame;
	
	public ListTeamUI(JFrame frame, JPanel top, JPanel center){
		this.frame = frame;
		this.top = top;
		this.center = center;
	}

	public void displayListTeam() {
		frame.setTitle("Csapatok Adatai");

		JLabel text = new JLabel("Csapat törlése");

		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		text.setForeground(Color.red);
		text.setFont(welcomeFont);

		top.add(text); //top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel
	}
}
