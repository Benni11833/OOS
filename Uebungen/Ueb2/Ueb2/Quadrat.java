package Ueb2;

public class Quadrat extends Point{	//Point gibt linke oberen Eckpunkt an
	
	double Laenge, Breite;
	
	Quadrat(double Laenge, double Breite){
		super();
		this.Laenge = Laenge;
		this.Breite = Breite;
	}
	
	Quadrat(double Laenge, double Breite, Point p){
		super(p.x, p.y);
		this.Laenge = Laenge;
		this.Breite = Breite;
	}
	
	Quadrat(double Laenge, double Breite, int x, int y){
		super(x, y);
		this.Laenge = Laenge;
		this.Breite = Breite;
	}
	
	boolean equals(Quadrat q) {
		return (super.equals(q) && this.Laenge == q.Laenge && this.Breite == q.Breite);
	}
	
	public String toString() {
		return (
				"Laenge: " + this.Laenge + ", Breite: " + this.Breite
				+", " + super.toString()
			);
	}

	public static void main(String[] args) {
		//Quadrat myQuad = new Quadrat(3, 3, 1, 1);
		Quadrat myQuad = new Quadrat(3, 4, new Point(2, -2));
		System.out.println(myQuad);
	}

}
