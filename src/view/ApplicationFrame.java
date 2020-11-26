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
		csapatKezeles = new JMenu("Csapatok Kezelése");
		tagKezeles = new JMenu("Tagok Kezelése");

		menupont = new JMenuItem[7];
		JMenu submenuTeams = new JMenu("Csapat adatok");
		menupont[0] = new JMenuItem("Csapat felvétele");		
		menupont[1] = new JMenuItem("Általános információ");	
		menupont[2] = new JMenuItem("Csapat törlése");
		menupont[3] = new JMenuItem("Tag felvétele");
		menupont[4] = new JMenuItem("Tagok listázása");
		menupont[5] = new JMenuItem("Tagokhoz tartozó csapatok");
		menupont[6] = new JMenuItem("Csapat tagjainak módosítása");

		

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

		
		setJMenuBar(menubar); // Beállítja a frame menübárját.

	}

	public ApplicationFrame() {
		super("GoSport - Sportegyesület Nyilvántartó");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1280, 550));
		setLayout(new BorderLayout());

		top = new JPanel();
		center = new JPanel();
		bottom = new JPanel();
		
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		JLabel welcomeText = new JLabel("Üdvözlünk a GoSport nyilvántartóban!");
		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		welcomeText.setForeground(Color.orange);
		welcomeText.setFont(welcomeFont);

		top.add(welcomeText);
		
		JLabel paragraph1 = new JLabel("A program segítségével lehetséges kézi, kosár és focicsapatok, valamint tagok adatait kezelni. ");
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

	//Visszaállítja a layoutot a kezdeti, üres állapotba
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
	 * // Megnézzük, hogy melyik gombot nyomták meg switch
	 * (actionEvent.getActionCommand()) { case "Csapatok kilistázása":
	 * listTeam.displayListTeam(); break; case "Csapat felvétele":
	 * newTeam.displayChooseSport(); break;
	 * 
	 * case "Tag felvétele": newMember.displayNewMemberUI(); break; case
	 * "Tagok listázása": listMembers.displayListMembersUI(); break; case
	 * "Labdarugás": newTeam.displayFootball(); break; case "Kosárlabda":
	 * newTeam.displayBasketball(); break; case "tovabbNewMember": break; case
	 * "tovabbNewTeam": break; case "stage1": newTeam.displayChooseSport(); break;
	 * case "Súgó": System.out.println("most"); displaySugo(); break; } } }
	 */

}
