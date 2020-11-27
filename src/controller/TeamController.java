package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import exception.ElementAlreadyInList;
import model.MemberData;
import model.Team;
import model.TeamData;
import view.ApplicationFrame;
import view.DeleteTeamUI;
import view.ListMembersUI;
import view.ListTeamUI;
import view.NewTeamUI;
import view.PopUpMessage;
import model.Member;

public class TeamController extends Controller {
	private ListTeamUI listTeamUI;
	private NewTeamUI newTeamUI;
	private DeleteTeamUI deleteTeamUI;
	private ArrayList<Member> members;

	public TeamController(MemberData memberData, TeamData teamData, ApplicationFrame AFrame) {
		super(memberData, teamData, AFrame);
		this.newTeamUI = new NewTeamUI(AFrame);
		this.listTeamUI = new ListTeamUI(AFrame, teamData, memberData);
		this.deleteTeamUI = new DeleteTeamUI(AFrame, teamData);

		setMenuItems();
		setSportChooseButtons();
		setTovabbButton();
		setOkButton();
		setDeleteMemberButton();
		setAddNewMemberButton();
		setDeleteTeamButton();
		setAddButton();
		setVisszaButton();
		setBackButton();
	}

	private void setMenuItems() {
		menuItems[0].addActionListener(e -> newTeamUI.displayChooseSport()); // �j csapat felv�tele
		menuItems[1].addActionListener(e -> listTeamUI.displayListTeam()); // Csapatok kilist�z�sa (�ltal�nos inf.)
		menuItems[2].addActionListener(e -> deleteTeamUI.displayDeleteTeamUI()); // Csapat t�rl�se
		menuItems[6].addActionListener(e -> {
			listTeamUI.displayChooseTeam();
		}); // Csapathoz tartoz� tagok m�dos�t�sa
	}

	private void setSportChooseButtons() {
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
	}

	// Mit csin�l a tov�bb gomb
	private void setTovabbButton() {
		newTeamUI.getTovabb().addActionListener(e -> {
			if (e.getActionCommand() == "tovabbNewTeam") {
				(new ListMembersUI(frame, memberData, teamData)).displayListMembersUI();
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
							Integer.parseInt(newTeamUI.getAnnualSponsorship().getText()));
				}
				newTeamUI.setAllSportFalse();
				new PopUpMessage("Csapat sikeresen elmentve!", JOptionPane.INFORMATION_MESSAGE);
				listTeamUI.displayListTeam();

			}
		});
	}

	// Ok gomb (csapatv�laszt�)
	private void setOkButton() {
		listTeamUI.getOk().addActionListener(e -> {
			listTeamUI.setSelectedTeam((Team) listTeamUI.getTeams().getSelectedItem());
			listTeamUI.displayModifyTeamMembers(memberData);
		});
	}

	// Tag t�rl�se csapatb�l
	private void setDeleteMemberButton() {
		listTeamUI.getDelete().addActionListener(e -> {
			listTeamUI.setSelectedMemberDelete((Member) listTeamUI.getMembersOfTeamComboBox().getSelectedItem());
			listTeamUI.getSelectedTeam().removeMember(listTeamUI.getSelectedMemberDelete()); // T�r�lj�k a tagot a
																								// csapatb�l;
			listTeamUI.displayModifyTeamMembers(memberData);
		});
	}

	// Tag hozz�ad�sa (ut�lag) gomb
	private void setAddButton() {
		listTeamUI.getAdd().addActionListener(e -> {
			listTeamUI.setSelectedMemberAdd((Member) listTeamUI.getMembers().getSelectedItem());
			try {
				listTeamUI.getSelectedTeam().addMember(listTeamUI.getSelectedMemberAdd());
				listTeamUI.displayModifyTeamMembers(memberData);
			} catch (ElementAlreadyInList exception) {
				new PopUpMessage("Ez az ember m�r benne van a csapatban!", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	// Amikor csapathoz adunk tagot gomb (csapat felv�telekor)
	private void setAddNewMemberButton() {
		newTeamUI.getAddMember().addActionListener(e -> {
			members.add((Member) newTeamUI.getMembers().getSelectedItem());
			new PopUpMessage("Tag hozz�adva a csapathoz!", JOptionPane.INFORMATION_MESSAGE);
		});
	}

	private void setBackButton() {
		listTeamUI.getBack().addActionListener(e -> {
			listTeamUI.displayChooseTeam();
		});
	}

	// Vissza gomb, amikor egy csapat adatait adn�nk meg
	private void setVisszaButton() {
		newTeamUI.getVissza().addActionListener(e -> {
			if (e.getActionCommand() == "stage1") {
				newTeamUI.displayChooseSport();
				newTeamUI.setAllSportFalse();
			}
		});
	}

	// Csapat t�rl�se gomb
	private void setDeleteTeamButton() {
		deleteTeamUI.getDeleteBtn().addActionListener(e -> {
			teamData.deleteTeam(deleteTeamUI.getTeams().getSelectedItem());
			deleteTeamUI.displayDeleteTeamUI(); // friss�tj�k az ablakot
			new PopUpMessage("Csapat t�r�lve!", JOptionPane.INFORMATION_MESSAGE);
		});
	}

}
