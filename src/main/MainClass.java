package main;
import controller.Controller;
import model.MemberData;
import model.TeamData;
import view.*;

public class MainClass {
	public static void main(String args[]) {		
		ApplicationFrame frame = new ApplicationFrame();
		frame.setVisible(true);
		
		TeamData teamData = new TeamData();
		MemberData memberData = new MemberData();
		
		
		
		Controller controller = new Controller(memberData,teamData, frame);
		

		
		
		

		
		
	}
}
