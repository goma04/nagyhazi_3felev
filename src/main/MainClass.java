package main;

import controller.MemberController;
import controller.TeamController;
import model.MemberData;
import model.TeamData;
import view.*;

import dataStorage.*;

public class MainClass {
	public static void main(String args[]) {		
		ApplicationFrame frame = new ApplicationFrame();
		frame.setVisible(true);	
		
		
		DataController dataController = new DataController(frame);
		
		
		MemberData memberData = dataController.loadMemberData();
		TeamData teamData = dataController.loadTeamData();
		
		dataController.addWindowsListenerToData(teamData, memberData);
		
		new TeamController(memberData,teamData, frame);
		new MemberController(memberData,teamData, frame);		
		
	}
}
