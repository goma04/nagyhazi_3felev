package dataStorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Basketball;
import model.Football;
import model.Handball;
import model.Member;
import model.MemberData;
import model.Team;
import model.TeamData;

public class TeamHandler extends DefaultHandler {
	private ArrayList<Team> list; // Ez lesz a visszatérési érték, ahol átadom a csapatokat
	private ArrayList<Member> members; // Itt tárolódnak a csapatokhoz tartozó tagok
	private MemberData memberData;
	private Football footballTeam;
	private Handball handballTeam;
	private Basketball basketballTeam;
	private String memberId, teamId;
	private boolean nameTag, idTag, memberNumberTag, coach1Tag, coach2Tag, supportTag, girlsNoTag, leaderNameTag,
			isFootball, isHandball, isBasketball, memberTag;
	private int memberNumberTemp;
	private int counter;

	TeamHandler(MemberData memberData) {
		list = new ArrayList<Team>();
		nameTag = false;
		memberNumberTag = false;
		coach1Tag = false;
		coach2Tag = false;
		supportTag = false;
		girlsNoTag = false;
		leaderNameTag = false;
		isFootball = false;
		isHandball = false;
		isBasketball = false;
		idTag = false;
		memberTag = false;
		this.memberData = memberData;
		counter = 0;
		
	}

	// Elõször meg kell nézni, hogy milyen adathoz ért, késõbb ez alapján menti az
	// adatot
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("football")) {
			footballTeam = new Football();
			isFootball = true;
		} else if (qName.equalsIgnoreCase("handball")) {
			handballTeam = new Handball();
			isHandball = true;
		} else if (qName.equalsIgnoreCase("basketball")) {
			basketballTeam = new Basketball();
			isBasketball = true;
		} else if (qName.equalsIgnoreCase("name")) {
			nameTag = true;
		} else if (qName.equalsIgnoreCase("memberNumber")) {
			memberNumberTag = true;
		} else if (qName.equalsIgnoreCase("support")) {
			supportTag = true;
		} else if (qName.equalsIgnoreCase("girlsNo")) {
			girlsNoTag = true;
		} else if (qName.equalsIgnoreCase("leaderName")) {
			leaderNameTag = true;
		} else if (qName.equalsIgnoreCase("coach1")) {
			coach1Tag = true;
		} else if (qName.equalsIgnoreCase("coach2")) {
			coach2Tag = true;
		} else if (qName.equalsIgnoreCase("member")) {
			memberTag = true;

			if (counter == 0) {
				members = new ArrayList<Member>();
				counter++;
			} else if (counter == memberNumberTemp - 1) {
				counter = 0;
				
				
			} else {				
				
			}
		} else if(qName.equalsIgnoreCase("ID")) {
			idTag = true;
		}
	}

	// Amikor odaér a tag által tárolt szövegjez, fel kell dolgozni
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		
		
		if (nameTag) {
			if (isFootball) {
				footballTeam.setName(new String(ch, start, length));
			} else if (isBasketball) {
				basketballTeam.setName(new String(ch, start, length));
			} else if (isHandball) {
				handballTeam.setName(new String(ch, start, length));
			}
			nameTag = false;
			
		} else if (idTag) {
			teamId = new String(ch, start, length);
			if (isFootball) {
				footballTeam.setID(UUID.fromString(new String(ch, start, length)));
			} else if (isBasketball) {
				basketballTeam.setID(UUID.fromString(new String(ch, start, length)));
			} else if (isHandball) {
				handballTeam.setID(UUID.fromString(new String(ch, start, length)));
			}
			idTag = false;
			
		}else if (memberNumberTag) {
			if (isFootball) {
				footballTeam.setMemberNo(Integer.parseInt(new String(ch, start, length)));
				
				isFootball = false;
			} else if (isBasketball) {
				basketballTeam.setMemberNo(Integer.parseInt(new String(ch, start, length)));
				isBasketball = false;
			} else if (isHandball) {
				handballTeam.setMemberNo(Integer.parseInt(new String(ch, start, length)));
				isHandball = false;
			}
			memberNumberTemp = Integer.parseInt(new String(ch, start, length)); //Azért kell tudni, mert amikor beolvassuk a tagok id-jét, tudni kell mennyi van
			memberNumberTag = false;
			
		} else if (supportTag) {
			handballTeam.setAnnualSponsorship(Double.parseDouble(new String(ch, start, length)));
			supportTag = false;
		}else if(girlsNoTag) {
			basketballTeam.setGirlsNo(Integer.parseInt(new String(ch, start, length)));
			girlsNoTag = false;
		}else if(leaderNameTag) {
			basketballTeam.setLeaderName(new String(ch, start, length));
			leaderNameTag = false;
		}else if(coach1Tag) {
			footballTeam.setCoach1(new String(ch, start, length));
			coach1Tag = false;
		}else if(coach2Tag) {
			footballTeam.setCoach2(new String(ch, start, length));
			coach2Tag = false;
		}else if(memberTag) {
			members.add(memberData.getMemberById(new String(ch, start, length)));
			
			memberTag = false;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("basketball")) {
			basketballTeam.setMembers(members);
			basketballTeam.setMembers(members);
			list.add(basketballTeam);

			members = new ArrayList<Member>();
		} else if (qName.equalsIgnoreCase("football")) {
			footballTeam.setMembers(members);
			footballTeam.setMembers(members);
			list.add(footballTeam);
			
			members = new ArrayList<Member>();
		} else if (qName.equalsIgnoreCase("handball")) {
			handballTeam.setMembers(members);
			handballTeam.setMembers(members);
			list.add(handballTeam);
			
			members = new ArrayList<Member>();
		}
		
	}

	public ArrayList<Team> getTeams() {
		return list;
	}

}
