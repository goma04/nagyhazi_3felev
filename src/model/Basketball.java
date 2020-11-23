package model;

import java.util.ArrayList;

public class Basketball extends Team{
	private int girlsNo;
	private String leaderName;
	
	
	Basketball(ArrayList<Member> members, String name, int girlsNo, String leaderName) {
		super(members, name);
		this.girlsNo = girlsNo;
		this.leaderName = leaderName;
	}


	@Override
	public String getAdditioinalInformation() {
		
		return "Pompom lányok létszáma, vezetõ neve:  " + girlsNo + ",  " + leaderName;
	}

}
