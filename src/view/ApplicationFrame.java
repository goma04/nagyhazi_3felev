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
		csapatKezeles = new JMenu("Csapatok Kezel�se");
		tagKezeles = new JMenu("Tagok Kezel�se");
		sugo = new JMenu("S�g�");
		MenuActionListener menuBtnListener = new MenuActionListener();

		menupont = new JMenuItem[6];
		menupont[0] = new JMenuItem("Csapat felv�tele");
		menupont[1] = new JMenuItem("Csapatok kilist�z�sa");
		menupont[2] = new JMenuItem("Tag felv�tele");
		menupont[3] = new JMenuItem("Tagok list�z�sa");
		menupont[4] = new JMenuItem("Item 5");
		menupont[5] = new JMenuItem("S�g�");

		for (int i = 0; i < menupont.length; i++) {
			menupont[i].addActionListener(menuBtnListener); // ActionListener az �sszes men�pontra
		}

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

	public void createNewTeamUI() {
		setTitle("Csapat felv�tele");

		JLabel text = new JLabel("V�lassz a sport�gak k�z�l!");

		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		text.setForeground(Color.orange);
		text.setFont(welcomeFont);

		top.add(text);
		top.validate(); // Friss�tj�k a tartalmat ezzel a f�ggv�nnyel

		// center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); //Hogy ne
		// l�gjon r� a sz�l�re
		/*
		 * center.setLayout(new GridLayout(1, 3, 0, 0)); center.add(new
		 * JButton("Labdarug�s")); center.add(new JButton("K�zilabda")); center.add(new
		 * JButton("Kos�rlabda")); center.validate();
		 */
	}

	public void listTeamUI() {
		// cim.setText("Csapatok Adatai");

		JLabel text = new JLabel("Csapat t�rl�se");

		Font welcomeFont = new Font("serif", Font.PLAIN, 40);
		text.setForeground(Color.red);
		text.setFont(welcomeFont);

		top.add(text);
	}

	public ApplicationFrame() {
		super("GoSport - Sportegyes�let Nyilv�ntart�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 400));
		setLayout(new BorderLayout(40, 40));

		top = new JPanel();
		center = new JPanel();

		JLabel welcomeText = new JLabel("�dv�z�nk a GoSport nyilv�ntart�ban!");
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

			// Megn�zz�k, hogy melyik gombot nyomt�k meg
			if (actionEvent.getActionCommand() == "Csapatok kilist�z�sa") {
				listTeamUI();

			}
			if (actionEvent.getActionCommand() == "Csapat felv�tele") {
				createNewTeamUI();
			}
		}
	}

}
