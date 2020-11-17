package view;
import java.awt.*;

import javax.swing.*;

public class ApplicationFrame extends JFrame{
	JMenu csapatKezeles;  
	JMenu tagKezeles;  
	JMenu sugo;  
    JMenuItem i1, i2, i3, i4, i5;  
	
	public ApplicationFrame() {
		super("GoSport - Sportegyes�let Nyilv�ntart�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(820,490);  
		this.setLayout(new BorderLayout());
		
	
		JMenuBar menubar=new JMenuBar();  
        csapatKezeles=new JMenu("Csapatok Kezel�se");  
        tagKezeles=new JMenu("Tagok Kezel�se");         
        
        sugo = new JMenu("S�g�");       
           
        i1=new JMenuItem("Csapat felv�tele");  
        i2=new JMenuItem("Csapatok kilist�z�sa");  
        i3=new JMenuItem("Tag felv�tele");  
        i4=new JMenuItem("Tagok list�z�sa");  
        i5=new JMenuItem("Item 5");  
        
        csapatKezeles.add(i1); csapatKezeles.add(i2); tagKezeles.add(i3);  
        tagKezeles.add(i4); 
 
        menubar.add(csapatKezeles);  
        menubar.add(tagKezeles);  
        
        menubar.add(Box.createHorizontalGlue()); //A s�g� men�pont miatt kell, hogy jobb oldalra ker�lj�n
        
        menubar.add(sugo);
        setJMenuBar(menubar); //Be�ll�tja a frame men�b�rj�t.
        
       
        
        
        
        
		
		setVisible(true);
		
	}
	
}
