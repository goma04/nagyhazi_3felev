package view;

import java.awt.Component;

import javax.swing.JPanel;


public class UI {
	protected JPanel top, bottom, center;
	protected  ApplicationFrame frame;
	
	public UI(ApplicationFrame frame) {
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.bottom = frame.getBottom();
	}
	
	protected void fantomPanel(int db, JPanel panel) {
		JPanel[] unvisibleComponent = new JPanel[db]; // fantom panelek, hogy norm�lisan n�zzen ki a fel�let
		for (JPanel temp : unvisibleComponent) {
			temp = new JPanel();
			panel.add(temp);
		}
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
}
