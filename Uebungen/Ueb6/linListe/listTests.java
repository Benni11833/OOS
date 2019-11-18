package linListe;

public class listTests {

	public static void main(String[] args) {
		MeineListe m1 = new MeineListe(), m2 = new MeineListe();
		try {
			m1 = (MeineListe) m1.vorhängen(3);
			m2 = (MeineListe) m2.vorhängen(3);
			
			m1 = (MeineListe) m1.vorhängen("Hallo");
			m2 = (MeineListe) m2.vorhängen("Hallo");
			
			m1 = (MeineListe) m1.vorhängen(17.7);
			m2 = (MeineListe) m2.vorhängen(17.7);
			
			m2 = (MeineListe) m2.vorhängen(2);
			
			System.out.println("M1: " + m1);
			System.out.println("M2: " + m2);
			System.out.println("M1 == M2: " + m1.equals(m2));
			try {
				System.out.println("M1.tail: " + m1.tail());
			} catch (IstLeerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
