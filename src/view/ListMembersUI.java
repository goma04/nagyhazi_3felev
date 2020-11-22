package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



import model.MemberData;

public class ListMembersUI {
	private JPanel top, center;
	private ApplicationFrame frame;
	private MemberData memberData;

	public ListMembersUI(ApplicationFrame frame, MemberData memberData) {
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.center = frame.getCenter();
		this.memberData = memberData;
	}

	public void displayListMembersUI() {
		frame.removeOldComponents();
		
		frame.setTitle("Tagok adatai");
		top.add(new JLabel("Tagok Adatai"));

		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		JTable table = new JTable(memberData);
		
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		center.add(scrollPane, BorderLayout.CENTER);
		
		center.validate();
		
		
		//frame.pack();

	}
}