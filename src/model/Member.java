package model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Member {
	Calendar birthday;
	String fullName;
	String sex;
	UUID ID;
	
	Member(String name, String sex, Calendar birthday){
		this.fullName = name;
		this.sex = sex;
		this.birthday = birthday;
		ID = UUID.randomUUID();
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}
	
	
}
