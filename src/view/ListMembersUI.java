package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListMembersUI {
	private JPanel top;
	private JPanel center;
	private JFrame frame;
	
	public ListMembersUI(JFrame frame, JPanel top, JPanel center){
		this.frame = frame;
		this.top = top;
		this.center = center;
	}
	
	public void displayListMembersUI() {
		frame.setTitle("Tagok adatai");
		

		JLabel text = new JLabel("Tagok Adatai");

		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		text.setForeground(Color.MAGENTA);
		text.setFont(welcomeFont);

		top.add(text); //top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel
	}
}