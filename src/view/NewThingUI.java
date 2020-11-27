package view;


import javax.swing.JButton;



//azon osztályok õse, amik valamilyen menüpontot jelenítenek meg, ahol új dolgot lehet felvinni a nyilvántartásba
abstract class NewThingUI extends UI{
	protected JButton tovabb, vissza;
	
	NewThingUI(ApplicationFrame frame) {
		super(frame);
		
		tovabb = new JButton("Tovább");
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
