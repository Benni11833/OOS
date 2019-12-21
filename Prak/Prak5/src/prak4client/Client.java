package prak4client;

import prak4gemklassen.Benutzer;
import prak4gemklassen.NutzerVerwaltungException;
import sample.MainApplication;

import java.io.IOException;

public class Client {
    public Client() throws NutzerVerwaltungException {
        ClientOrb clientOrb = new ClientOrb();
        try {
            Benutzer b = new Benutzer("1", "h".toCharArray());
            //clientOrb.benutzerEintragen(b);
            System.out.println(clientOrb.benutzerOk(b));
        } catch (NutzerVerwaltungException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        MainApplication mainApplication = new MainApplication();
        mainApplication.launchApp(args);
    }
}
