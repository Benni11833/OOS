package a34server;

import a34gemeinsameklasse.Mitarbeiter;
import a34gemeinsameklasse.MitarbeiterVerwaltung;
import a34gemeinsameklasse.mitarbeiterException;

import java.net.*;
import java.io.*;

public class ServerOrb {
    MitarbeiterVerwaltung mitarbeiterVerwaltung_reference;
    public ServerOrb(MitarbeiterVerwaltung mitarbeiterVerwaltung_ref) throws IOException, ClassNotFoundException {
        mitarbeiterVerwaltung_reference = mitarbeiterVerwaltung_ref;
        ServerSocket serverSocket = new ServerSocket(4711);

        while( true ){
            Socket client = serverSocket.accept();
            InputStream socketInput = client.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            OutputStream socketOutput = client.getOutputStream();

            int methodNumber = socketInput.read();
            switch (methodNumber){
                case 1:
                    try {
                        mitarbeiterVerwaltung_ref.mitarbeiterEintragen((Mitarbeiter) objectInputStream.readObject());
                        System.out.println("DINGS2");
                        socketOutput.write(1);
                    } catch (mitarbeiterException e) {
                        socketOutput.write(-2);
                    }
                    break;
                case 2:
                    try {
                        mitarbeiterVerwaltung_ref.mitarbeiterLöschen((Mitarbeiter) objectInputStream.readObject());
                        System.out.println("DINGS3");
                        socketOutput.write(1);
                    } catch (mitarbeiterException e) {
                        socketOutput.write(-2);
                    }
                    break;
                case 3:
                    int gesamtBrutto = -1;
                    gesamtBrutto = mitarbeiterVerwaltung_ref.gesamtBrutto();
                    socketOutput.write(gesamtBrutto);
                    break;
                case 4:
                    int durchschnittsBrutto = -1;
                    durchschnittsBrutto = mitarbeiterVerwaltung_ref.durchschnittsBrutto();
                    socketOutput.write(durchschnittsBrutto);
                    break;
                default:
                    socketOutput.write(-1);
                    break;
            }
        }
    }
}
