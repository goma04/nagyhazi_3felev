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
	

	//Megjeleníti azt a menüpontot, ahol ki kell választani a sportágat
	public void displayChooseSport() {
		frame.setTitle("Csapat felvétele");

		top.add(new JLabel("Válassz a sportágak közül!"));
		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // Hogy ne lógjon rá a szélére

		JButton foci = new JButton("Labdarugás");
		foci.addActionListener(al);
		JButton kosar = new JButton("Kosárlabda");
		kosar.addActionListener(al);
		JButton kezi = new JButton("Kézilabda");
		kezi.addActionListener(al);

		center.setLayout(new GridLayout(1, 3, 10, 10));
		center.add(foci);
		center.add(kezi);
		center.add(kosar);
		center.validate();
		
	}

	// Új focicsapat felvételekor megjeleníti a szükséges elemeket
	public void displayFootball() {
		System.out.println("displayFootball()");
		JTextField coach1 = new JTextField();
		JTextField coach2 = new JTextField();

		top.add(new JLabel("Adja meg a csapat adatait!"));

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		center.setLayout(new GridLayout(5, 2, 10, 10));

		center.add(new JLabel("1. edzõ neve: "));
		center.add(coach1);
		center.add(new JLabel("2. edzõ neve: "));
		center.add(coach2);

		JPanel[] unvisibleComponent = new JPanel[5]; // fantom panelek, hogy normálisan nézzen ki a felület
		for (JPanel panel : unvisibleComponent) {
			panel = new JPanel();
			center.add(panel);
		}

		
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatválasztóba kell visszalépni
		bottomButtons();
	}

	// Új kosárlabda csapat felvételekor megjeleníti a szükséges elemeket
	public void displayBasketball() {
		JTextField girlNumber = new JTextField();
		JTextField leaderName = new JTextField();

		top.add(new JLabel("Adja meg a csapat adatait!"));

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		center.setLayout(new GridLayout(5, 2, 10, 10));

		center.add(new JLabel("Pompom lányok létszáma: "));
		center.add(girlNumber);
		center.add(new JLabel("Pompom lányok vezetõjének a neve: "));
		center.add(leaderName);

		JPanel[] unvisibleComponent = new JPanel[5]; // fantom panelek, hogy normálisan nézzen ki a felület
		for (JPanel panel : unvisibleComponent) {
			panel = new JPanel();
			center.add(panel);
		}

		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatválasztóba kell visszalépni
		bottomButtons();
	}

}
