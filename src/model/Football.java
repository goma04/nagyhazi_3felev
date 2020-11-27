package model;

import java.util.ArrayList;

import org.w3c.dom.*;

public class Football extends Team {
	private String[] coachNames;

	Football(String coach1, String coach2, String name, ArrayList<Member> members) {
		super(members, name);
		coachNames = new String[2];
		coachNames[0] = coach1;
		coachNames[1] = coach2;
	}

	public Football() {
		super();
		coachNames = new String[2];
	}
	
	public String[] getCoachNames() {
		return coachNames;
	}
	
	public void setCoach1(String name) {
		coachNames[0] = name;
	}
	
	public void setCoach2(String name) {
		coachNames[1] = name;
		
	}

	@Override
	public String getAdditioinalInformation() {
		return "Football csapat. Edzõk nevei:  " + coachNames[0] + ", " + coachNames[1];
	}

	

	@Override
	public void writeToFile(Element teamElement, Document doc) {

		Element football = doc.createElement("football");
		teamElement.appendChild(football);
		
		
		Element id = doc.createElement("ID");
		id.appendChild(doc.createTextNode(ID.toString()));
		football.appendChild(id);

		Element nameElement = doc.createElement("name");
		nameElement.appendChild(doc.createTextNode(name));
		football.appendChild(nameElement);

		Element memberNumber = doc.createElement("memberNumber");
		memberNumber.appendChild(doc.createTextNode(String.valueOf(memberNo)));
		football.appendChild(memberNumber);

		Element coach1 = doc.createElement("coach1");
		coach1.appendChild(doc.createTextNode(coachNames[0]));
		football.appendChild(coach1);

		Element coach2 = doc.createElement("coach2");
		coach2.appendChild(doc.createTextNode(coachNames[1]));
		football.appendChild(coach2);
		
		

		saveMembers(football, doc);
	}

}
