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

	void initMenu() {
		JMenuBar menubar = new JMenuBar();
		csapatKezeles = new JMenu("Csapatok Kezelése");
		tagKezeles = new JMenu("Tagok Kezelése");
		sugo = new JMenu("Súgó");
		MenuActionListener menuBtnListener = new MenuActionListener();

		menupont = new JMenuItem[6];
		menupont[0] = new JMenuItem("Csapat felvétele");
		menupont[1] = new JMenuItem("Csapatok kilistázása");
		menupont[2] = new JMenuItem("Tag felvétele");
		menupont[3] = new JMenuItem("Tagok listázása");
		menupont[4] = new JMenuItem("Item 5");
		menupont[5] = new JMenuItem("Súgó");

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

	public void createNewTeamUI() {
		setTitle("Csapat felvétele");

		JLabel text = new JLabel("Válassz a sportágak közül!");

		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		text.setForeground(Color.orange);
		text.setFont(welcomeFont);

		top.add(text);
		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		// center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); //Hogy ne
		// lógjon rá a szélére
		/*
		 * center.setLayout(new GridLayout(1, 3, 0, 0)); center.add(new
		 * JButton("Labdarugás")); center.add(new JButton("Kézilabda")); center.add(new
		 * JButton("Kosárlabda")); center.validate();
		 */
	}

	public void listTeamUI() {
		// cim.setText("Csapatok Adatai");

		JLabel text = new JLabel("Csapat törlése");

		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		text.setForeground(Color.red);
		text.setFont(welcomeFont);

		top.add(text);
	}

	public ApplicationFrame() {
		super("GoSport - Sportegyesület Nyilvántartó");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 400));
		setLayout(new BorderLayout(40, 40));

		top = new JPanel();
		center = new JPanel();

		JLabel welcomeText = new JLabel("Üdvözünk a GoSport nyilvántartóban!");
		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		welcomeText.setForeground(Color.orange);
		welcomeText.setFont(welcomeFont);

		top.add(welcomeText);

		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);

		initMenu();
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

			// Megnézzük, hogy melyik gombot nyomták meg
			if (actionEvent.getActionCommand() == "Csapatok kilistázása") {
				listTeamUI();

			}
			if (actionEvent.getActionCommand() == "Csapat felvétele") {
				createNewTeamUI();
			}
		}
	}

}
