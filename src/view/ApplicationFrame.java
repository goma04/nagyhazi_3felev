package view;
import java.awt.*;

import javax.swing.*;

public class ApplicationFrame extends JFrame{
	JMenu csapatKezeles;  
	JMenu tagKezeles;  
	JMenu sugo;  
    JMenuItem i1, i2, i3, i4, i5;  
	
	public ApplicationFrame() {
		super("GoSport - Sportegyesület Nyilvántartó");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(820,490);  
		this.setLayout(new BorderLayout());
		
	
		JMenuBar menubar=new JMenuBar();  
        csapatKezeles=new JMenu("Csapatok Kezelése");  
        tagKezeles=new JMenu("Tagok Kezelése");         
        
        sugo = new JMenu("Súgó");       
           
        i1=new JMenuItem("Csapat felvétele");  
        i2=new JMenuItem("Csapatok kilistázása");  
        i3=new JMenuItem("Tag felvétele");  
        i4=new JMenuItem("Tagok listázása");  
        i5=new JMenuItem("Item 5");  
        
        csapatKezeles.add(i1); csapatKezeles.add(i2); tagKezeles.add(i3);  
        tagKezeles.add(i4); 
 
        menubar.add(csapatKezeles);  
        menubar.add(tagKezeles);  
        
        menubar.add(Box.createHorizontalGlue()); //A súgó menüpont miatt kell, hogy jobb oldalra kerüljön
        
        menubar.add(sugo);
        setJMenuBar(menubar); //Beállítja a frame menübárját.
        
       
        
        
        
        
		
		setVisible(true);
		
	}
	
}
