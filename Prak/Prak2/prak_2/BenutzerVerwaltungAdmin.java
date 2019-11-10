package prak_2;

import java.util.ArrayList;
import java.util.Arrays;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

	private static ArrayList<Benutzer> userList =  new ArrayList<Benutzer>();
	
	public void benutzerEintragen(Benutzer b) throws NutzerVerwaltungException{
		//Ueberpruefen ob UserId schon vergeben:
		for(Benutzer b2 : userList)
			if(b2.userId == b.userId)
				throw new NutzerVerwaltungException("userId \'" + b.userId 
						+ "\' ist bereits vergeben!");	
		
		userList.add(b);
	}

	@Override
	public boolean benutzerOk(Benutzer b) {
		for(Benutzer b2 : userList) {
			if(b2.userId == b.userId && Arrays.equals(b2.passWort, b.passWort))
				return true;
		}
		return false;
	}
	
	public void benutzerLöschen(Benutzer b) throws NutzerVerwaltungException{
		for(Benutzer b2 : userList) {
			if(b2.userId == b.userId && Arrays.equals(b2.passWort, b.passWort)) {
				userList.remove(b2);
				return;
			}
		}
		throw new NutzerVerwaltungException("Kein Benutzer " + b + " in der UserListe enthalten!");
	}

	public static void main(String[] args) {
		BenutzerVerwaltungAdmin a1 = new BenutzerVerwaltungAdmin();
		try {
			//Benutzer b = new Benutzer("0", "hello".toCharArray());
			a1.benutzerEintragen(new Benutzer("0", "hello".toCharArray()));
			a1.benutzerEintragen(new Benutzer("1", "hello".toCharArray()));
			//a1.benutzerLöschen(new Benutzer("0", "hello".toCharArray()));
			//a1.benutzerLöschen(new Benutzer("3", "hello".toCharArray()));
			//System.out.println(a1.benutzerOk(new Benutzer("0", "hello".toCharArray())));
			System.out.println(a1.userList);
		}catch(NutzerVerwaltungException e) {
			e.printStackTrace();
		}
	}

}
