package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;


public class NewTeamFrame extends JFrame{
	
	private JLabel text;
	
	private void initComponents() {
		this.setLayout(new BorderLayout());
		
		JPanel top =new JPanel();
		add(top, BorderLayout.NORTH);
		
		setMinimumSize(new Dimension(500, 200));
		
		text = new JLabel("Új csapat létrehozása");
		top.add(text);
	}
	
	public NewTeamFrame(){
		initComponents();
	}

}
