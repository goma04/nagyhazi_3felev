package controller;

import java.util.ArrayList;
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
	private NewTeamUI newTeamUI;
	private NewMemberUI newMemberUI;
	private ArrayList<Member> members;

	public Controller(MemberData memberData, TeamData teamData, ApplicationFrame AFrame) {
		this.teamData = teamData;
		this.memberData = memberData;
		this.AFrame = AFrame;
		this.newTeamUI = new NewTeamUI(AFrame, memberData);
		this.listTeamUI = new ListTeamUI(AFrame, teamData);
		this.listMemberUI = new ListMembersUI(AFrame, memberData);
		this.newMemberUI = new NewMemberUI(AFrame);
		initController();
		
	}

	public void initController() {
		JMenuItem[] menuItems = AFrame.getMenuItems();
		menuItems[0].addActionListener(e -> newTeamUI.displayChooseSport()); // Új csapat felvétele
		menuItems[1].addActionListener(e -> listTeamUI.displayListTeam()); // Csapatok kilistázása
		menuItems[2].addActionListener(e -> newMemberUI.displayNewMemberUI()); // Tag felvétele
		menuItems[3].addActionListener(e -> listMemberUI.displayListMembersUI()); // Tagok listázása

		newTeamUI.getFoci().addActionListener(e -> {
			newTeamUI.displayFootball();
			newTeamUI.setFootball(true);
		});
		newTeamUI.getKosar().addActionListener(e -> {
			newTeamUI.displayBasketball();
			newTeamUI.setBasketball(true);
		});
		newTeamUI.getKezi().addActionListener(e -> {
			newTeamUI.displayHandball();
			newTeamUI.setHandball(true);
		});

		// Mit csinál a tovább gomb
		newTeamUI.getTovabb().addActionListener(e -> {
			if (e.getActionCommand() == "tovabbNewTeam") {
				listMemberUI.displayListMembersUI();
				members = new ArrayList<Member>();
				newTeamUI.displayFinalStageBottom(memberData);
			} else if (e.getActionCommand() == "saveTeam") {
				if (newTeamUI.getFootball()) {
					teamData.addFootballTeam(newTeamUI.getName().getText(), members, newTeamUI.getCoach1().getText(), newTeamUI.getCoach2().getText());
				} else if (newTeamUI.getBasketball()) {
					teamData.addBasketballTeam(newTeamUI.getName().getText(), members, newTeamUI.getLeaderName().getText(), Integer.parseInt(newTeamUI.getGirlNumber().getText()));
				}else if(newTeamUI.getHandball()) {
					teamData.addHandballTeam(members, newTeamUI.getName().getText(), Double.parseDouble(newTeamUI.getAnnualSponsorship().getText()));
				}
				newTeamUI.setAllSportFalse();
				
				
			}
		});

		//Amikor csapathoz adunk tagot gomb
		newTeamUI.getAddMember().addActionListener(e -> {
			members.add((Member) newTeamUI.getMembers().getSelectedItem());
		});

		newTeamUI.getVissza().addActionListener(e -> {
			if (e.getActionCommand() == "stage1") {
				newTeamUI.displayChooseSport();
				newTeamUI.setAllSportFalse();
			}
		});
		
		//Új tag felvétele gomb
		newMemberUI.getTovabb().addActionListener(e -> {
			Calendar birthday = Calendar.getInstance();
			birthday.set(newMemberUI.getSelectedYear(), newMemberUI.getSelectedMonth() - 1, newMemberUI.getSelectedDay(), 0, 0);
			memberData.addMember(newMemberUI.getFullName().getText(), newMemberUI.getSex(), birthday);
		
		});

		Calendar birthday = Calendar.getInstance();
		/*memberData.addMember("Teszt Elek", "Férfi", birthday);
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
		memberData.addMember("Teszt Elek", "Férfi", birthday);*/
		
		
		
		/*ArrayList<Member> tesztEmberek =  new ArrayList<Member>();
		tesztEmberek.add(new Member("Teszt Elek", "Férfi", birthday));
		tesztEmberek.add(new Member("Teszt Elek", "Férfi", birthday));
		tesztEmberek.add(new Member("Teszt Elek", "Férfi", birthday));
		
		teamData.addFootballTeam("TesztTeam", tesztEmberek, "Kis Pál", "Zénó Bácsi");*/
	}

}
