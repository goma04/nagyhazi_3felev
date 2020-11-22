package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import model.TeamData;

public class ListTeamUI {
	private JPanel top, bottom, center;
	protected ApplicationFrame frame;
	private TeamData teamData;

	public ListTeamUI(ApplicationFrame frame, TeamData teamData) {
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.bottom = frame.getBottom();
		this.teamData = teamData;
	}

	public void displayListTeam() {
		frame.removeOldComponents();

		frame.setTitle("Tagok adatai");
		top.add(new JLabel("Tagok Adatai"));

		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		JTable table = new JTable(teamData);
		table.setRowHeight(30);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(40);
		columnModel.getColumn(3).setPreferredWidth(300);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);

		center.add(scrollPane, BorderLayout.CENTER);

		center.validate();
	}
}
