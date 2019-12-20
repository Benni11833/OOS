package a34gemeinsameklasse;

import a34gemeinsameklasse.Mitarbeiter;
import a34gemeinsameklasse.mitarbeiterException;

import java.util.ArrayList;

public class MitarbeiterVerwaltung {
    ArrayList<Mitarbeiter> firmenMitarbeiter = new ArrayList<Mitarbeiter>();

    public void mitarbeiterEintragen(Mitarbeiter m) throws mitarbeiterException {

        if (m.Id_In_Array(firmenMitarbeiter))
            throw new mitarbeiterException("Mitarbeiter " + m + " bereits eingetragen!");

        firmenMitarbeiter.add(m);
    }

    public void mitarbeiterLöschen(Mitarbeiter m) throws mitarbeiterException {
        if (!m.Id_In_Array(firmenMitarbeiter))
            throw new mitarbeiterException("Mitarbeiter " + m + " wurde nicht gefunden!");

        firmenMitarbeiter.remove(m);
    }

    public int gesamtBrutto() {
        int sum = 0;
        for (Mitarbeiter m : firmenMitarbeiter)
            sum += m.monatsBrutto();

        return sum;
    }

    public int durchschnittsBrutto() {
        if(firmenMitarbeiter.size() == 0)
            return 0;
        return gesamtBrutto() / firmenMitarbeiter.size();
    }
}
