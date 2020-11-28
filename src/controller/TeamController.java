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
		setBackToChooseSportButton();
	}

	private void setMenuItems() {
		menuItems[0].addActionListener(e -> newTeamUI.displayChooseSport()); // Új csapat felvétele
		menuItems[1].addActionListener(e -> listTeamUI.displayListTeam()); // Csapatok kilistázása (Általános inf.)
		menuItems[2].addActionListener(e -> deleteTeamUI.displayDeleteTeamUI()); // Csapat törlése
		menuItems[6].addActionListener(e -> {
			listTeamUI.displayChooseTeam();
		}); // Csapathoz tartozó tagok módosítása
	}

	private void setSportChooseButtons() {
		newTeamUI.getFoci().addActionListener(e -> {
			newTeamUI.displayFootball();
			newTeamUI.setFootball(true); // Beállítja true-ra az értéket, hogy a későbbi feldolgozáskor tudjuk, hogy
											// milyen csapatot kell felvenni
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

	// Mit csinál a tovább gomb
	private void setTovabbButton() {
		newTeamUI.getTovabb().addActionListener(e -> {
			/*
			 * Ha a sportágat kiválasztották, megadtuk a megfelelő adatokat, és ekkor
			 * nyomnak a tovább gombra. Ilyenkor meg kell jeleníteni az összes tagot, hogy a
			 * felhasználó választani tudjun, hogy kik kerülnek bele a csapatba
			 */
			if (e.getActionCommand() == "tovabbNewTeam") {
				(new ListMembersUI(frame, memberData, teamData)).displayListMembersUI();
				members = new ArrayList<Member>();
				newTeamUI.displayFinalStageBottom(memberData);
			}
			// Ekkor a tovább gomb szövege: "Mentés". Erre nyomva elmenti a csapatot.
			else if (e.getActionCommand() == "saveTeam") {

				// Ha rossz formátumban adta meg az adatot, visszadobja az adatmegadó oldalra
				try {
					if (newTeamUI.getFootball()) {
						teamData.addFootballTeam(newTeamUI.getName().getText(), members,
								newTeamUI.getCoach1().getText(), newTeamUI.getCoach2().getText());
					} else if (newTeamUI.getBasketball()) {
						teamData.addBasketballTeam(newTeamUI.getName().getText(), members,
								newTeamUI.getLeaderName().getText(),
								Integer.parseInt(newTeamUI.getGirlNumber().getText()));
					} else if (newTeamUI.getHandball()) {
						teamData.addHandballTeam(members, newTeamUI.getName().getText(),
								Integer.parseInt(newTeamUI.getAnnualSponsorship().getText()));
					}
					newTeamUI.setAllSportFalse();
					new PopUpMessage("Csapat sikeresen elmentve!", JOptionPane.INFORMATION_MESSAGE);
					listTeamUI.displayListTeam();

				} catch (NumberFormatException hiba) {
					new PopUpMessage("Hibás formátumban adta meg a csapat adatait!", JOptionPane.ERROR_MESSAGE);
					if (newTeamUI.getFootball()) {
						newTeamUI.displayFootball();
					} else if (newTeamUI.getBasketball()) {
						newTeamUI.displayBasketball();
					} else if (newTeamUI.getHandball()) {
						newTeamUI.displayHandball();
					}
				}
			}
		});
	}

	// Ok gomb (csapatválasztó)
	private void setOkButton() {
		listTeamUI.getOk().addActionListener(e -> {
			listTeamUI.setSelectedTeam((Team) listTeamUI.getTeams().getSelectedItem());
			listTeamUI.displayModifyTeamMembers(memberData);
		});
	}

	// Tag törlése csapatból
	private void setDeleteMemberButton() {
		listTeamUI.getDelete().addActionListener(e -> {
			listTeamUI.setSelectedMemberDelete((Member) listTeamUI.getMembersOfTeamComboBox().getSelectedItem());
			listTeamUI.getSelectedTeam().removeMember(listTeamUI.getSelectedMemberDelete()); // Töröljük a tagot a
																								// csapatból;
			listTeamUI.displayModifyTeamMembers(memberData);
		});
	}

	// Tag hozzáadása (utólag) gomb
	private void setAddButton() {
		listTeamUI.getAdd().addActionListener(e -> {
			listTeamUI.setSelectedMemberAdd((Member) listTeamUI.getMembers().getSelectedItem());
			try {
				listTeamUI.getSelectedTeam().addMember(listTeamUI.getSelectedMemberAdd());
				listTeamUI.displayModifyTeamMembers(memberData);
			} catch (ElementAlreadyInList exception) {
				new PopUpMessage("Ez az ember már benne van a csapatban!", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	// Amikor csapathoz adunk tagot gomb (csapat felvételekor)
	private void setAddNewMemberButton() {
		newTeamUI.getAddMember().addActionListener(e -> {
			if (members.contains((Member) newTeamUI.getMembers().getSelectedItem())) {
				new PopUpMessage("Ez a tag már benne van a csapatban!", JOptionPane.ERROR_MESSAGE);
			} else {
				members.add((Member) newTeamUI.getMembers().getSelectedItem());
				new PopUpMessage("Tag hozzáadva a csapathoz!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	private void setBackToChooseSportButton() {
		listTeamUI.getBack().addActionListener(e -> {
			listTeamUI.displayChooseTeam();
		});
	}

	// Vissza gomb, új csapat felvétele során
	private void setVisszaButton() {
		newTeamUI.getVissza().addActionListener(e -> {
			if (e.getActionCommand() == "stage1") {
				newTeamUI.displayChooseSport();
				newTeamUI.setAllSportFalse();
			} else if (e.getActionCommand() == "stage2") { // Ha stage2-nél nyomják meg, akkor az adatok megadása ablak
															// jelenik meg
				if (newTeamUI.getFootball()) {
					newTeamUI.displayFootball();
				} else if (newTeamUI.getBasketball()) {
					newTeamUI.displayBasketball();
				} else if (newTeamUI.getHandball()) {
					newTeamUI.displayHandball();
				}
			}
		});
	}

	// Csapat törlése gomb
	private void setDeleteTeamButton() {
		deleteTeamUI.getDeleteBtn().addActionListener(e -> {
			teamData.deleteTeam(deleteTeamUI.getTeams().getSelectedItem());
			deleteTeamUI.displayDeleteTeamUI(); // frissítjük az ablakot
			new PopUpMessage("Csapat törölve!", JOptionPane.INFORMATION_MESSAGE);
		});
	}

}
