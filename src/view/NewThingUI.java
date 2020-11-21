package view;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;


//azon oszt�lyok �se, amik valamilyen men�pontot jelen�tenek meg, ahol �j dolgot lehet felvinni a nyilv�ntart�sba
public abstract class NewThingUI {
	protected JPanel top, bottom, center;
	protected ApplicationFrame frame; //kompoz�ci�
	
	public JButton getTovabb() {
		return tovabb;
	}

	public void setTovabb(JButton tovabb) {
		this.tovabb = tovabb;
	}

	public JButton getVissza() {
		return vissza;
	}

	public void setVissza(JButton vissza) {
		this.vissza = vissza;
	}

	protected JButton tovabb, vissza;
	
	protected void bottomButtons() {		
		bottom.add(vissza);
		bottom.add(tovabb);
		vissza.setVisible(true);
		tovabb.setVisible(true);
	}

	public NewThingUI(ApplicationFrame frame) {
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.bottom = frame.getBottom();
		
		tovabb = new JButton("Tov�bb");
		vissza = new JButton("Vissza");
	}
	
	protected void setComponentsVisible() {
		Component[] componentsCenter = center.getComponents();
		Component[] componentsTop = top.getComponents();
		Component[] componentsBottom = bottom.getComponents();

		for (int i = 0; i < componentsCenter.length; i++) {
			componentsCenter[i].setVisible(true); //L�that�v� tessz�k a gombokat. Az�rt van erre sz�ks�g, mert a removeOldComponets() a gombok l�that�s�g�t false-ra �l�tja.
		}
		for (int i = 0; i < componentsTop.length; i++) {
			componentsTop[i].setVisible(true); //L�that�v� tessz�k a gombokat. Az�rt van erre sz�ks�g, mert a removeOldComponets() a gombok l�that�s�g�t false-ra �l�tja.
		}
		for (int i = 0; i < componentsBottom.length; i++) {
			componentsBottom[i].setVisible(true); //L�that�v� tessz�k a gombokat. Az�rt van erre sz�ks�g, mert a removeOldComponets() a gombok l�that�s�g�t false-ra �l�tja.
		}
	}
	
	protected void fantomPanel(int db, JPanel panel) {
		JPanel[] unvisibleComponent = new JPanel[db]; // fantom panelek, hogy norm�lisan n�zzen ki a fel�let
		for (JPanel temp : unvisibleComponent) {
			temp = new JPanel();
			panel.add(temp);
		}
	}
}
