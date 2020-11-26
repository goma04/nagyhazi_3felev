package model;

import java.util.UUID;

import org.w3c.dom.*;

import exception.ElementAlreadyInList;

import java.awt.AWTEvent;
import java.util.ArrayList;

public abstract class Team {
	int memberNo;
	UUID ID;
	ArrayList<Member> members; 
	String name;
	
	Team(ArrayList<Member> members, String name){
		this.memberNo = members.size();
		this.name = name;
		this.ID = UUID.randomUUID();
		this.members = members;
	}
	
	Team(){
		this.memberNo = 0;
		this.name = null;
		this.ID = null;
		this.members = null;
	}
	
	public String toString() {
		return name + " (" + ID.toString().substring(0,6) + ")";
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
	
	public void removeMember(Member member) {
		members.remove(member);
		memberNo--;
	}
	
	public void addMember(Member member) throws ElementAlreadyInList{
		if(members.contains(member))
			throw new ElementAlreadyInList("This member is already in the ArrayList");
		
		members.add(member);
		memberNo++;
	}

	

	public int getMemberNo() {
		return memberNo;
	}

	public String getName() {
		return name;
	}
	
	
	
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected void saveMembers(Element element, Document doc) {
		
		for (int i=0; i<members.size(); i++) {
			Element member = doc.createElement("member");
			member.appendChild(doc.createTextNode(members.get(i).getID().toString()));
			element.appendChild(member);
			
			//System.out.println("Azonosító a tagnak: " + members.get(i).getID().toString());
		}
		
		
		
	}
	
	
	//A root elemhez írja hozzá az adatokat
	public abstract void writeToFile(Element teamElement, Document doc);
	
	

	public abstract String getAdditioinalInformation();

	public Member getMember(int i) {
		return members.get(i);
	}
	
	
	
}
