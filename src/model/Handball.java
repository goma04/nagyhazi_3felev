package model;

import java.util.ArrayList;

public class Handball extends Team{
	private double annualSponsorship;
	
	Handball(ArrayList<Member> members, String name, double annualSponsorship) {
		super(members, name);
		this.annualSponsorship = annualSponsorship;
	}
	

	@Override
	public String getAdditioinalInformation() {
		
		return "�vi t�mogat�s �sszege:  " + annualSponsorship + "Ft";
	}
	
	
}
