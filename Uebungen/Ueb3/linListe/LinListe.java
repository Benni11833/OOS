package linListe;

public interface LinListe {
// Die leere Liste wird über den Standardkonstruktor erzeugt      
  public boolean isEmpty();
  public Object head() throws IstLeerException;
  public LinListe tail() throws IstLeerException;
  public LinListe vorhängen(Object obj);
}
