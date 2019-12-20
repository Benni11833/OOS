package a34client;

import a34gemeinsameklasse.Angestellter;
import a34gemeinsameklasse.Arbeiter;
import a34gemeinsameklasse.Manager;

import java.io.IOException;

public class Client {

    public static void main(String []args){
        Manager manager = new Manager(1, "Alex", 1, 2, 3, 4, 5);
        Angestellter angestellter = new Angestellter(0, "Herbert", 14, 15, 16);
        Arbeiter arbeiter = new Arbeiter(3, "Herbert", 14, 15, 16, 17, 18);

        ClientOrb clientOrb = new ClientOrb();

        try {
            //clientOrb.mitarbeiterLöschen(manager);
            clientOrb.durchschnittsBrutto();
            clientOrb.mitarbeiterEintragen(arbeiter);
            clientOrb.durchschnittsBrutto();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
