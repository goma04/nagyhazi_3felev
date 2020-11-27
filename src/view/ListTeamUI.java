package view;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import model.Member;
import model.MemberData;
import model.Team;
import model.TeamData;

public class ListTeamUI {
	private JPanel top, bottom, center;
	private  ApplicationFrame frame;
	private TeamData teamData;
	private JComboBox<Object> teams, members, membersOfTeamComboBox;
	private JButton ok, back, delete, add;
	private Team selectedTeam;
	private Member selectedMemberAdd, selectedMemberDelete;

	public ListTeamUI(ApplicationFrame frame, TeamData teamData, MemberData memberData) {
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.bottom = frame.getBottom();
		this.teamData = teamData;
		this.ok = new JButton("Ok");
		this.back = new JButton("Vissza");
		this.delete = new JButton("Törlés a csapatból");
		this.add = new JButton("Tag hozzáadása");
	}

	public void displayListTeam() {
		frame.removeOldComponents();

		frame.setTitle("Csapatok adatai");
		top.add(new JLabel("Csapatok Adatai"));

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

	public void displayChooseTeam() {
		frame.removeOldComponents();

		frame.setTitle("Csapat választása");
		top.add(new JLabel("Válassza ki a csapatot!"));

		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		// A jcombobox egy Object tömböt vár
		Object[] teamDataInfo = teamData.getAsArray();

		teams = new JComboBox<Object>(teamDataInfo);

		bottom.add(teams);

		ok.setVisible(true);

		bottom.add(ok);
		bottom.validate();
		frame.pack();

	}
	
	private MemberData membersOfTeam() {
		return new MemberData(selectedTeam.getMembers());
	}

	private void displayMemberList() {
		frame.removeOldComponents();

		frame.setTitle("Csapattagok");
		top.add(new JLabel("A csapat tagjai:"));

		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		//MemberData membersOfTeam = new MemberData(selectedTeam.getMembers());

		// System.out.println("Selected team: " + selectedTeam.toString());

		JTable table = new JTable(membersOfTeam());

		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);

		center.add(scrollPane, BorderLayout.CENTER);

		center.validate();
	}

	public void displayListMembersOfTeam() {

		displayMemberList();

		bottom.add(back);
		back.setVisible(true);

		bottom.validate();
		frame.pack();

	}

	public JButton getOk() {
		return ok;
	}

	public void setSelectedTeam(Team selectedTeam) {
		this.selectedTeam = selectedTeam;
	}
	
	public Team getSelectedTeam() {
		return selectedTeam;
	}

	public JComboBox<Object> getTeams() {
		return teams;
	}

	public JButton getBack() {
		return back;

	}

	public void displayModifyTeamMembers(MemberData memberData) {
		displayListMembersOfTeam();

		// A jcombobox egy Object tömböt vár
		Object[] memberInfo = memberData.getAsArray();
		members = new JComboBox<Object>(memberInfo);
		
		
		membersOfTeamComboBox = new JComboBox<Object>(membersOfTeam().getAsArray());

		bottom.add(back);	
		bottom.add(new JLabel("                                                    ")); // Hogy jobban szét lehessen választani		 
		bottom.add(members);
		bottom.add(add);
		
		bottom.add(new JLabel("                     "));
		
		bottom.add(membersOfTeamComboBox);
		bottom.add(delete);
		back.setVisible(true);
		add.setVisible(true);
		delete.setVisible(true);

		bottom.validate();
		frame.pack();
	}

	public JButton getDelete() {
		return delete;
	}

	

	public JButton getAdd() {
		return add;
	}

	public Member getSelectedMemberAdd() {
		return selectedMemberAdd;
	}

	public void setSelectedMemberAdd(Member selectedMemberAdd) {
		this.selectedMemberAdd = selectedMemberAdd;
	}

	public Member getSelectedMemberDelete() {
		return selectedMemberDelete;
	}

	public void setSelectedMemberDelete(Member selectedMemberDelete) {
		this.selectedMemberDelete = selectedMemberDelete;
	}

	public JComboBox<Object> getMembers() {
		return members;
	}

	public void setMembers(JComboBox<Object> members) {
		this.members = members;
	}

	public JComboBox<Object> getMembersOfTeamComboBox() {
		return membersOfTeamComboBox;
	}

	public void setMembersOfTeamComboBox(JComboBox<Object> membersOfTeamComboBox) {
		this.membersOfTeamComboBox = membersOfTeamComboBox;
	}


	
	

}
