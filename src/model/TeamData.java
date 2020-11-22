package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TeamData extends AbstractTableModel{

	//Ez a tagváltozó tárolja a csapatok adatait (heterogén kollekció)
	List<Team> teams = new ArrayList<Team>();
	
	public void addFootballTeam(String name, ArrayList<Member> members, String coach1, String coach2) {
		teams.add(new Football(coach1, coach2, name, members));
	}
	

	public void printTeams() {
		for (Team team : teams) {
			System.out.println(team.toString());
		}
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
		
		switch(columnIndex) {
		case 0:
			return tempTeam.getID().toString().substring(0,6);
		case 1: 
			return tempTeam.getName();
		case 2: 
			return tempTeam.getMemberNo();
		case 3: 
			return tempTeam.getAdditioinalInformation();
		}
		return "undefinded";
	}
}
