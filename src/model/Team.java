package model;

import java.util.UUID;

public class Team {
	int letszam;
	UUID ID;
	
	Team(int letszam){
		this.letszam = letszam;
		ID = UUID.randomUUID();
	}
	
	public void printTeam() {
		System.out.println("letszam: " + letszam +"  id: " + ID.toString().substring(0,8));
	}
}
