package a34gemeinsameklasse;

public class Angestellter extends Mitarbeiter {
    double grundGehalt;
    double ortsZuschlag;
    double zulage;

    public Angestellter(int persNr, String name, double grundGehalt, double ortsZuschlag, double zulage) {
        super(persNr, name);
        this.grundGehalt = grundGehalt;
        this.ortsZuschlag = ortsZuschlag;
        this.zulage = zulage;
    }

    boolean equals(Angestellter angestellter) {
        return (super.equals(angestellter) && this.grundGehalt == angestellter.grundGehalt
            && this.ortsZuschlag == angestellter.ortsZuschlag && this.zulage == angestellter.zulage);
    }

    public String toString() {
        return (super.toString() + " grundGehalt: " + grundGehalt + " ortsZuschlag: " + ortsZuschlag + " zulage: "
            + zulage);
    }

    public double monatsBrutto() {
        return (grundGehalt + ortsZuschlag + zulage);
    }
}
