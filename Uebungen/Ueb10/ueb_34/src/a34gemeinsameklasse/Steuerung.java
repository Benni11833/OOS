package a34gemeinsameklasse;

public class Steuerung {

    public static void main(String args[]) {
        MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung();
        Manager manager = new Manager(1, "Alex", 1, 2, 3, 4, 5);
        Angestellter angestellter = new Angestellter(0, "Herbert", 14, 15, 16);
        Arbeiter arbeiter = new Arbeiter(3, "Herbert", 14, 15, 16, 17, 18);
        try {
            mv.mitarbeiterEintragen(manager);
            mv.mitarbeiterEintragen(angestellter);
            mv.mitarbeiterEintragen(arbeiter);
        } catch (mitarbeiterException e) {
            e.printStackTrace();
        }
        System.out.println("GesamtBrutto: " + mv.gesamtBrutto());
        System.out.println("Durchschnittl. Brutto: " + mv.durchschnittsBrutto());
    }
}
