package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TeamData extends AbstractTableModel {

	// Ez a tagv�ltoz� t�rolja a csapatok adatait (heterog�n kollekci�)
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
			return "Azonos�t�";
		case 1:
			return "Csapatn�v";
		case 2:
			return "Csapatl�tsz�m";
		case 3:
			return "Tov�bbi inform�ci�";
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

	// Amikor jcombo box-ban kell megjelen�teni a tagokat, egy t�mbben kell �tadni
	public Object[] getAsArray() {
		return teams.toArray();
	}
}
