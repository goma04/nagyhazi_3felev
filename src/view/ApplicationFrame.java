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
		sugo = new JMenu("Súgó");
		// MenuActionListener menuBtnListener = new MenuActionListener();

		menupont = new JMenuItem[4];
		menupont[0] = new JMenuItem("Csapat felvétele");
		menupont[1] = new JMenuItem("Csapatok kilistázása");
		menupont[2] = new JMenuItem("Tag felvétele");
		menupont[3] = new JMenuItem("Tagok listázása");

		for (int i = 0; i < menupont.length; i++) {
			// menupont[i].addActionListener(menuBtnListener); // ActionListener az összes
			// menüpontra
		}

		// menupont[0].addActionListener(e->System.out.println("listener triggered"));

		csapatKezeles.add(menupont[0]);
		csapatKezeles.add(menupont[1]);
		tagKezeles.add(menupont[2]);
		tagKezeles.add(menupont[3]);

		menubar.add(csapatKezeles);
		menubar.add(tagKezeles);

		menubar.add(Box.createHorizontalGlue()); // A súgó menüpont miatt kell, hogy jobb oldalra kerüljön

		menubar.add(sugo);
		setJMenuBar(menubar); // Beállítja a frame menübárját.

	}

	public ApplicationFrame() {
		super("GoSport - Sportegyesület Nyilvántartó");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 400));
		setLayout(new BorderLayout());

		top = new JPanel();
		center = new JPanel();
		bottom = new JPanel();
		
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		JLabel welcomeText = new JLabel("Üdvözünk a GoSport nyilvántartóban!");
		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		welcomeText.setForeground(Color.orange);
		welcomeText.setFont(welcomeFont);

		top.add(welcomeText);
		

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
