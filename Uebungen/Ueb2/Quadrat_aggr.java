package Ueb2;

public class Quadrat_aggr {

	Point linksOben, rechtsUnten;
	int Laenge, Breite;
	
	Quadrat_aggr(int Laenge, int Breite){
		this.linksOben = new Point();
		this.rechtsUnten = new Point(linksOben.x + Breite, linksOben.y + Laenge);
		this.Laenge = Laenge;
		this.Breite = Breite;
	}
	
	Quadrat_aggr(int Laenge, int Breite, Point linksOben, Point rechtsUnten){
		this.linksOben = linksOben;
		if(linksOben.x + Breite == rechtsUnten.x && linksOben.y + Laenge == rechtsUnten.y)
			this.rechtsUnten = rechtsUnten;
		else {
			System.out.println("Fehlerhafter Punkt -> " + rechtsUnten.toString() + ", Bei Breite: " + Breite + " und/oder Laenge: " + Laenge);
			this.rechtsUnten = new Point(linksOben.x + Breite, linksOben.y + Laenge);
		}
		this.Laenge = Laenge;
		this.Breite = Breite;
	}
	
	
	boolean equals(Quadrat_aggr q) {
		return (this.linksOben.equals(q.linksOben) && this.rechtsUnten.equals(q.rechtsUnten)
				&& this.Laenge == q.Laenge && this.Breite == q.Breite);
	}
	
	public String toString() {
		return (
				"Laenge: " + this.Laenge + ", Breite: " + this.Breite +
				", LinksOben: " + this.linksOben.toString() + ", RechtsUnten: "
				+ this.rechtsUnten.toString()
			);
	}
	
	public static void main(String[] args) {
		Quadrat_aggr q_aggr = new Quadrat_aggr(3, 4, new Point(1, 2), new Point(3, 3));
		System.out.println(q_aggr);
	}

}
