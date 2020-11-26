package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JMenuItem;

import exception.ElementAlreadyInList;
import model.*;

import view.*;

import view.PopUpMessage;

public class Controller {
	protected TeamData teamData;
	protected MemberData memberData;
	protected ApplicationFrame AFrame;
	
	
	
	protected ArrayList<Member> members;
	
	private boolean tagModifikacioCsapatban;

	public Controller(MemberData memberData, TeamData teamData, ApplicationFrame AFrame) {
		this.teamData = teamData;
		this.memberData = memberData;
		this.AFrame = AFrame;
		this.newTeamUI = new NewTeamUI(AFrame, memberData);
		this.listTeamUI = new ListTeamUI(AFrame, teamData, memberData);
		this.listMemberUI = new ListMembersUI(AFrame, memberData, teamData);
		this.newMemberUI = new NewMemberUI(AFrame);
		this.deleteTeamUI = new DeleteTeamUI(AFrame, teamData);
		initController();
		this.tagModifikacioCsapatban = false;
	}

	public void initController() {
		JMenuItem[] menuItems = AFrame.getMenuItems();
		menuItems[0].addActionListener(e -> newTeamUI.displayChooseSport());		// Új csapat felvétele
		menuItems[1].addActionListener(e -> listTeamUI.displayListTeam()); 			// Csapatok kilistázása (Általános inf.)
		menuItems[2].addActionListener(e -> deleteTeamUI.displayDeleteTeamUI()); 	// Csapat törlése
		menuItems[3].addActionListener(e -> newMemberUI.displayNewMemberUI()); 		// Tagok felvétele
		menuItems[4].addActionListener(e -> listMemberUI.displayListMembersUI());	// Tagok listázása
		menuItems[5].addActionListener(e -> listMemberUI.displayChooseMember()); 	// Tagokhoz tartozó csapatok
		menuItems[6].addActionListener(e -> { 										// Csapathoz tartozó tagok módosítása
			listTeamUI.displayChooseTeam(); 
			tagModifikacioCsapatban = true;
		});

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
					teamData.addFootballTeam(newTeamUI.getName().getText(), members, newTeamUI.getCoach1().getText(),
							newTeamUI.getCoach2().getText());
				} else if (newTeamUI.getBasketball()) {
					teamData.addBasketballTeam(newTeamUI.getName().getText(), members,
							newTeamUI.getLeaderName().getText(), Integer.parseInt(newTeamUI.getGirlNumber().getText()));
				} else if (newTeamUI.getHandball()) {
					teamData.addHandballTeam(members, newTeamUI.getName().getText(),
							Double.parseDouble(newTeamUI.getAnnualSponsorship().getText()));
				}
				newTeamUI.setAllSportFalse();
				new PopUpMessage("Csapat sikeresen elmentve!");
				listTeamUI.displayListTeam();

			}
		});

		// Ok gomb (csapatválasztó)
		listTeamUI.getOk().addActionListener(e -> {
			listTeamUI.setSelectedTeam((Team) listTeamUI.getTeams().getSelectedItem());
			
			if(tagModifikacioCsapatban) { //amikor modifikáljuk a csapattagokat
				listTeamUI.displayModifyTeamMembers(memberData);
			}else { //amikor kiválasztja hogy melyik csapatnak listázza ki a tagjait				
				listTeamUI.displayListMembersOfTeam();
			}
			
		});
		
		
		//Tag törlése csapatból
		listTeamUI.getDelete().addActionListener(e->{
			listTeamUI.setSelectedMemberDelete((Member)listTeamUI.getMembersOfTeamComboBox().getSelectedItem());
			listTeamUI.getSelectedTeam().removeMember(listTeamUI.getSelectedMemberDelete()); //Töröljük a tagot a csapatból;
			listTeamUI.displayModifyTeamMembers(memberData);
		});
		
		
		listTeamUI.getAdd().addActionListener(e -> {
			listTeamUI.setSelectedMemberAdd((Member)listTeamUI.getMembers().getSelectedItem());
			try {
				listTeamUI.getSelectedTeam().addMember(listTeamUI.getSelectedMemberAdd()); //Töröljük a tagot a csapatból;
				listTeamUI.displayModifyTeamMembers(memberData);
			} catch (ElementAlreadyInList exception) {
				new PopUpMessage("Ez az ember már benne van a csapatban!");
			}					
		});
		

		listTeamUI.getBack().addActionListener(e -> {
			listTeamUI.displayChooseTeam();
		});

		// Amikor csapathoz adunk tagot gomb
		newTeamUI.getAddMember().addActionListener(e -> {
			members.add((Member) newTeamUI.getMembers().getSelectedItem());
			new PopUpMessage("Tag hozzáadva a csapathoz!");
		});

		// Vissza gomb, amikor egy csapat adatait adnánk meg
		newTeamUI.getVissza().addActionListener(e -> {
			if (e.getActionCommand() == "stage1") {
				newTeamUI.displayChooseSport();
				newTeamUI.setAllSportFalse();
			}
		});

		// Új tag felvétele gomb
		newMemberUI.getTovabb().addActionListener(e -> {
			Calendar birthday = Calendar.getInstance();
			birthday.set(newMemberUI.getSelectedYear(), newMemberUI.getSelectedMonth() - 1,
					newMemberUI.getSelectedDay(), 0, 0);
			memberData.addMember(newMemberUI.getFullName().getText(), newMemberUI.getSex(), birthday);
			new PopUpMessage("Tag Felvéve!");
			newMemberUI.displayNewMemberUI();
		});

		// Csapat törlése gomb
		deleteTeamUI.getDeleteBtn().addActionListener(e -> {
			teamData.deleteTeam(deleteTeamUI.getTeams().getSelectedItem());
			deleteTeamUI.displayDeleteTeamUI(); // frissítjük az ablakot
			new PopUpMessage("Csapat törölve!");
		});

		// Kiválasztjuk a tagok, aemlyikhez listázzuk a csapatokat
		listMemberUI.getOk().addActionListener(e -> {
			listMemberUI.setSelectedMember((Member) listMemberUI.getMembersComboBox().getSelectedItem());
			listMemberUI.displayTeamsOfMember(listMemberUI.getSelectedMember());
		});

		// Vissza gomb amikor kilistáztuk a taghoz tartozó csapatokat
		listMemberUI.getBack().addActionListener(e -> {
			listMemberUI.displayChooseMember();
		});

	}

}
