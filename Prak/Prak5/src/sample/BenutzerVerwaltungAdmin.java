package sample;

import prak4gemklassen.Benutzer;
import prak4gemklassen.NutzerVerwaltungException;

import java.io.*;
import java.util.ArrayList;

/*
 * Implementierung von BenutzerAdmin
 * Verwaltet Benutzer des Systems:
 * löschen, eintragen oder ueberpruefen ob Benutzer eingetragen ist
 */

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

	private static ArrayList<Benutzer> userList =  new ArrayList<Benutzer>();
    private static boolean local;

	public BenutzerVerwaltungAdmin(boolean local){
	    this.local = local;
	    System.out.println("Konstruktor BenutzerVerwaltungAdmin");
	    try{
	        if(this.local)
                new FileInputStream("fos_local.s");
	        else
	            new FileInputStream("fos_remote.s");
        } catch (FileNotFoundException e) {
            try {
                writeUserList();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

	@SuppressWarnings("unchecked")
	private static void readUserList() throws IOException, ClassNotFoundException{
        ObjectInputStream is;
	    if(local) {
	        System.out.println("readUserList local");
            is = new ObjectInputStream(new FileInputStream("fos_local.s"));
        }else {
            System.out.println("readUserList remote");
            is = new ObjectInputStream(new FileInputStream("fos_remote.s"));
        }
	    BenutzerVerwaltungAdmin.userList = (ArrayList<Benutzer>) is.readObject();
	    is.close();
	}

	private void writeUserList() throws FileNotFoundException, IOException {
	    ObjectOutputStream os;
	    if(local) {
            System.out.println("writeUserList local");
            os = new ObjectOutputStream(new FileOutputStream("fos_local.s"));
        }else {
            System.out.println("writeUserList remote");
            os = new ObjectOutputStream(new FileOutputStream("fos_remote.s"));
        }
	    os.writeObject(userList);
		os.close();
	}

	@Override
	public void benutzerEintragen(Benutzer b) throws NutzerVerwaltungException {
	    System.out.println("in benutzerEintragen");
		if(b == null || !(b instanceof Benutzer))
			throw new NutzerVerwaltungException("Object nicht gueltig!\n");

		try {

			BenutzerVerwaltungAdmin.readUserList();

			for(Benutzer b2 : userList) {
				if(b2.getUserId().contentEquals(b.getUserId()))
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

}
