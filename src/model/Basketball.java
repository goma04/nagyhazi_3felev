package model;

import java.util.ArrayList;

import org.w3c.dom.*;

public class Basketball extends Team{
	private int girlsNo;
	private String leaderName;
	
	
	Basketball(ArrayList<Member> members, String name, int girlsNo, String leaderName) {
		super(members, name);
		this.girlsNo = girlsNo;
		
		
		
		this.leaderName = leaderName;
	}
	
	public Basketball() {
		super();
		this.girlsNo = 0;
		this.leaderName = null;
	}


	@Override
	public String getAdditioinalInformation() {
		
		return "Kosárlabda csapat. Pompom lányok létszáma, vezetõ neve:  " + girlsNo + ",  " + leaderName;
	}


	@Override
	public void writeToFile(Element teamElement, Document doc) {

		Element basketball = doc.createElement("basketball");
		teamElement.appendChild(basketball);
		
		Element id = doc.createElement("ID");
		id.appendChild(doc.createTextNode(ID.toString()));
		basketball.appendChild(id);

		Element nameElement = doc.createElement("name");
		nameElement.appendChild(doc.createTextNode(name));
		basketball.appendChild(nameElement);

		Element memberNumber = doc.createElement("memberNumber");
		memberNumber.appendChild(doc.createTextNode(String.valueOf(memberNo)));
		basketball.appendChild(memberNumber);	
		
		Element girlsNumber = doc.createElement("girlsNo");
		girlsNumber.appendChild(doc.createTextNode(String.valueOf(girlsNo)));
		basketball.appendChild(girlsNumber);
		
		Element leaderNameOfGirls = doc.createElement("leaderName");
		leaderNameOfGirls.appendChild(doc.createTextNode(leaderName));
		basketball.appendChild(leaderNameOfGirls);
		
		saveMembers(basketball, doc);
		
	}

	public int getGirlsNo() {
		return girlsNo;
	}

	public void setGirlsNo(int girlsNo) {
		this.girlsNo = girlsNo;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	
	

}
