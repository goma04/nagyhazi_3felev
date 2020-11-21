package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.ApplicationFrame.MenuActionListener;

public class NewTeamUI extends NewThingUI {
	
	public NewTeamUI(JFrame frame, JPanel top, JPanel center, JPanel bottom, ActionListener al) {
		super(frame, top, center, bottom, al);
	}
	

	//Megjelen�ti azt a men�pontot, ahol ki kell v�lasztani a sport�gat
	public void displayChooseSport() {
		frame.setTitle("Csapat felv�tele");

		top.add(new JLabel("V�lassz a sport�gak k�z�l!"));
		top.validate(); // Friss�tj�k a tartalmat ezzel a f�ggv�nnyel

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // Hogy ne l�gjon r� a sz�l�re

		JButton foci = new JButton("Labdarug�s");
		foci.addActionListener(al);
		JButton kosar = new JButton("Kos�rlabda");
		kosar.addActionListener(al);
		JButton kezi = new JButton("K�zilabda");
		kezi.addActionListener(al);

		center.setLayout(new GridLayout(1, 3, 10, 10));
		center.add(foci);
		center.add(kezi);
		center.add(kosar);
		center.validate();
		
	}

	// �j focicsapat felv�telekor megjelen�ti a sz�ks�ges elemeket
	public void displayFootball() {
		System.out.println("displayFootball()");
		JTextField coach1 = new JTextField();
		JTextField coach2 = new JTextField();

		top.add(new JLabel("Adja meg a csapat adatait!"));

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		center.setLayout(new GridLayout(5, 2, 10, 10));

		center.add(new JLabel("1. edz� neve: "));
		center.add(coach1);
		center.add(new JLabel("2. edz� neve: "));
		center.add(coach2);

		JPanel[] unvisibleComponent = new JPanel[5]; // fantom panelek, hogy norm�lisan n�zzen ki a fel�let
		for (JPanel panel : unvisibleComponent) {
			panel = new JPanel();
			center.add(panel);
		}

		
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatv�laszt�ba kell visszal�pni
		bottomButtons();
	}

	// �j kos�rlabda csapat felv�telekor megjelen�ti a sz�ks�ges elemeket
	public void displayBasketball() {
		JTextField girlNumber = new JTextField();
		JTextField leaderName = new JTextField();

		top.add(new JLabel("Adja meg a csapat adatait!"));

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		center.setLayout(new GridLayout(5, 2, 10, 10));

		center.add(new JLabel("Pompom l�nyok l�tsz�ma: "));
		center.add(girlNumber);
		center.add(new JLabel("Pompom l�nyok vezet�j�nek a neve: "));
		center.add(leaderName);

		JPanel[] unvisibleComponent = new JPanel[5]; // fantom panelek, hogy norm�lisan n�zzen ki a fel�let
		for (JPanel panel : unvisibleComponent) {
			panel = new JPanel();
			center.add(panel);
		}

		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatv�laszt�ba kell visszal�pni
		bottomButtons();
	}

}
