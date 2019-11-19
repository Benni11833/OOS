package prak_2;
/**
 * Interface zur Deklaration einer Benutzerverwaltung, die existierende Benutzer verwaltet
 * Methoden tragen einen neuen Bentuzer ein oder ueberprueft, ob ein Benutzer eingetragen ist
 */
public interface BenutzerVerwaltung {
	public void benutzerEintragen(Benutzer b) throws NutzerVerwaltungException;
	boolean benutzerOk(Benutzer b);
}
