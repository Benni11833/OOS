package prak4serv;

import sample.BenutzerVerwaltungAdmin;

import java.io.IOException;

public class Server {
    public Server(){
        BenutzerVerwaltungAdmin bv = new BenutzerVerwaltungAdmin();
        try {
            ServerOrb so = new ServerOrb(bv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Server s = new Server();
    }
}
