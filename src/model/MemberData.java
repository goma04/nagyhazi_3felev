package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;

//Az AbstractTableModel osztály alapértelmezett implementációt ad a TableModel interface-nek, ezért örököl tõle
public class MemberData extends AbstractTableModel {
	private ArrayList<Member> members;
	
	public MemberData(ArrayList<Member> memberList) {
		members = memberList;
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}

	public Member getMemberById(String ID) {
		System.out.println("A KEresett ID: " + ID);
		for (Member member : members) {
			System.out.println("ID:: " +member.getID());
			if(member.getID().toString().equals(ID)) {
				
				return member;
			}
		}
		
		return null; //MemberNotFoundException?
	}
	

	public void addMember(String name, String sex, Calendar birthday) {
		members.add(new Member(name, sex, birthday));
	}

	// Megadja hogy hány tag tárolódik
	public int memberNumber() {
		return members.size();
	}

	
	public void printData() {
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).getFullName() + " " + members.get(i).getSex() + " "
					+ members.get(i).getBirthday().get(Calendar.YEAR) + " "
					+ members.get(i).getBirthday().get(Calendar.MONTH) + " "
					+ members.get(i).getBirthday().get(Calendar.DATE) + " " + members.get(i).getID().toString());
		}
	}

	@Override
	public String getColumnName(int index) {
		switch (index) {
		case 0:
			return "Azonosító";
		case 1:
			return "Név";
		case 2:
			return "Születési dátum (Év Hónap nap)";
		case 3:
			return "Nem";
		}
		return "undefined";
	}

	@Override
	public int getRowCount() {
		return members.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		Member tempMember = members.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return tempMember.getID().toString().substring(0, 6);
		case 1:
			return tempMember.getFullName();
		case 2:
			String year = String.valueOf(tempMember.getBirthday().get(Calendar.YEAR));
			String month = String.valueOf(tempMember.getBirthday().get(Calendar.MONTH));
			String day = String.valueOf(tempMember.getBirthday().get(Calendar.DATE));

			return year + " " + month + " " + day;
		case 3:
			return tempMember.getSex();
		default:
			return "undefined";
		}
	}

	//Amikor jcombo box-ban kell megjeleníteni a tagokat, egy tömbben kell átadni
	public Object[] getAsArray() {
		return members.toArray();
	}
	
	public Member getMember(int index) {
		return members.get(index);
	}

}
