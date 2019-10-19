package Aufg16;

public class Quader implements Koerper{

	public int lanege, breite, hoehe;
	
	@Override
	public double volumen() {
		return laenge * breite * hoehe;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*@Override
	public int getLaenge() {
		return laenge;
	}

	@Override
	public int getHoehe() {
		return hoehe;
	}

	@Override
	public int getBreite() {
		return breite;
	}

	@Override
	public void setLaenge(int Laenge) {
		laenge = Laenge;
	}

	@Override
	public void setHoehe(int Hoehe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBreite(int Breite) {
		// TODO Auto-generated method stub
		
	}*/

}
