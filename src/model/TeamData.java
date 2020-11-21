package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamData {

	//Ez a tagváltozó tárolja a csapatok adatait (heterogén kollekció)
	List<Team> teams = new ArrayList<Team>();
	
	public void addTeam(int letszam) {
		teams.add(new Team(letszam));
	}
	
	public void printData() {
		for (int i = 0; i < teams.size(); i++) {
            teams.get(i).printTeam();
        }
	}
}
