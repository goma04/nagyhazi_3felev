package dataStorage;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.UUID;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import exception.MemberNotFound;
import model.Basketball;
import model.Football;
import model.Handball;
import model.Member;
import model.MemberData;
import model.Team;
import view.PopUpMessage;

class TeamHandler extends DefaultHandler {
	private ArrayList<Team> list; // Ez lesz a visszat�r�si �rt�k, ahol �tadom a csapatokat
	private ArrayList<Member> members; // Itt t�rol�dnak a csapatokhoz tartoz� tagok
	private MemberData memberData;
	private Football footballTeam;
	private Handball handballTeam;
	private Basketball basketballTeam;
	private boolean nameTag, idTag, memberNumberTag, coach1Tag, coach2Tag, supportTag, girlsNoTag, leaderNameTag,
			isFootball, isHandball, isBasketball, memberTag;


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
		members = new ArrayList<Member>();
	}

	// El�sz�r meg kell n�zni, hogy milyen adathoz �rt, k�s�bb ez alapj�n menti az
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
		} else if(qName.equalsIgnoreCase("ID")) {
			idTag = true;
		}
	}

	// Amikor oda�r az element �ltal t�rolt sz�veghez, fel kell dolgozni
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
			
			memberNumberTag = false;			
		} else if (supportTag) {
			handballTeam.setAnnualSponsorship(Integer.parseInt(new String(ch, start, length)));
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
			try {
				members.add(memberData.getMemberById(new String(ch, start, length)));
			} catch (MemberNotFound e) {
				new PopUpMessage("Hiba a tagok beolvas�sa sor�n! \""+new String(ch, start, length)+"\" azonos�t�j� tag nem tal�lhat�", JOptionPane.ERROR_MESSAGE);
			}
			
			memberTag = false;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("basketball")) {
			basketballTeam.setMembers(members);
			list.add(basketballTeam);

			members = new ArrayList<Member>();
		} else if (qName.equalsIgnoreCase("football")) {
			footballTeam.setMembers(members);
			list.add(footballTeam);
			
			members = new ArrayList<Member>();
		} else if (qName.equalsIgnoreCase("handball")) {
			handballTeam.setMembers(members);
			list.add(handballTeam);
			
			members = new ArrayList<Member>();
		}		
	}

	public ArrayList<Team> getTeams() {
		return list;
	}
}
