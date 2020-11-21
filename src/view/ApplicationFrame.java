package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ApplicationFrame extends JFrame {
	JLabel cim;
	JMenu csapatKezeles;
	JMenu tagKezeles;
	JMenu sugo;
	JMenuItem[] menupont;
	JPanel top, center, bottom;
	GridBagConstraints gbc;
	NewTeamUI newTeam;
	ListTeamUI listTeam;
	NewMemberUI newMember;
	ListMembersUI listMembers;

	void initMenu() {
		JMenuBar menubar = new JMenuBar();
		csapatKezeles = new JMenu("Csapatok Kezelése");
		tagKezeles = new JMenu("Tagok Kezelése");
		sugo = new JMenu("Súgó");
		MenuActionListener menuBtnListener = new MenuActionListener();

		menupont = new JMenuItem[4];
		menupont[0] = new JMenuItem("Csapat felvétele");
		menupont[1] = new JMenuItem("Csapatok kilistázása");
		menupont[2] = new JMenuItem("Tag felvétele");
		menupont[3] = new JMenuItem("Tagok listázása");
		
		for (int i = 0; i < menupont.length; i++) {
			menupont[i].addActionListener(menuBtnListener); // ActionListener az összes menüpontra
		}

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

	public void listTeamUI() {

	}

	public ApplicationFrame() {
		super("GoSport - Sportegyesület Nyilvántartó");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 400));
		setLayout(new BorderLayout(40, 40));

		top = new JPanel();
		center = new JPanel();
		bottom = new JPanel();

		JLabel welcomeText = new JLabel("Üdvözünk a GoSport nyilvántartóban!");
		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		welcomeText.setForeground(Color.orange);
		welcomeText.setFont(welcomeFont);

		top.add(welcomeText);

		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		newTeam = new NewTeamUI(this, top, center, bottom, new MenuActionListener());    
		listTeam = new ListTeamUI(this, top, center);
		newMember = new NewMemberUI(this, top, center, bottom, new MenuActionListener());
		listMembers = new ListMembersUI(this, top, center);

		initMenu();
	}
	
	private void displaySugo() {
		JLabel sugoText = new JLabel("teszt");
		center.add(sugoText);
	}

	public class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Component[] componentsTop = top.getComponents();
			Component[] componentsCenter = center.getComponents();

			for (int i = 0; i < componentsCenter.length; i++) {
				componentsCenter[i].setVisible(false);
			}

			for (int i = 0; i < componentsTop.length; i++) {
				componentsTop[i].setVisible(false);
			}

			top.removeAll();
			center.removeAll();
			
			System.out.println(actionEvent.getActionCommand());

			// Megnézzük, hogy melyik gombot nyomták meg
			switch (actionEvent.getActionCommand()) {
			case "Csapatok kilistázása":
				listTeam.displayListTeam();
				break;
			case "Csapat felvétele":
				newTeam.displayChooseSport();
				break;

			case "Tag felvétele":
				newMember.displayNewMemberUI();
				break;
			case "Tagok listázása":
				listMembers.displayListMembersUI();
				break;
			case "Labdarugás":
				newTeam.displayFootball();
				break;
			case "Kosárlabda":
				newTeam.displayBasketball();
				break;
			case "tovabbNewMember":
				break;
			case "tovabbNewTeam":
				break;
			case "stage1":
				newTeam.displayChooseSport();
				break;
			case "Súgó":
				System.out.println("most");
				displaySugo();
				break;
			}
		}
	}

}
