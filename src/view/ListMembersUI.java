package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Member;
import model.MemberData;
import model.TeamData;

public class ListMembersUI {
	private JPanel top, center, bottom;
	private ApplicationFrame frame;
	private MemberData memberData;
	private JComboBox<Object> members;
	private JButton ok, back;
	private Member selectedMember;
	private TeamData teamData;

	public ListMembersUI(ApplicationFrame frame, MemberData memberData, TeamData teamData) {
		this.frame = frame;
		this.top = frame.getTop();
		this.center = frame.getCenter();
		this.center = frame.getCenter();
		this.memberData = memberData;
		this.ok = new JButton("Ok");
		this.back = new JButton("Vissza");
		this.center = frame.getCenter();
		this.bottom = frame.getBottom();
		this.teamData = teamData;
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
	}

	public void displayChooseMember() {
		frame.removeOldComponents();

		frame.setTitle("Tag választása");
		top.add(new JLabel("Válassza ki a tagot!"));

		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		// A jcombobox egy Object tömböt vár
		Object[] memberInfo = memberData.getAsArray();

		members = new JComboBox<Object>(memberInfo);
		bottom.add(members);
		ok.setVisible(true);

		bottom.add(ok);
		bottom.validate();
		
		bottom.validate();
		frame.pack();
	}
	
	
	//Listát rajzol ki, amiben azok a csapatok vannak, amikben benne van az adott tag
	public void displayTeamsOfMember(Member member) {
		frame.removeOldComponents();

		frame.setTitle("Tag Csapatai");
		top.add(new JLabel("A tag csapatai:"));

		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		TeamData teamsOfMember = new TeamData(selectedMember.getTeamsMemberIn(teamData));

		// System.out.println("Selected team: " + selectedTeam.toString());

		JTable table = new JTable(teamsOfMember);

		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);

		center.add(scrollPane, BorderLayout.CENTER);

		center.validate();

		
		bottom.add(back);
		back.setVisible(true);
		
		bottom.validate();
		frame.pack();
	}

	public JButton getOk() {
		return ok;
		
	}
	
	public JButton getBack() {
		return back;
	}

	public Member getSelectedMember() {
		return selectedMember;
	}

	public void setSelectedMember(Member selectedMember) {
		this.selectedMember = selectedMember;
	}
	
	public JComboBox<Object> getMembersComboBox() {
		return members;
	}
	
	
}