package dataStorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Member;


//A beolvasott XML fájlt dolgozza fel (tagok) 
public class MemberHandler extends DefaultHandler {
	private ArrayList<Member> list;
	private Member member;
	/*Calendar birthday;
	String fullName;
	String sex;
	UUID ID;*/
	boolean nameTag, idTag, sexTag, birthdayTag;

	MemberHandler() {
		list = new ArrayList<Member>();
		nameTag = false;
		idTag = false;
		sexTag = false;
		birthdayTag = false;
	}

	//Elõször meg kell nézni, hogy milyen adathoz ért, késõbb ez alapján menti az adatot
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("member")) {
			member = new model.Member();
		} else if (qName.equalsIgnoreCase("ID")) {
			idTag = true;
		} else if (qName.equalsIgnoreCase("name")) {
			nameTag = true;
		} else if (qName.equalsIgnoreCase("sex")) {
			sexTag = true;
		} else if (qName.equalsIgnoreCase("birthday")) {
			birthdayTag = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("member")) {
			list.add(member);
		}
	}

	
	//Amikor odaér a tag által tárolt szövegjez, fel kell dolgozni
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (idTag) {
			member.setID(UUID.fromString(new String(ch, start, length)));
			idTag = false;
		} else if (nameTag) {
			member.setFullName(new String(ch, start, length));
			nameTag = false;
		} else if (sexTag) {
			member.setSex(new String(ch, start, length));
			sexTag = false;
		} else if (birthdayTag) {
			Calendar birthday = Calendar.getInstance();

			String date[] = (new String(ch, start, length)).split("-");
			int year = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]);
			int day = Integer.parseInt(date[2]);
			
			birthday.set(year, month , day, 0, 0);
			member.setBirthday(birthday);
			birthdayTag = false;
		}
	}

	public ArrayList<Member> getMembers() {
		return list;
	}

}
