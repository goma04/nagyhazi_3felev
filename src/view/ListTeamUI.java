package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListTeamUI {
	private JPanel top, bottom, center;
	protected ApplicationFrame frame;
	
	public ListTeamUI(ApplicationFrame frame){
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.bottom = frame.getBottom();
	}

	public void displayListTeam() {
		frame.removeOldComponents();	
		frame.setTitle("Csapatok Adatai");

		JLabel text = new JLabel("Csapat törlése");

		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		text.setForeground(Color.red);
		text.setFont(welcomeFont);

		top.add(text); //top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel
	}
}
