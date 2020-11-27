package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TeamData extends AbstractTableModel {

	// Ez a tagváltozó tárolja a csapatok adatait (heterogén kollekció)
	private ArrayList<Team> teams;

	public TeamData(ArrayList<Team> teamList) {
		teams = teamList;
	}

	public void deleteTeam(Object object) {
		teams.remove(object);
	}

	public void addFootballTeam(String name, ArrayList<Member> members, String coach1, String coach2) {
		teams.add(new Football(coach1, coach2, name, members));
	}

	public void addHandballTeam(ArrayList<Member> members, String name, int annualSponsorship) {
		teams.add(new Handball(members, name, annualSponsorship));
	}

	public void addBasketballTeam(String name, ArrayList<Member> members, String leaderName, int girlsNo) {
		teams.add(new Basketball(members, name, girlsNo, leaderName));
	}

	@Override
	public String getColumnName(int index) {
		switch (index) {
		case 0:
			return "Azonosító";
		case 1:
			return "Csapatnév";
		case 2:
			return "Csapatlétszám";
		case 3:
			return "További információ";
		}
		return "undefined";
	}

	@Override
	public int getRowCount() {
		return teams.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Team tempTeam = teams.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return tempTeam.getID().toString().substring(0, 6);
		case 1:
			return tempTeam.getName();
		case 2:
			return tempTeam.getMemberNo();
		case 3:
			return tempTeam.getAdditioinalInformation();
		}
		return "undefinded";
	}

	// Megadja az i. csapatot
	public Team getTeam(int index) {
		return teams.get(index);
	}

	// Amikor jcombo box-ban kell megjeleníteni a tagokat, egy tömbben kell átadni
	public Object[] getAsArray() {
		return teams.toArray();
	}
}
