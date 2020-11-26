package dataStorage;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;

import model.MemberData;
import model.Team;
import model.Member;
import model.TeamData;
import view.ApplicationFrame;

import java.io.FileNotFoundException;

public class DataController {
	TeamData newTeamData, teamData;
	MemberData newMemberData, memberData;
	JFrame frame;

	public DataController(ApplicationFrame frame) {
		this.frame = frame;
		// this.newMemberData = new MemberData(loadMemberData());
		// this.newTeamData = new TeamData(loadTeamData());

	}

	public void addWindowsListenerToData(TeamData teamData, MemberData memberData) {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					saveData(teamData, memberData);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	private void saveTeamData(TeamData data, Document doc) {

		Element rootElement = doc.createElement("teams");
		doc.appendChild(rootElement);

		// Heterogén kollekció miatt a teamData összes elemén meghívom azt a függvényt,
		// ami menti az adatokat az xml struktúrába
		for (int i = 0; i < data.getRowCount(); i++) {
			Element team = doc.createElement("team");
			rootElement.appendChild(team);

			data.getTeam(i).writeToFile(team, doc);
			
			for (Member member : data.getTeam(i).getMembers()) {
				System.out.println(i + "  " + member.getID().toString());
			}		
			
		}

	}

	// Beleírja a tagok adatait a megadott dokumentumba.
	private void saveMemberData(MemberData data, Document doc) {

		// root element
		Element rootElement = doc.createElement("members");
		doc.appendChild(rootElement);

		for (int i = 0; i < data.getRowCount(); i++) {
			System.out.println("teamdata mentõdik");
			// member element
			Element member = doc.createElement("member");
			rootElement.appendChild(member);

			data.getMember(i).writeToFile(member, doc);
		}

	}

	public void saveData(TeamData teamData, MemberData memberData) {

		System.out.println("saveData()");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document docForTeams = dBuilder.newDocument();
			Document docForMembers = dBuilder.newDocument();

			saveMemberData(memberData, docForMembers);
			saveTeamData(teamData, docForTeams);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource sourceMembers = new DOMSource(docForMembers);
			DOMSource sourceTeams = new DOMSource(docForTeams);
			StreamResult resultMembers = new StreamResult(new File("members.xml"));
			StreamResult resultTeams = new StreamResult(new File("teams.xml"));
			transformer.transform(sourceTeams, resultTeams);
			transformer.transform(sourceMembers, resultMembers);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TeamData loadTeamData() {
		TeamHandler handler = new TeamHandler(memberData);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser p = factory.newSAXParser();
			p.parse(new java.io.File("teams.xml"), handler);
		} catch (Exception e) {
			e.printStackTrace();
			return new TeamData(new ArrayList<Team>());			
		}

		teamData = new TeamData(handler.getTeams());

		
		
		

		return teamData;
	}

	public MemberData loadMemberData() {
		MemberHandler handler = new MemberHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser p = factory.newSAXParser();
			p.parse(new java.io.File("members.xml"), handler);
		} catch (Exception e) {
			return new MemberData(new ArrayList<Member>());
		}

		memberData = new MemberData(handler.getMembers());

		
		

		return memberData;

	}

}
