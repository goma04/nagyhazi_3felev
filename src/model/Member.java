package model;

import java.util.Date;

public class Member {
	Date birthday;
	String fullName;
	String sex;
	String ID;
	
	Member(String name, String sex, Date birthday){
		this.fullName = name;
		this.sex = sex;
		this.birthday = birthday;
	}
}
