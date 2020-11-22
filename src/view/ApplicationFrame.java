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
		sugo = new JMenu("S�g�");
		// MenuActionListener menuBtnListener = new MenuActionListener();

		menupont = new JMenuItem[4];
		menupont[0] = new JMenuItem("Csapat felv�tele");
		menupont[1] = new JMenuItem("Csapatok kilist�z�sa");
		menupont[2] = new JMenuItem("Tag felv�tele");
		menupont[3] = new JMenuItem("Tagok list�z�sa");

		for (int i = 0; i < menupont.length; i++) {
			// menupont[i].addActionListener(menuBtnListener); // ActionListener az �sszes
			// men�pontra
		}

		// menupont[0].addActionListener(e->System.out.println("listener triggered"));

		csapatKezeles.add(menupont[0]);
		csapatKezeles.add(menupont[1]);
		tagKezeles.add(menupont[2]);
		tagKezeles.add(menupont[3]);

		menubar.add(csapatKezeles);
		menubar.add(tagKezeles);

		menubar.add(Box.createHorizontalGlue()); // A s�g� men�pont miatt kell, hogy jobb oldalra ker�lj�n

		menubar.add(sugo);
		setJMenuBar(menubar); // Be�ll�tja a frame men�b�rj�t.

	}

	public ApplicationFrame() {
		super("GoSport - Sportegyes�let Nyilv�ntart�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 400));
		setLayout(new BorderLayout());

		top = new JPanel();
		center = new JPanel();
		bottom = new JPanel();
		
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		JLabel welcomeText = new JLabel("�dv�z�nk a GoSport nyilv�ntart�ban!");
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
