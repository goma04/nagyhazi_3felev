package view;

import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class ApplicationFrame extends JFrame {
	private JMenu csapatKezeles, tagKezeles;
	private JMenuItem[] menupont;
	private JPanel top, center, bottom;

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
		menupont[6] = new JMenuItem("Csapat tagjainak kezel�se");

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
		
		initMenu();
	}

	public JMenuItem[] getMenuItems() {
		return menupont;
	}

	public JPanel getTop() {
		return top;
	}	

	public JPanel getCenter() {
		return center;
	}	

	public JPanel getBottom() {
		return bottom;
	}	

	//Vissza�ll�tja a layoutot a kezdeti, �res �llapotba
	void removeOldComponents() {
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
}
