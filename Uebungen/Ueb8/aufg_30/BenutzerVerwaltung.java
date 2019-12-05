package aufg_30;
/**
 * Interface zur Deklaration einer Benutzerverwaltung, die existierende Benutzer verwaltet
 * Methoden tragen einen neuen Bentuzer ein oder ueberprueft, ob ein Benutzer eingetragen ist
 */
public interface BenutzerVerwaltung {
	public void benutzerEintragen(Benutzer b);
	boolean benutzerOk(Benutzer b);
}
