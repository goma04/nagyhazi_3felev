package model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Member {
	Calendar birthday;
	String fullName;
	String sex;
	UUID ID;
	
	public Member(String name, String sex, Calendar birthday){
		this.fullName = name;
		this.sex = sex;
		this.birthday = birthday;
		ID = UUID.randomUUID();
	}
	
	public Member(){
		this.fullName = null;
		this.sex = null;
		this.birthday = null;
		ID = null;
	}
	
	
	
	//XML f�jlba menti az adott tagot. A kapott memberElement-re f�zi r� az adatokat.
	public void writeToFile(Element memberElement, Document doc) {
		Element id = doc.createElement("ID");
		id.appendChild(doc.createTextNode(ID.toString()));
		memberElement.appendChild(id);

		Element nameElement = doc.createElement("name");
		nameElement.appendChild(doc.createTextNode(fullName));
		memberElement.appendChild(nameElement);

		Element sexElement = doc.createElement("sex");
		sexElement.appendChild(doc.createTextNode(sex));
		memberElement.appendChild(sexElement);		
		
		
		//El�sz�r sz�mm� alak�tjuk a sz�let�si d�tumot
		String birthdayString = String.valueOf(birthday.get(Calendar.YEAR)) + "-" + String.valueOf(birthday.get(Calendar.MONTH)+1) + "-" + String.valueOf(birthday.get(Calendar.DATE));
		
		Element birthdayElement = doc.createElement("birthday");
		birthdayElement.appendChild(doc.createTextNode(birthdayString));
		memberElement.appendChild(birthdayElement);		
	}
	
	
	
	public String toString() {
		return fullName + " (" + ID.toString().substring(0,6) + ")";
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
