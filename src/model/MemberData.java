package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class MemberData {
	List<Member> members = new ArrayList<Member>();
	
	public void addMember(String name, String sex, Date birthday) {
		members.add(new Member(name,sex,birthday));
	}
	
	public void printData() {
		for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }
	}
	
}
