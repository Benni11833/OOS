package linListe;

public interface LinListe {
// Die leere Liste wird �ber den Standardkonstruktor erzeugt      
  public boolean isEmpty();
  public Object head() throws IstLeerException;
  public LinListe tail() throws IstLeerException;
  public LinListe vorh�ngen(Object obj);
}
