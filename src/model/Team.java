package model;

import java.util.UUID;
import java.util.ArrayList;

public abstract class Team {
	int memberNo;
	UUID ID;
	ArrayList<Member> members; 
	String name;
	
	Team(ArrayList<Member> members, String name){
		this.memberNo = members.size();
		this.name = name;
		ID = UUID.randomUUID();
		this.members = members;
	}
	
	public void printTeam() {
		System.out.println("letszam: " + memberNo +"  id: " + ID.toString().substring(0,8));
	}
	
	public void setMemberNo(int i) {
		memberNo = i;
	}

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	

	public int getMemberNo() {
		return memberNo;
	}

	public String getName() {
		return name;
	}
	
	

	public abstract String getAdditioinalInformation();
	
	
	
}
