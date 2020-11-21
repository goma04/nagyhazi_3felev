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
		frame.setTitle("Tag felv�tele");

		JLabel text = new JLabel("Add meg a tag adatait!");

		top.add(text);
		top.validate(); // Friss�tj�k a tartalmat ezzel a f�ggv�nnyel

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // Hogy ne l�gjon r� a sz�l�re

		center.setLayout(new GridLayout(1, 3, 10, 10));
		center.setLayout(new GridLayout(3, 2, 20, 20));
		
		JTextField fullName = new JTextField();		
		center.add(new JLabel("Teljes n�v: "));
		center.add(fullName);
		
		
		String sex[] = {"F�rfi", "N�"};
		JComboBox sexOption = new JComboBox(sex);
		center.add(new JLabel("Nem: "));
		center.add(sexOption);
		
		//A d�tum kiv�laszt�s�hoz 3 combo box-t haszn�lok fel, amik egym�s mellett helyezkednek el, teh�t ebbe a cell�ba egy �j layoutot kell felvenni
		
		//Napok t�mb, majd felt�lt�se �rt�kekkel. Nincs d�tumellen�rz�s, teh�t lehet fals sz�l. d�tumot megadni
		Integer[] day = new Integer[31];
		int inc=1;
		for(int i=0;i<day.length;i++){
			day[i]= inc;
		    inc++;
		}
		
		
		String[] month = {"JANU�R", "FEBRU�R", "M�RCIUS", "�PRILIS", "M�JUS", "J�NIUS", "J�LIUS", "AUGUSZTUS", "SZEPTEMBER", "OKT�BER", "NOVEMBER", "DECEMBER"};
		
		//�vek t�mb, majd felt�lt�se �rt�kekkel.
		Integer[] year = new Integer[80];		
		inc = 1940;
		for (int i=0; i<year.length; i++) {
			year[i] = inc++;
			
		}
		
		
		JComboBox<Integer> choseDay = new JComboBox<>(day);
		JComboBox<String> choseMonth = new JComboBox<>(month);
		JComboBox<Integer> choseYear = new JComboBox<>(year);
		
		JPanel dateChangePanel = new JPanel(new FlowLayout());
		center.add(new JLabel("Sz�let�si d�tum: "));
		center.add(dateChangePanel);
		dateChangePanel.add(choseDay);
		dateChangePanel.add(choseMonth);
		dateChangePanel.add(choseYear);
		
	
		tovabb.setActionCommand("tovabbNewMember");
		bottomButtons();
	}
}
