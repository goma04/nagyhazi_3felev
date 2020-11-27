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
		sex[0] = "Férfi";
		sex[1] = "Nõ";
		sexOption = new JComboBox<String>(sex);

		// A dátum kiválasztásához 3 combo box-t használok fel, amik egymás mellett
		// helyezkednek el, tehát ebbe a cellába egy új layoutot kell felvenni

		// Napok tömb, majd feltöltése értékekkel. Nincs dátumellenõrzés, tehát lehet
		// fals szül. dátumot megadni
		Integer[] day = new Integer[31];
		int inc = 1;
		for (int i = 0; i < day.length; i++) {
			day[i] = inc;
			inc++;
		}

		String[] month = { "JANUÁR", "FEBRUÁR", "MÁRCIUS", "ÁPRILIS", "MÁJUS", "JÚNIUS", "JÚLIUS", "AUGUSZTUS",
				"SZEPTEMBER", "OKTÓBER", "NOVEMBER", "DECEMBER" };

		// Évek tömb, majd feltöltése értékekkel.
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
		frame.setTitle("Tag felvétele");

		JLabel text = new JLabel("Add meg a tag adatait!");

		top.add(text);
		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		center.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 10)); // Hogy ne lógjon rá a szélére
		center.setLayout(new GridLayout(3, 2, 20, 20));

		center.add(new JLabel("Teljes név: "));
		fullName.setText("");
		center.add(fullName);

		center.add(new JLabel("Nem: "));
		
		center.add(sexOption);

		JPanel dateChangePanel = new JPanel(new FlowLayout());
		center.add(new JLabel("Születési dátum: "));
		center.add(dateChangePanel);
		dateChangePanel.add(choseDay);
		dateChangePanel.add(choseMonth);
		dateChangePanel.add(choseYear);

		tovabb.setText("Mentés");
		
		
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
		case "JANUÁR":
			result = 1;
			break;
		case "FEBRUÁR":
			result = 2;
			break;
		case "MÁRCIUS":
			result = 3;
			break;
		case "ÁPRILIS":
			result = 4;
			break;
		case "MÁJUS":
			result = 5;
			break;
		case "JÚNIUS":
			result = 6;
			break;
		case "JÚLIUS":
			result = 7;
			break;
		case "AUGUSZTUS":
			result = 8;
			break;
		case "SZEPTEMBER":
			result = 9;
			break;
		case "OKTÓBER":
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
