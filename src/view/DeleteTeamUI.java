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
		deleteBtn = new JButton("Csapat t�rl�se");
	}

	public void displayDeleteTeamUI() {
		frame.removeOldComponents();

		ListTeamUI list = new ListTeamUI(frame, teamData, null);
		list.displayListTeam();

		frame.setTitle("Csapat t�rl�se");

		top.removeAll();
		top.add(new JLabel("V�lassza ki a t�r�lni k�v�nt csapatot!"));

		top.validate(); // Friss�tj�k a tartalmat ezzel a f�ggv�nnyel

		// A jcombobox egy Object t�mb�t v�r
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
