package dataStorage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.PopupFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import model.MemberData;
import model.TeamData;
import view.ApplicationFrame;
import view.PopUpMessage;

public class DataController {
	private TeamData teamData;
	private MemberData memberData;

	public DataController(ApplicationFrame frame) {
		
		loadMemberData();
		loadTeamData();
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					saveData(teamData, memberData);				
			}
		});		
	}

	private void saveTeamData(TeamData data, Document doc) {
		
		Element rootElement = doc.createElement("teams");
		doc.appendChild(rootElement);

		// Heterogén kollekció miatt a teamData összes elemén meghívom azt a függvényt,
		// ami menti az adatokat az xml struktúrába
		if(data!=null) {
			for (int i = 0; i < data.getRowCount(); i++) {
				Element team = doc.createElement("team");
				rootElement.appendChild(team);

				data.getTeam(i).writeToFile(team, doc);
			}
		}
	}

	// Beleírja a tagok adatait a megadott dokumentumba.
	private void saveMemberData(MemberData data, Document doc) {

		// root element
		Element rootElement = doc.createElement("members");
		doc.appendChild(rootElement);

		for (int i = 0; i < data.getRowCount(); i++) {
			// member element
			Element member = doc.createElement("member");
			rootElement.appendChild(member);

			data.getMember(i).writeToFile(member, doc);
		}
	}

	private void saveData(TeamData teamData, MemberData memberData) {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document docForTeams = dBuilder.newDocument();
			Document docForMembers = dBuilder.newDocument();

			saveMemberData(memberData, docForMembers);
			saveTeamData(teamData, docForTeams);

			//Beírjuk az adatokat az XML fájlba
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
			new PopUpMessage("Hiba a fájl mentése alatt",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void loadTeamData() {
		TeamHandler handler = new TeamHandler(memberData);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser p = factory.newSAXParser();
			p.parse(new java.io.File("teams.xml"), handler);
			teamData = new TeamData(handler.getTeams());
		} catch (FileNotFoundException e) {
			teamData = null;
		} catch (Exception e) {
			new PopUpMessage("Hiba a betöltés során", JOptionPane.ERROR_MESSAGE);
		} 		
	}

	private void loadMemberData() {
		MemberHandler handler = new MemberHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser p = factory.newSAXParser();
			p.parse(new java.io.File("members.xml"), handler);
			memberData = new MemberData(handler.getMembers());
		} catch (FileNotFoundException e) {
			memberData = null;
		} catch (Exception e) {
			new PopUpMessage("Hiba a betöltés során", JOptionPane.ERROR_MESSAGE);
		} 		
	}

	public TeamData getTeamData() {
		return teamData;
	}
	
	public MemberData getMemberData() {
		return memberData;
	}

}
