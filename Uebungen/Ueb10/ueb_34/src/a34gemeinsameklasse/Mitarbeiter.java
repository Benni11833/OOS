package a34gemeinsameklasse;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Mitarbeiter implements Serializable {
    int persNr;
    String name;

    public abstract double monatsBrutto();

    Mitarbeiter(int persNr, String name) {
        this.persNr = persNr;
        this.name = name;
    }

    public String toString() {
        return ("PersNr: " + persNr + " Name: " + name);
    }

    public boolean equals(Mitarbeiter m) {
        return (this.persNr == m.persNr && this.name.equals(m.name));
    }

    public boolean Id_In_Array(ArrayList<Mitarbeiter> mitarbeiterList) {
        for (Mitarbeiter m : mitarbeiterList)
            if (m.persNr == this.persNr)
                return true;

        return false;
    }
}
