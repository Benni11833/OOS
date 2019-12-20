package prak4serv;

import prak4gemklassen.Benutzer;
import sample.BenutzerVerwaltungAdmin;
import prak4gemklassen.NutzerVerwaltungException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOrb {
    private BenutzerVerwaltungAdmin bv_ref;
    private ObjectInputStream is;
    private ObjectOutputStream os;

    public ServerOrb(BenutzerVerwaltungAdmin bv) throws IOException {
        bv_ref = bv;


        try {
            ServerSocket so = new ServerSocket(1337);
            System.out.println("in ServerOrb: Warte auf Verbindung auf Port 1337!");
            Socket socket = so.accept();
            is = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            int tag = -1;

            try{
                tag = is.readInt();
            }catch(Exception e){
                System.err.println("*** beende jetzt, weil nix mehr kommt.!");
                System.exit(-1);
            }

            switch(tag){
                case 1:
                    try{
                        bv.benutzerEintragen((Benutzer) is.readObject());
                        this.os.writeObject("Benutzer eingetragen!");
                    } catch(NutzerVerwaltungException e){
                        e.printStackTrace();
                    } catch (IOException | ClassNotFoundException e) {
                        this.os.writeObject(e);
                    }
                    os.flush();
                    break;
                case 2:
                    try{
                        bv.benutzerLöschen((Benutzer) is.readObject());
                        this.os.writeObject("Benutzer gelöscht!");
                    } catch(NutzerVerwaltungException e){
                        e.printStackTrace();
                    } catch (IOException | ClassNotFoundException e) {
                        this.os.writeObject(e);
                    }
                    os.flush();
                    break;
                case 3:
                    try{
                        Object ret = bv.benutzerOk((Benutzer) is.readObject());
                        this.os.writeObject(ret);
                    } catch (IOException | ClassNotFoundException e) {
                        this.os.writeObject(e);
                    }
                    os.flush();
                    break;
            }
        }
    }
}
