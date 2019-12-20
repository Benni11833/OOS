package prak4client;

import prak4gemklassen.Benutzer;
import prak4gemklassen.NutzerVerwaltungException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientOrb {
    public Socket socket;
    public ObjectOutputStream os;
    public ObjectInputStream is;

    public ClientOrb(){
        try{
            socket = new Socket("localhost", 1337);
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void benutzerEintragen(Benutzer ben) throws NutzerVerwaltungException {
        Object ergebnis;
        try{
            os.writeInt(1);
            os.writeObject(ben);
            os.flush();
            ergebnis = is.readObject();
            try{
                String s = (String) ergebnis;
            }catch(ClassCastException e){
                throw (NutzerVerwaltungException) ergebnis;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("benutzerEintragen fertig");
    }

    public void benutzerLöschen(Benutzer ben) throws NutzerVerwaltungException {
        Object ergebnis;
        try{
            os.writeInt(2);
            os.writeObject(ben);
            os.flush();
            ergebnis = is.readObject();
            try{
                String s = (String) ergebnis;
            }catch(ClassCastException e){
                throw (NutzerVerwaltungException) ergebnis;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("benutzerLöschen fertig");
    }

    public boolean benutzerOk(Benutzer ben) throws NutzerVerwaltungException, IOException, ClassNotFoundException {
        System.out.println("in BenutzerOk - clientOrb");
        Object ergebnis;

            os.writeInt(3);
            os.writeObject(ben);
            os.flush();
            ergebnis = is.readObject();
            try{
               Boolean b = (Boolean) ergebnis;

               return b;
            }catch(ClassCastException e){
                throw (NutzerVerwaltungException) ergebnis;
            }
    }
}
