package sample;

import java.io.*;
import java.util.ArrayList;

/*
 * Implementierung von BenutzerAdmin
 * Verwaltet Benutzer des Systems:
 * löschen, eintragen oder ueberpruefen ob Benutzer eingetragen ist
 */

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

	private static ArrayList<Benutzer> userList =  new ArrayList<Benutzer>();

	@SuppressWarnings("unchecked")
	private static void readUserList() throws IOException, ClassNotFoundException{

			ObjectInputStream is = new ObjectInputStream(new FileInputStream("fos.s"));
			BenutzerVerwaltungAdmin.userList = (ArrayList<Benutzer>) is.readObject();
			is.close();
	}

	private void writeUserList() throws FileNotFoundException, IOException {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("fos.s"));
			os.writeObject(userList);
		 	os.close();
	}

	@Override
	public void benutzerEintragen(Benutzer b) throws NutzerVerwaltungException{
		if(b == null || !(b instanceof Benutzer))
			throw new NutzerVerwaltungException("Object nicht gueltig!\n");

		try {

			BenutzerVerwaltungAdmin.readUserList();

			for(Benutzer b2 : userList) {
				if(b2.userId.contentEquals(b.userId))
					throw new NutzerVerwaltungException("Benutzer: " + b + " ist bereits eingetragen!\n");
			}

			userList.add(b);

			writeUserList();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}


//		for(Benutzer b2 : userList) {
//			if(b2.userId.contentEquals(b.userId))
//				throw new NutzerVerwaltungException("Benutzer: " + b + " ist bereits eingetragen!\n");
//		}
//
//		userList.add(b);

	}

	@Override
	/**
	 * @param: b: Benutzer der ueberprueft werden soll
	 * ueberprueft, ob b in der Liste aller Benutzer vorhanden ist
	 * @return: true, falls User vorhanden
	 * @return false, falls nicht true
	 */
	public boolean benutzerOk(Benutzer b) {
		if(b == null || !(b instanceof Benutzer))
			return false;

		try {

			readUserList();

			for(Benutzer b2 : userList) {
				if(b2.equals(b)) {
					return true;
				}
			}
			return false;

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

//		for(Benutzer b2 : userList) {
//			if(b2.equals(b))
//				return true;
//		}
		return false;
	}

	/**
	 * @return void
	 * @param: b Benutzer der geloscht werden soll
	 * loescht Benutzer b, falls er in der Liste enthalten ist
	 * falls er nicht enthalten ist, wird eine exception geworfen
	 * @throws ClassNotFoundException
	 */
	public void benutzerLöschen(Benutzer b) throws NutzerVerwaltungException {
		if(b == null || !(b instanceof Benutzer))
			throw new NutzerVerwaltungException("Object nicht gueltig!\n");


		 try {

			readUserList();

			 if(benutzerOk(b)) {
				 userList.remove(b);
			 } else {
				 throw new NutzerVerwaltungException("Benutzer: " + b + " ist nicht enthalten!\n");
			 }

			 writeUserList();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

//		if(benutzerOk(b)) {
//			userList.remove(b);
//		}else
//			throw new NutzerVerwaltungException("Benutzer: " + b + " ist nicht enthalten!\n");
//
	}

	public void dbInitialisieren() {
		userList = new ArrayList<Benutzer>();
		try {
			writeUserList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printNewList() {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("fos.s"));
			@SuppressWarnings("unchecked")
			ArrayList<Benutzer> newList = (ArrayList<Benutzer>) is.readObject();
			is.close();

			System.out.println(newList);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*BenutzerVerwaltungAdmin a1 = new BenutzerVerwaltungAdmin();
		//a1.dbInitialisieren();
		try {
			Benutzer b = new Benutzer("0", "hel123lo".toCharArray());
			//a1.benutzerEintragen(b);
			//a1.benutzerEintragen(new Benutzer("0", "hello".toCharArray()));
			//a1.benutzerEintragen(new Benutzer("1", "hello1".toCharArray()));
			//a1.benutzerLöschen(new Benutzer("0", "hel123lo".toCharArray()));
			//a1.benutzerLöschen(new Benutzer("3", "hello".toCharArray()));
			//System.out.println(a1.benutzerOk(new Benutzer("0", "hello".toCharArray())));
			//a1.benutzerLöschen(new Benutzer("0", "hello3".toCharArray()));
			//System.out.println(a1.userList);
			//a1.printNewList();
		}catch(NutzerVerwaltungException e) {
			e.printStackTrace();
		}*/
	}

}
