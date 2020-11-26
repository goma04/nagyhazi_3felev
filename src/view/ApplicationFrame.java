package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ApplicationFrame extends JFrame {
	JMenu csapatKezeles;
	JMenu tagKezeles;
	JMenu sugo;
	JMenuItem[] menupont;
	JPanel top, center, bottom;

	private void initMenu() {
		JMenuBar menubar = new JMenuBar();
		csapatKezeles = new JMenu("Csapatok Kezel�se");
		tagKezeles = new JMenu("Tagok Kezel�se");

		menupont = new JMenuItem[7];
		JMenu submenuTeams = new JMenu("Csapat adatok");
		menupont[0] = new JMenuItem("Csapat felv�tele");		
		menupont[1] = new JMenuItem("�ltal�nos inform�ci�");	
		menupont[2] = new JMenuItem("Csapat t�rl�se");
		menupont[3] = new JMenuItem("Tag felv�tele");
		menupont[4] = new JMenuItem("Tagok list�z�sa");
		menupont[5] = new JMenuItem("Tagokhoz tartoz� csapatok");
		menupont[6] = new JMenuItem("Csapat tagjainak m�dos�t�sa");

		

		csapatKezeles.add(menupont[0]);
		csapatKezeles.add(menupont[2]);
		csapatKezeles.add(submenuTeams);		
		submenuTeams.add(menupont[1]);
		submenuTeams.add(menupont[6]);
		
		
		tagKezeles.add(menupont[3]);
		tagKezeles.add(menupont[4]);
		tagKezeles.add(menupont[5]);

		menubar.add(csapatKezeles);
		menubar.add(tagKezeles);

		
		setJMenuBar(menubar); // Be�ll�tja a frame men�b�rj�t.

	}

	public ApplicationFrame() {
		super("GoSport - Sportegyes�let Nyilv�ntart�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1280, 550));
		setLayout(new BorderLayout());

		top = new JPanel();
		center = new JPanel();
		bottom = new JPanel();
		
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		JLabel welcomeText = new JLabel("�dv�zl�nk a GoSport nyilv�ntart�ban!");
		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		welcomeText.setForeground(Color.orange);
		welcomeText.setFont(welcomeFont);

		top.add(welcomeText);
		
		JLabel paragraph1 = new JLabel("A program seg�ts�g�vel lehets�ges k�zi, kos�r �s focicsapatok, valamint tagok adatait kezelni. ");
		center.add(paragraph1);
		
		
		
		System.out.println("AplicationFrameCtor");
		initMenu();
	}

	public JMenuItem[] getMenuItems() {
		return menupont;
	}

	public JPanel getTop() {
		return top;
	}

	public void setTop(JPanel top) {
		this.top = top;
	}

	public JPanel getCenter() {
		return center;
	}

	public void setCenter(JPanel center) {
		this.center = center;
	}

	public JPanel getBottom() {
		return bottom;
	}

	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}

	//Vissza�ll�tja a layoutot a kezdeti, �res �llapotba
	public void removeOldComponents() {
		Component[] componentsTop = top.getComponents();
		Component[] componentsCenter = center.getComponents();
		Component[] componentsBottom = bottom.getComponents();
		
		
		getContentPane().removeAll();
		repaint();

		for (int i = 0; i < componentsCenter.length; i++) {
			componentsCenter[i].setVisible(false);
		}

		for (int i = 0; i < componentsBottom.length; i++) {
			componentsBottom[i].setVisible(false);
		}

		for (int i = 0; i < componentsTop.length; i++) {
			componentsTop[i].setVisible(false);
		}

		top.removeAll();
		center.removeAll();
		bottom.removeAll();
		center.setLayout(new BorderLayout());
		
		
		setLayout(new BorderLayout());
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		

	}

	/*
	 * private void displaySugo() { JLabel sugoText = new JLabel("teszt");
	 * center.add(sugoText); }
	 */

	/*
	 * public class MenuActionListener implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent actionEvent) { Component[]
	 * componentsTop = top.getComponents(); Component[] componentsCenter =
	 * center.getComponents();
	 * 
	 * for (int i = 0; i < componentsCenter.length; i++) {
	 * componentsCenter[i].setVisible(false); }
	 * 
	 * for (int i = 0; i < componentsTop.length; i++) {
	 * componentsTop[i].setVisible(false); }
	 * 
	 * top.removeAll(); center.removeAll();
	 * 
	 * System.out.println(actionEvent.getActionCommand());
	 * 
	 * // Megn�zz�k, hogy melyik gombot nyomt�k meg switch
	 * (actionEvent.getActionCommand()) { case "Csapatok kilist�z�sa":
	 * listTeam.displayListTeam(); break; case "Csapat felv�tele":
	 * newTeam.displayChooseSport(); break;
	 * 
	 * case "Tag felv�tele": newMember.displayNewMemberUI(); break; case
	 * "Tagok list�z�sa": listMembers.displayListMembersUI(); break; case
	 * "Labdarug�s": newTeam.displayFootball(); break; case "Kos�rlabda":
	 * newTeam.displayBasketball(); break; case "tovabbNewMember": break; case
	 * "tovabbNewTeam": break; case "stage1": newTeam.displayChooseSport(); break;
	 * case "S�g�": System.out.println("most"); displaySugo(); break; } } }
	 */

}
