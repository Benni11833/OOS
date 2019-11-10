package prak_2;

public interface BenutzerVerwaltung {
	public void benutzerEintragen(Benutzer b) throws NutzerVerwaltungException;
	boolean benutzerOk(Benutzer b);
}
