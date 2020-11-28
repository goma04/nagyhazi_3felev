package model;


import java.util.ArrayList;
import java.util.Calendar;


import javax.swing.table.AbstractTableModel;

import exception.MemberNotFound;

//Az AbstractTableModel oszt�ly alap�rtelmezett implement�ci�t ad a TableModel interface-nek, ez�rt �r�k�l t�le
@SuppressWarnings("serial")
public class MemberData extends AbstractTableModel {
	private ArrayList<Member> members;
	
	public MemberData(ArrayList<Member> memberList) {
		members = memberList;
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
	
	public Member getMemberById(String ID) throws MemberNotFound{
		for (Member member : members) {
			if(member.getID().toString().equals(ID)) {
				return member;
			}
		}
		
		throw new MemberNotFound("Member not found");
	}
	

	public void addMember(String name, String sex, Calendar birthday) {
		members.add(new Member(name, sex, birthday));
	}
	

	@Override
	public String getColumnName(int index) {
		switch (index) {
		case 0:
			return "Azonos�t�";
		case 1:
			return "N�v";
		case 2:
			return "Sz�let�si d�tum (�v H�nap nap)";
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
			Calendar birthday = tempMember.getBirthday();
			
			String year = String.valueOf(birthday.get(Calendar.YEAR));
			String month = String.valueOf(birthday.get(Calendar.MONTH));
			String day = String.valueOf(birthday.get(Calendar.DATE));

			return year + " " + month + " " + day;
		case 3:
			return tempMember.getSex();
		default:
			return "undefined";
		}
	}

	//Amikor jcombo box-ban kell megjelen�teni a tagokat, egy t�mbben kell �tadni
	public Object[] getAsArray() {
		return members.toArray();
	}
	
	public Member getMember(int index) {
		return members.get(index);
	}

}
