package a34server;

import a34gemeinsameklasse.MitarbeiterVerwaltung;
import a34gemeinsameklasse.mitarbeiterException;

import java.io.IOException;

public class Server {
    public static void main(String []args){
        MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung();
        ServerOrb server;

        {
            try {
                server = new ServerOrb(mv);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
