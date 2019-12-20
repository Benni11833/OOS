package a34gemeinsameklasse;
public class Manager extends Mitarbeiter {
    double fixGehalt;
    double provision1;
    double provision2;
    double umsatz1;
    double umsatz2;

    public Manager(int persNr, String name, double fixGehalt, double provision1, double provision2, double umsatz1,
                   double umsatz2) {
        super(persNr, name);
        this.fixGehalt = fixGehalt;
        this.provision1 = provision1;
        this.provision2 = provision2;
        this.umsatz1 = umsatz1;
        this.umsatz2 = umsatz2;
    }

    boolean equals(Manager manager) {
        return (super.equals(manager) && this.fixGehalt == manager.fixGehalt && this.provision1 == manager.provision1
            && this.provision2 == manager.provision2 && this.umsatz1 == manager.umsatz1
            && this.umsatz2 == manager.umsatz2);
    }

    public String toString() {
        return (super.toString() + "fixGehalt: " + fixGehalt + " provision1: " + provision1 + " provision2: "
            + provision2 + " umsatz1: " + umsatz1 + " umsatz2: " + umsatz2);
    }

    public double monatsBrutto() {
        return (fixGehalt + umsatz1 * provision1 / 100 + umsatz2 * provision2 / 100);
    }

}
