package controller;


import javax.swing.JMenuItem;
import model.*;
import view.*;

abstract class Controller {
	protected TeamData teamData;
	protected MemberData memberData;
	protected ApplicationFrame frame;
	protected JMenuItem[] menuItems;
	

	Controller(MemberData memberData, TeamData teamData, ApplicationFrame AFrame) {
		this.teamData = teamData;
		this.memberData = memberData;
		this.frame = AFrame;
		menuItems = AFrame.getMenuItems();		
	}
}
