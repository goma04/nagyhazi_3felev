package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//azon oszt�lyok �se, amik valamilyen men�pontot jelen�tenek meg, ahol �j dolgot lehet felvinni a nyilv�ntart�sba
public abstract class NewThingUI {
	protected JPanel top;
	protected JPanel center;
	protected JFrame frame;
	protected JPanel bottom;
	protected ActionListener al;
	protected JButton tovabb, vissza;
	
	protected void bottomButtons() {
		
		tovabb.addActionListener(al);
		vissza.addActionListener(al);
		
		bottom.add(vissza);
		bottom.add(tovabb);
	}

	public NewThingUI(JFrame frame, JPanel top, JPanel center, JPanel bottom, ActionListener al) {
		this.frame = frame;
		this.top = top;
		this.center = center;
		this.al = al;
		this.bottom = bottom;
		
		tovabb = new JButton("Tov�bb");
		vissza = new JButton("Vissza");
	}
}
