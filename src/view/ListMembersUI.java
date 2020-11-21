package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.graalvm.compiler.phases.common.RemoveValueProxyPhase;

import model.MemberData;

public class ListMembersUI {
	private JPanel top, center, bottom;
	private ApplicationFrame frame;
	private MemberData memberData;

	public ListMembersUI(ApplicationFrame frame, MemberData memberData) {
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.memberData = memberData;
		this.top = frame.getTop();
		this.bottom = frame.getBottom();
		this.center = frame.getCenter();

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