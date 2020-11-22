package model;

import java.util.ArrayList;

public class Football extends Team{
	String[] coachNames;
	
	public Football(String coach1, String coach2, String name, ArrayList<Member> members) {
		super(members, name);
		coachNames = new String[2];
		coachNames[0] = coach1;
		coachNames[1] = coach2;
	}

	public String[] getCoachNames() {
		return coachNames;
	}

	

	@Override
	public String getAdditioinalInformation() {
		return "Name of coaches: " + coachNames[0] + ", " + coachNames[1];
	}
	
	public String toString() {
		String[] memberInfos = new String[members.size()];
		String result = "name: " + name + "\ncoach1: " + coachNames[0] + "\ncoach2: " + coachNames[1] + "\nid:" + ID.toString() + "\nmembers:\n ";
		
		for (int i = 0; i < members.size(); i++) {
			result += members.get(i).toString() + "\n";			
		}
		
		
		return result;
	}
	
	
	
}
