package model;

import java.util.UUID;

public class Team {
	int letszam;
	String ID;
	
	Team(int letszam){
		this.letszam = letszam;
		ID = UUID.randomUUID().toString();
	}
	
	public void printTeam() {
		System.out.println("letszam: " + letszam +"  id: " + ID.substring(0,8));
	}
}