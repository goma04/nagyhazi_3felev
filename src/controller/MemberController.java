package controller;

import java.util.Calendar;

import javax.swing.JOptionPane;

import model.Member;
import model.MemberData;
import model.TeamData;
import view.ApplicationFrame;
import view.ListMembersUI;
import view.NewMemberUI;
import view.PopUpMessage;

public class MemberController extends Controller {
	private ListMembersUI listMemberUI;
	private NewMemberUI newMemberUI;

	public MemberController(MemberData memberData, TeamData teamData, ApplicationFrame AFrame) {
		super(memberData, teamData, AFrame);
		this.listMemberUI = new ListMembersUI(AFrame, memberData, teamData);
		this.newMemberUI = new NewMemberUI(AFrame);
		setBackButton();
		setOkButton();
		setMenuItems();
		setAddNewMemberButton();
	}

	private void setMenuItems() {
		menuItems[3].addActionListener(e -> newMemberUI.displayNewMemberUI()); // Tagok felv�tele
		menuItems[4].addActionListener(e -> listMemberUI.displayListMembersUI()); // Tagok list�z�sa
		menuItems[5].addActionListener(e -> listMemberUI.displayChooseMember()); // Tagokhoz tartoz� csapatok
	}

	
	// �j tag felv�tele gomb
	private void setAddNewMemberButton() {
		newMemberUI.getTovabb().addActionListener(e -> {
			Calendar birthday = Calendar.getInstance();
			birthday.set(newMemberUI.getSelectedYear(), newMemberUI.getSelectedMonth() - 1,
					newMemberUI.getSelectedDay(), 0, 0);
			memberData.addMember(newMemberUI.getFullName().getText(), newMemberUI.getSex(), birthday);
			new PopUpMessage("Tag Felv�ve!", JOptionPane.INFORMATION_MESSAGE);
			newMemberUI.displayNewMemberUI();
		});

	}

	
	// Kiv�lasztjuk a tagok, amelyikhez list�zzuk a csapatokat
	private void setOkButton() {
		listMemberUI.getOk().addActionListener(e -> {
			listMemberUI.setSelectedMember((Member) listMemberUI.getMembersComboBox().getSelectedItem());
			listMemberUI.displayTeamsOfMember(listMemberUI.getSelectedMember());
		});
	}

	
	// Vissza gomb amikor kilist�ztuk a taghoz tartoz� csapatokat
	private void setBackButton() {
		listMemberUI.getBack().addActionListener(e -> {
			listMemberUI.displayChooseMember();
		});
	}

	
}
