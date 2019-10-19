package Aufg16;

public class Zylinder implements Koerper{

	public int laenge, breite, hoehe;
	
	@Override
	public double volumen() {	//interpretiert breite als durchmesser
		return (Math.PI * breite/2 * hoehe);
	}
	
	Zylinder(int Laenge, int Breite, int Hoehe){
		this.laenge = Laenge;
		this.breite = Breite;
		this.hoehe = Hoehe;
	}
	
	public static void main(String[] args) {
		Zylinder z = new Zylinder(3, 2, 4);
		System.out.println(z.volumen());
	}

}
