package model;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Handball extends Team{
	private double annualSponsorship;
	
	public Handball(ArrayList<Member> members, String name, double annualSponsorship) {
		super(members, name);
		this.annualSponsorship = annualSponsorship;
	}
	
	public Handball(){
		super();
		annualSponsorship = 0;
	}
	

	@Override
	public String getAdditioinalInformation() {
		
		return "Évi támogatás összege:  " + annualSponsorship + "Ft";
	}


	@Override
	public void writeToFile(Element teamElement, Document doc) {

		Element handball = doc.createElement("handball");
		teamElement.appendChild(handball);
		
		Element id = doc.createElement("ID");
		id.appendChild(doc.createTextNode(ID.toString()));
		handball.appendChild(id);

		Element nameElement = doc.createElement("name");
		nameElement.appendChild(doc.createTextNode(name));
		handball.appendChild(nameElement);

		Element memberNumber = doc.createElement("memberNumber");
		memberNumber.appendChild(doc.createTextNode(String.valueOf(memberNo)));
		handball.appendChild(memberNumber);	
		
		Element support = doc.createElement("support");
		support.appendChild(doc.createTextNode(String.valueOf(annualSponsorship)));
		handball.appendChild(support);
		
		saveMembers(handball, doc);
	}

	public double getAnnualSponsorship() {
		return annualSponsorship;
	}

	public void setAnnualSponsorship(double annualSponsorship) {
		this.annualSponsorship = annualSponsorship;
	}
	
	
	
	
}
