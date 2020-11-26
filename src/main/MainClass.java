package main;
import java.util.ArrayList;

import controller.Controller;
import model.Member;
import model.MemberData;
import model.Team;
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
		
		new Controller(memberData,teamData, frame);
		
		

		

		
		
		

		
		
	}
}
