package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewMemberUI extends NewThingUI {
	private JTextField fullName;
	private String[] sex;
	private JComboBox<String> sexOption;
	private JComboBox<Integer> choseDay;
	private JComboBox<String> choseMonth;
	private JComboBox<Integer> choseYear;

	public NewMemberUI(ApplicationFrame frame) {
		super(frame);

		fullName = new JTextField();
		sex = new String[2];
		sex[0] = "F�rfi";
		sex[1] = "N�";
		sexOption = new JComboBox<String>(sex);

		// A d�tum kiv�laszt�s�hoz 3 combo box-t haszn�lok fel, amik egym�s mellett
		// helyezkednek el, teh�t ebbe a cell�ba egy �j layoutot kell felvenni

		// Napok t�mb, majd felt�lt�se �rt�kekkel. Nincs d�tumellen�rz�s, teh�t lehet
		// fals sz�l. d�tumot megadni
		Integer[] day = new Integer[31];
		int inc = 1;
		for (int i = 0; i < day.length; i++) {
			day[i] = inc;
			inc++;
		}

		String[] month = { "JANU�R", "FEBRU�R", "M�RCIUS", "�PRILIS", "M�JUS", "J�NIUS", "J�LIUS", "AUGUSZTUS",
				"SZEPTEMBER", "OKT�BER", "NOVEMBER", "DECEMBER" };

		// �vek t�mb, majd felt�lt�se �rt�kekkel.
		Integer[] year = new Integer[80];
		inc = 1940;
		for (int i = 0; i < year.length; i++) {
			year[i] = inc++;
		}

		choseDay = new JComboBox<>(day);
		choseMonth = new JComboBox<>(month);
		choseYear = new JComboBox<>(year);
	}

	public void displayNewMemberUI() {
		frame.removeOldComponents();
		frame.setTitle("Tag felv�tele");

		JLabel text = new JLabel("Add meg a tag adatait!");

		top.add(text);
		top.validate(); // Friss�tj�k a tartalmat ezzel a f�ggv�nnyel

		center.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 10)); // Hogy ne l�gjon r� a sz�l�re
		center.setLayout(new GridLayout(3, 2, 20, 20));

		center.add(new JLabel("Teljes n�v: "));
		fullName.setText("");
		center.add(fullName);

		center.add(new JLabel("Nem: "));
		
		center.add(sexOption);

		JPanel dateChangePanel = new JPanel(new FlowLayout());
		center.add(new JLabel("Sz�let�si d�tum: "));
		center.add(dateChangePanel);
		dateChangePanel.add(choseDay);
		dateChangePanel.add(choseMonth);
		dateChangePanel.add(choseYear);

		tovabb.setText("Ment�s");
		
		
		setComponentsVisible();
		bottomButtons();
		vissza.setVisible(false);		
	}

	public JTextField getFullName() {
		return fullName;
	}

	public int getSelectedDay() {
		return (Integer) choseDay.getSelectedItem();
	}

	public int getSelectedMonth() {
		String month = (String) (choseMonth.getSelectedItem()); 

		int result = 1;
		
		switch (month) {
		case "JANU�R":
			result = 1;
			break;
		case "FEBRU�R":
			result = 2;
			break;
		case "M�RCIUS":
			result = 3;
			break;
		case "�PRILIS":
			result = 4;
			break;
		case "M�JUS":
			result = 5;
			break;
		case "J�NIUS":
			result = 6;
			break;
		case "J�LIUS":
			result = 7;
			break;
		case "AUGUSZTUS":
			result = 8;
			break;
		case "SZEPTEMBER":
			result = 9;
			break;
		case "OKT�BER":
			result = 10;
			break;
		case "NOVEMBER":
			result = 11;
			break;
		case "DECEMBER":
			result = 12;
			break;
		}

		return result;

	}

	public Integer getSelectedYear() {
		return (Integer) choseYear.getSelectedItem();

	}

	public String getSex() {
		return (String) (sexOption.getSelectedItem());
	}

	

}
