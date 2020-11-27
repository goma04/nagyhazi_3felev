package view;


import javax.swing.JButton;



//azon oszt�lyok �se, amik valamilyen men�pontot jelen�tenek meg, ahol �j dolgot lehet felvinni a nyilv�ntart�sba
abstract class NewThingUI extends UI{
	protected JButton tovabb, vissza;
	
	NewThingUI(ApplicationFrame frame) {
		super(frame);
		
		tovabb = new JButton("Tov�bb");
		vissza = new JButton("Vissza");
	}
	
	public JButton getTovabb() {
		return tovabb;
	}	

	public JButton getVissza() {
		return vissza;
	}	
	
	protected void bottomButtons() {				
		bottom.add(vissza);
		bottom.add(tovabb);
		vissza.setVisible(true);
		tovabb.setVisible(true);
	}
	
	
	
	
}
