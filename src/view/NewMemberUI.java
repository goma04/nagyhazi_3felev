package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewMemberUI extends NewThingUI{
	
	public NewMemberUI(JFrame frame, JPanel top, JPanel center, JPanel bottom, ActionListener al) {
		super(frame, top, center, bottom, al);
	}
	
	
	public void displayNewMemberUI() {
		frame.setTitle("Tag felvétele");

		JLabel text = new JLabel("Add meg a tag adatait!");

		top.add(text);
		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // Hogy ne lógjon rá a szélére

		center.setLayout(new GridLayout(1, 3, 10, 10));
		center.setLayout(new GridLayout(3, 2, 20, 20));
		
		JTextField fullName = new JTextField();		
		center.add(new JLabel("Teljes név: "));
		center.add(fullName);
		
		
		String sex[] = {"Férfi", "Nõ"};
		JComboBox sexOption = new JComboBox(sex);
		center.add(new JLabel("Nem: "));
		center.add(sexOption);
		
		//A dátum kiválasztásához 3 combo box-t használok fel, amik egymás mellett helyezkednek el, tehát ebbe a cellába egy új layoutot kell felvenni
		
		//Napok tömb, majd feltöltése értékekkel. Nincs dátumellenõrzés, tehát lehet fals szül. dátumot megadni
		Integer[] day = new Integer[31];
		int inc=1;
		for(int i=0;i<day.length;i++){
			day[i]= inc;
		    inc++;
		}
		
		
		String[] month = {"JANUÁR", "FEBRUÁR", "MÁRCIUS", "ÁPRILIS", "MÁJUS", "JÚNIUS", "JÚLIUS", "AUGUSZTUS", "SZEPTEMBER", "OKTÓBER", "NOVEMBER", "DECEMBER"};
		
		//Évek tömb, majd feltöltése értékekkel.
		Integer[] year = new Integer[80];		
		inc = 1940;
		for (int i=0; i<year.length; i++) {
			year[i] = inc++;
			
		}
		
		
		JComboBox<Integer> choseDay = new JComboBox<>(day);
		JComboBox<String> choseMonth = new JComboBox<>(month);
		JComboBox<Integer> choseYear = new JComboBox<>(year);
		
		JPanel dateChangePanel = new JPanel(new FlowLayout());
		center.add(new JLabel("Születési dátum: "));
		center.add(dateChangePanel);
		dateChangePanel.add(choseDay);
		dateChangePanel.add(choseMonth);
		dateChangePanel.add(choseYear);
		
	
		tovabb.setActionCommand("tovabbNewMember");
		bottomButtons();
	}
}
