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
		
		foci = new JButton("Labdarug�s");
		kosar = new JButton("Kos�rlabda");
		kezi = new JButton("K�zilabda");
		coach1 = new JTextField();
		coach2 = new JTextField();
		girlNumber = new JTextField();
		leaderName = new JTextField();
		annualSponsorship = new JTextField();
	}	

	//Megjelen�ti azt a men�pontot, ahol ki kell v�lasztani a sport�gat
	public void displayChooseSport() {
		frame.removeOldComponents();		
		frame.setTitle("Csapat felv�tele");
		
		
		System.out.println("displayChooseSport");

		top.add(new JLabel("V�lassz a sport�gak k�z�l!"));
		top.validate(); // Friss�tj�k a tartalmat ezzel a f�ggv�nnyel

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // Hogy ne l�gjon r� a sz�l�re
		center.setLayout(new GridLayout(1, 3, 10, 10));
		center.add(foci);
		center.add(kezi);
		center.add(kosar);
		
		setComponentsVisible();
		center.validate();		
	}

	
	// �j focicsapat felv�telekor megjelen�ti a sz�ks�ges elemeket
	public void displayFootball() {
		frame.removeOldComponents();		
		
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
		

		
		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatv�laszt�ba kell visszal�pni
		bottomButtons();
		top.validate();
		center.validate();
		bottom.validate();
		frame.pack();
	}

	// �j kos�rlabda csapat felv�telekor megjelen�ti a sz�ks�ges elemeket
	public void displayBasketball() {
		frame.removeOldComponents();		

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

		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatv�laszt�ba kell visszal�pni
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
		center.add(new JLabel("�vi t�mogat�s m�rt�ke: "));
		center.add(annualSponsorship);
		fantomPanel(2, center);
		

		
		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); //innen a csapatv�laszt�ba kell visszal�pni
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
