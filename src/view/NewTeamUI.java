package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.ApplicationFrame.MenuActionListener;

public class NewTeamUI extends NewThingUI {
	private JButton foci;
	private JButton kosar;
	private JButton kezi;
	private JTextField coach1, coach2, girlNumber, leaderName, annualSponsorship;

	
	
	
	public NewTeamUI(ApplicationFrame frame) {
		super(frame);
		
		foci = new JButton("Labdarugás");
		kosar = new JButton("Kosárlabda");
		kezi = new JButton("Kézilabda");
		coach1 = new JTextField();
		coach2 = new JTextField();
		girlNumber = new JTextField();
		leaderName = new JTextField();
		annualSponsorship = new JTextField();
	}	

	//Megjeleníti azt a menüpontot, ahol ki kell választani a sportágat
	public void displayChooseSport() {
		frame.removeOldComponents();		
		frame.setTitle("Csapat felvétele");
		
		
		System.out.println("displayChooseSport");

		top.add(new JLabel("Válassz a sportágak közül!"));
		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // Hogy ne lógjon rá a szélére
		center.setLayout(new GridLayout(1, 3, 10, 10));
		center.add(foci);
		center.add(kezi);
		center.add(kosar);
		
		setComponentsVisible();
		center.validate();		
	}

	
	// Új focicsapat felvételekor megjeleníti a szükséges elemeket
	public void displayFootball() {
		frame.removeOldComponents();		
		
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
		

		
		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatválasztóba kell visszalépni
		bottomButtons();
		top.validate();
		center.validate();
		bottom.validate();
		frame.pack();
	}

	// Új kosárlabda csapat felvételekor megjeleníti a szükséges elemeket
	public void displayBasketball() {
		frame.removeOldComponents();		

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

		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatválasztóba kell visszalépni
		bottomButtons();
		top.validate();
		center.validate();
		bottom.validate();
		frame.pack();
	}
	
	
	public void displayHandball() {
		frame.removeOldComponents();				

		top.add(new JLabel("Adja meg a csapat adatait!"));

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		center.setLayout(new GridLayout(5, 2, 10, 10));

	
		

		fantomPanel(2, center);
		center.add(new JLabel("Évi támogatás mértéke: "));
		center.add(annualSponsorship);
		fantomPanel(2, center);
		

		
		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatválasztóba kell visszalépni
		bottomButtons();
		top.validate();
		center.validate();
		bottom.validate();
		frame.pack();
	}
	
	
	public JButton getFoci() {
		return foci;
	}

	public void setFoci(JButton foci) {
		this.foci = foci;
	}

	public JButton getKosar() {
		return kosar;
	}

	public void setKosar(JButton kosar) {
		this.kosar = kosar;
	}

	public JButton getKezi() {
		return kezi;
	}

	public void setKezi(JButton kezi) {
		this.kezi = kezi;
	}

	public JTextField getCoach1() {
		return coach1;
	}

	public void setCoach1(JTextField coach1) {
		this.coach1 = coach1;
	}

	public JTextField getCoach2() {
		return coach2;
	}

	public void setCoach2(JTextField coach2) {
		this.coach2 = coach2;
	}

	public JTextField getGirlNumber() {
		return girlNumber;
	}

	public void setGirlNumber(JTextField girlNumber) {
		this.girlNumber = girlNumber;
	}

	public JTextField getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(JTextField leaderName) {
		this.leaderName = leaderName;
	}
	

}
