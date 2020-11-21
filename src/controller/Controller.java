package controller;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JMenuItem;

import model.*;

import view.*;

public class Controller {
	private TeamData teamData;
	private MemberData memberData;
	private ApplicationFrame AFrame;
	private ListTeamUI listTeamUI;
	private ListMembersUI listMemberUI;
	private NewTeamUI newTeamUI;;
	private NewMemberUI newMemberUI;;

	public Controller(MemberData memberData, TeamData teamData, ApplicationFrame AFrame) {
		this.teamData = teamData;
		this.memberData = memberData;
		this.AFrame = AFrame;
		this.newTeamUI = new NewTeamUI(AFrame);
		this.listTeamUI = new ListTeamUI(AFrame);
		this.listMemberUI = new ListMembersUI(AFrame, memberData);
		this.newMemberUI = new NewMemberUI(AFrame);
		initController();
	}

	public void printTeams() {
		teamData.printData();
	}

	public void initController() {
		JMenuItem[] menuItems = AFrame.getMenuItems();
		menuItems[0].addActionListener(e -> newTeamUI.displayChooseSport()); // Új csapat felvétele
		menuItems[1].addActionListener(e -> listTeamUI.displayListTeam()); // Csapatok kilistázása
		menuItems[2].addActionListener(e -> newMemberUI.displayNewMemberUI()); // Tag felvétele
		menuItems[3].addActionListener(e -> listMemberUI.displayListMembersUI()); // Tagok listázása
		newTeamUI.getFoci().addActionListener(e -> newTeamUI.displayFootball());
		newTeamUI.getKosar().addActionListener(e -> newTeamUI.displayBasketball());
		newTeamUI.getKezi().addActionListener(e -> newTeamUI.displayHandball());
		// newTeamUI.getTovabb().addActionListener(e->); //itt kell kilistázni a
		// csapattagokat
		newTeamUI.getVissza().addActionListener(e -> {
			if (e.getActionCommand() == "stage1") {
				newTeamUI.displayChooseSport();
			}
		});
		newMemberUI.getTovabb().addActionListener(e -> {
			
			Calendar birthday = Calendar.getInstance();
			birthday.set(newMemberUI.getSelectedYear(), newMemberUI.getSelectedMonth()-1, newMemberUI.getSelectedDay(), 0, 0);
			memberData.addMember(newMemberUI.getFullName().getText(), newMemberUI.getSex(), birthday);
			memberData.printData();
		});
		
		Calendar birthday = Calendar.getInstance();
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
		memberData.addMember("Teszt Elek", "Férfi", birthday);
	}

}
