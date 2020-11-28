package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import model.TeamData;

public class DeleteTeamUI extends UI{
	private JButton deleteBtn;
	private TeamData teamData;
	private JComboBox<Object> teams;

	public DeleteTeamUI(ApplicationFrame frame, TeamData teamData) {
		super(frame);
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

	public JComboBox<Object> getTeams() {
		return teams;
	}
	
}
