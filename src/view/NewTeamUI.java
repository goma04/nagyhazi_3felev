package view;


import java.awt.GridLayout;
import javax.swing.*;
import model.MemberData;



public class NewTeamUI extends NewThingUI {
	private JButton foci, kosar, kezi, addMember;
	private JTextField coach1, coach2, girlNumber, leaderName, annualSponsorship, name;
	private JComboBox<Object> members;
	private boolean football, handball, basketball; //azt mondják meg, hogy amikor mentünk csapatot, melyik csapatot választotta a felhasználó (tehát épp milyen csapatot kell felvenni)

	public NewTeamUI(ApplicationFrame frame) {
		super(frame);

		foci = new JButton("Labdarugás");
		kosar = new JButton("Kosárlabda");
		kezi = new JButton("Kézilabda");
		addMember = new JButton("Felvétel");
		coach1 = new JTextField();
		coach2 = new JTextField();
		girlNumber = new JTextField();
		leaderName = new JTextField();
		name = new JTextField();
		annualSponsorship = new JTextField();
		football =false;
		handball =false;
		basketball =false;
	}

	// Megjeleníti azt a menüpontot, ahol ki kell választani a sportágat
	public void displayChooseSport() {
		frame.removeOldComponents();
		frame.setTitle("Csapat felvétele");

		System.out.println("displayChooseSport");

		top.add(new JLabel("Válassz a sportágak közül!"));
		top.validate(); // Frissítjük a tartalmat ezzel a függvénnyel

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // Hogy ne lógjon rá a szélére
		center.setLayout(new GridLayout(1, 3, 10, 10));
		center.add(foci);
		center.add(kezi);
		center.add(kosar);

		setComponentsVisible();
		center.validate();
	}

	// Új focicsapat felvételekor megjeleníti a szükséges elemeket
	public void displayFootball() {
		frame.removeOldComponents();
		coach1.setText("");
		coach2.setText("");

		top.add(new JLabel("Adja meg a csapat adatait!"));

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		center.setLayout(new GridLayout(5, 2, 10, 10));

		center.add(new JLabel("1. edzõ neve: "));
		center.add(coach1);
		center.add(new JLabel("2. edzõ neve: "));
		center.add(coach2);

		displayName();

		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		vissza.setActionCommand("stage1"); // innen a csapatválasztóba kell visszalépni
		tovabb.setText("Tovább");
		bottomButtons();
		top.validate();
		center.validate();
		bottom.validate();
		frame.pack();
	}

	private void displayName() {
		center.add(new JLabel("Csapat neve: "));
		name.setText("");
		center.add(name);
	}

	// Új kosárlabda csapat felvételekor megjeleníti a szükséges elemeket
	public void displayBasketball() {
		frame.removeOldComponents();

		top.add(new JLabel("Adja meg a csapat adatait!"));

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		center.setLayout(new GridLayout(5, 2, 10, 10));

		center.add(new JLabel("Pompom lányok létszáma: "));
		center.add(girlNumber);
		center.add(new JLabel("Pompom lányok vezetõjének a neve: "));
		center.add(leaderName);
		displayName();

		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		tovabb.setText("Tovább");
		vissza.setActionCommand("stage1"); // innen a csapatválasztóba kell visszalépni
		bottomButtons();
		top.validate();
		center.validate();
		bottom.validate();
		frame.pack();
	}

	public void displayHandball() {
		frame.removeOldComponents();

		top.add(new JLabel("Adja meg a csapat adatait!"));

		center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		center.setLayout(new GridLayout(5, 2, 10, 10));

		fantomPanel(2, center);
		center.add(new JLabel("Évi támogatás mértéke: "));
		center.add(annualSponsorship);
		displayName();

		setComponentsVisible();
		tovabb.setActionCommand("tovabbNewTeam");
		tovabb.setText("Tovább");
		vissza.setActionCommand("stage1"); // innen a csapatválasztóba kell visszalépni
		bottomButtons();
		top.validate();
		center.validate();
		bottom.validate();
		frame.pack();
	}

	
	
	
	//Miután megadtuk egy csapat adatait, lehetõség van tagokat felvenni. Az ehhez szükséges combo boxot és label-t jeleníti meg
	public void displayFinalStageBottom(MemberData memberData) {
		
		
		//A jcombobox egy Object tömböt vár
		Object[] memberInfo = memberData.getAsArray();

		members = new JComboBox<Object>(memberInfo);
		bottom.add(members);
		addMember.setVisible(true);
		bottom.add(addMember);
		tovabb.setText("Mentés");
		tovabb.setActionCommand("saveTeam");
		bottom.add(new JPanel()); //Hogy jobban szét lehessen választani
		
		bottomButtons();
		bottom.validate();
	}
	
	
	
	
	public JComboBox<Object> getMembers() {
		return members;
	}

	public void setMembers(JComboBox<Object> members) {
		this.members = members;
	}

	public JButton getAddMember() {
		return addMember;
	}
	
	public JButton getFoci() {
		return foci;
	}

	public void setFoci(JButton foci) {
		this.foci = foci;
	}

	public JButton getKosar() {
		return kosar;
	}

	public void setKosar(JButton kosar) {
		this.kosar = kosar;
	}

	public JButton getKezi() {
		return kezi;
	}

	public void setKezi(JButton kezi) {
		this.kezi = kezi;
	}

	public JTextField getCoach1() {
		return coach1;
	}

	public void setCoach1(JTextField coach1) {
		this.coach1 = coach1;
	}

	public JTextField getCoach2() {
		return coach2;
	}

	public void setCoach2(JTextField coach2) {
		this.coach2 = coach2;
	}

	public JTextField getGirlNumber() {
		return girlNumber;
	}

	public void setGirlNumber(JTextField girlNumber) {
		this.girlNumber = girlNumber;
	}

	public JTextField getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(JTextField leaderName) {
		this.leaderName = leaderName;
	}
	
	public boolean getFootball() {
		return football;
	}
	
	public boolean getBasketball() {
		return basketball;
	}
	
	public boolean getHandball() {
		return handball;
	}
	
	
	
	public void setFootball(boolean football) {
		this.football = football;
	}

	public void setHandball(boolean handball) {
		this.handball = handball;
	}

	public void setBasketball(boolean basketball) {
		this.basketball = basketball;
	}

	public void setAllSportFalse() {
		handball = false;
		basketball = false;
		football = false;
	}

	public JTextField getName() {
		return name;
	}
	
	public JTextField getAnnualSponsorship() {
		
		return annualSponsorship;
	}

	
	
	

}
