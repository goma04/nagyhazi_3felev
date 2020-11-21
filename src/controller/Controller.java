package controller;
import model.*;
import view.ApplicationFrame;

public class Controller {
	private TeamData teamData;
	private MemberData memberData;
	private ApplicationFrame view;
	
	public Controller(MemberData memberData, TeamData teamData){
		this.teamData = teamData;
		this.memberData = memberData;
	}
	
	public void printTeams() {
		teamData.printData();
	}

}
