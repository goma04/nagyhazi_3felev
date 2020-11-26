package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import model.TeamData;

public class DeleteTeamUI {

	private JPanel top, bottom, center;
	JButton deleteBtn;
	protected ApplicationFrame frame;
	private TeamData teamData;
	private JComboBox<Object> teams;

	public DeleteTeamUI(ApplicationFrame frame, TeamData teamData) {
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.bottom = frame.getBottom();
		this.teamData = teamData;
		deleteBtn = new JButton("Csapat törlése");
	}

	public void displayDeleteTeamUI() {
		frame.removeOldComponents();

		ListTeamUI list = new ListTeamUI(frame, teamData, null);
		list.displayListTeam();

		frame.setTitle("Csapat törlése");

		top.removeAll();
		top.add(new JLabel("Válassza ki a törölni kívánt csapatot!"));

		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		// A jcombobox egy Object tömböt vár
		Object[] teamDataInfo = teamData.getAsArray();

		teams = new JComboBox<Object>(teamDataInfo);
		bottom.add(teams);
		deleteBtn.setVisible(true);
		bottom.add(deleteBtn);
		
		

		//bottomButtons();
		bottom.validate();
		frame.pack();

	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public JComboBox<Object> getTeams() {
		return teams;
	}

	public void setTeams(JComboBox<Object> teams) {
		this.teams = teams;
	}
	
	
}
