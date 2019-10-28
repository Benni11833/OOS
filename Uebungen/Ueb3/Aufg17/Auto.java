package Aufg17;

public class Auto implements Cloneable{

	String typ, farbe;
	int bauJahr, inspeaktionsIntervall;
	private int kmStand;
	
	private static int anzahlErzeugteAutos = 0, gesamtLeistung = 0;
	
	Auto(String farbe, String typ,int kmStand, int bauJahr, int inspeaktionsIntervall){
		++anzahlErzeugteAutos;
		gesamtLeistung += kmStand;
		this.farbe = farbe;
		this.typ = typ;
		this.bauJahr = bauJahr;
		this.kmStand = kmStand;
		this.inspeaktionsIntervall = inspeaktionsIntervall;
	}
	
	Auto(){
		++anzahlErzeugteAutos;
		bauJahr = kmStand = inspeaktionsIntervall = 0;
		typ = farbe = "X";
	}
	
	int kmBisInspeaktion() {
		return (inspeaktionsIntervall - (kmStand%inspeaktionsIntervall));
	}
	
	int alter(int aktJahr) {
		return (aktJahr - bauJahr);
	}
	
	public String toString() {
		return ("Farbe: " + farbe + ", Typ: " + typ + ", BauJahr: " + bauJahr 
				+  "km Stand: " + kmStand + "km, inspeaktionsIntervall: " + inspeaktionsIntervall);
	}
	
	public void setKmStand(int kmStand) {
		gesamtLeistung -= this.kmStand;
		this.kmStand = kmStand;
		gesamtLeistung += this.kmStand;
	}
	
	public static int getGesamtLeistung() {
		return gesamtLeistung;
	}
	
	public static double kmDurchschnitt() {
		return gesamtLeistung / (double) anzahlErzeugteAutos;
	}
	
	public static int getAnzahlAutos() {
		return anzahlErzeugteAutos;
	}
	
	public boolean equals(Auto a2) {
		return (this.typ.equals(a2.typ) && this.farbe.equals(a2.farbe)
				&& this.bauJahr == a2.bauJahr && this.kmStand == a2.kmStand
				&& this.inspeaktionsIntervall == a2.inspeaktionsIntervall);
	}
	
	protected Object clone(Auto a2) throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void finalize() {
		--anzahlErzeugteAutos;
		gesamtLeistung -= kmStand;
		System.out.println("RIP ein Auto -> " + anzahlErzeugteAutos);
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Auto a1 = new Auto("Rot", "Mercedes", 30, 1980, 1337);
		System.out.println(a1);
		Auto a2 = new Auto();
		System.out.println(a2);
		a2 = (Auto)a1.clone();
		System.out.println(a2.equals(a1));
		System.out.println("DurchSChn. KmStand: " + Auto.kmDurchschnitt());
		System.gc();
		System.out.println("Erzeugte Autos: " + Auto.anzahlErzeugteAutos);
		System.out.println("Erzeugte Autos: " + Auto.anzahlErzeugteAutos);
		System.out.println("Erzeugte Autos: " + Auto.anzahlErzeugteAutos);
		System.out.println("Erzeugte Autos: " + Auto.anzahlErzeugteAutos);
	}

}
