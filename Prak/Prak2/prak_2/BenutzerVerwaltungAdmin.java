package prak_2;

import java.util.ArrayList;

/*
 * Implementierung von BenutzerAdmin
 * Verwaltet Benutzer des Systems:
 * löschen, eintragen oder ueberpruefen ob Benutzer eingetragen ist
 */

import java.util.Arrays;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

	private static final ArrayList<Benutzer> userList =  new ArrayList<Benutzer>();
	
	@Override
	public void benutzerEintragen(Benutzer b) throws NutzerVerwaltungException{
		if(!benutzerOk(b))
			userList.add(b);
		else
			throw new NutzerVerwaltungException("Benutzer: " + b + " ist bereits eingetragen!\n");
		 
	}

	@Override
	/**
	 * @param: b: Benutzer der ueberprueft werden soll
	 * ueberprueft, ob b in der Liste aller Benutzer vorhanden ist
	 * @return: true, falls User vorhanden
	 * @return false, falls nicht true
	 */
	public boolean benutzerOk(Benutzer b) {//contains
		//return userList.contains(b);
		for(Benutzer b2 : userList) {
			if(b2.userId.equals(b.userId))
				return true;
		}
		return false;
	}
	
	/**
	 * @return void
	 * @param: b Benutzer der geloscht werden soll
	 * loescht Benutzer b, falls er in der Liste enthalten ist
	 * falls er nicht enthalten ist, wird eine exception geworfen
	 */
	public void benutzerLöschen(Benutzer b) throws NutzerVerwaltungException{
		if(benutzerOk(b)) {
			userList.remove(b);
		}else
			throw new NutzerVerwaltungException("Benutzer: " + b + " ist nicht enthalten!\n");
	}

	public static void main(String[] args) {
		BenutzerVerwaltungAdmin a1 = new BenutzerVerwaltungAdmin();
		try {
			Benutzer b = new Benutzer("0", "hel123lo".toCharArray());
			//a1.benutzerEintragen(b);
			a1.benutzerEintragen(new Benutzer("0", "hello".toCharArray()));
			a1.benutzerEintragen(new Benutzer("1", "hello1".toCharArray()));
			a1.benutzerLöschen(new Benutzer("0", "hello".toCharArray()));
			//a1.benutzerLöschen(new Benutzer("3", "hello".toCharArray()));
			//System.out.println(a1.benutzerOk(new Benutzer("0", "hello".toCharArray())));
			a1.benutzerLöschen(new Benutzer("0", "hello3".toCharArray()));
			System.out.println(a1.userList);
		}catch(NutzerVerwaltungException e) {
			e.printStackTrace();
		}
	}

}
