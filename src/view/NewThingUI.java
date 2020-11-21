package view;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;


//azon osztályok õse, amik valamilyen menüpontot jelenítenek meg, ahol új dolgot lehet felvinni a nyilvántartásba
public abstract class NewThingUI {
	protected JPanel top, bottom, center;
	protected ApplicationFrame frame; //kompozíció
	
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
		
		tovabb = new JButton("Tovább");
		vissza = new JButton("Vissza");
	}
	
	protected void setComponentsVisible() {
		Component[] componentsCenter = center.getComponents();
		Component[] componentsTop = top.getComponents();
		Component[] componentsBottom = bottom.getComponents();

		for (int i = 0; i < componentsCenter.length; i++) {
			componentsCenter[i].setVisible(true); //Láthatóvá tesszük a gombokat. Azért van erre szükség, mert a removeOldComponets() a gombok láthatóságát false-ra álítja.
		}
		for (int i = 0; i < componentsTop.length; i++) {
			componentsTop[i].setVisible(true); //Láthatóvá tesszük a gombokat. Azért van erre szükség, mert a removeOldComponets() a gombok láthatóságát false-ra álítja.
		}
		for (int i = 0; i < componentsBottom.length; i++) {
			componentsBottom[i].setVisible(true); //Láthatóvá tesszük a gombokat. Azért van erre szükség, mert a removeOldComponets() a gombok láthatóságát false-ra álítja.
		}
	}
	
	protected void fantomPanel(int db, JPanel panel) {
		JPanel[] unvisibleComponent = new JPanel[db]; // fantom panelek, hogy normálisan nézzen ki a felület
		for (JPanel temp : unvisibleComponent) {
			temp = new JPanel();
			panel.add(temp);
		}
	}
}
