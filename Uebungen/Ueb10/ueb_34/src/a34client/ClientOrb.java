package a34client;

import java.net.*;
import java.io.*;
import a34gemeinsameklasse.Mitarbeiter;

public class ClientOrb {
    public void mitarbeiterEintragen(Mitarbeiter m) throws IOException {

        Socket socket = new Socket("localhost", 4711);
        InputStream socketInput = socket.getInputStream();
        OutputStream socketOutput = socket.getOutputStream();
        ObjectOutputStream socketObjectOutput = new ObjectOutputStream(socket.getOutputStream());

        socketOutput.write(1);
        socketObjectOutput.writeObject(m);

        int response = socketInput.read();
        if(response != 1)
            System.out.println("Mitarbeiter \"" + m + "\" konnte nicht eingetragen werden!");

        socket.close();
    }

    public void mitarbeiterLöschen(Mitarbeiter m) throws IOException {

        Socket socket = new Socket("localhost", 4711);
        InputStream socketInput = socket.getInputStream();
        OutputStream socketOutput = socket.getOutputStream();
        ObjectOutputStream socketObjectOutput = new ObjectOutputStream(socket.getOutputStream());

        socketOutput.write(2);
        socketObjectOutput.writeObject(m);

        int response = socketInput.read();
        if(response != 1)
            System.out.println("Mitarbeiter \"" + m + "\" konnte nicht gelöscht werden!");

        socket.close();
    }

    public void gesamtBrutto() throws IOException {
        Socket socket = new Socket("localhost", 4711);
        InputStream socketInput = socket.getInputStream();
        OutputStream socketOutput = socket.getOutputStream();
        ObjectOutputStream socketObjectOutput = new ObjectOutputStream(socket.getOutputStream());

        socketOutput.write(3);
        int gesamtBrutto = socketInput.read();
        System.out.println("GesamtBrutto: "  + gesamtBrutto);

        socket.close();
    }

    public void durchschnittsBrutto() throws IOException {
        Socket socket = new Socket("localhost", 4711);
        InputStream socketInput = socket.getInputStream();
        OutputStream socketOutput = socket.getOutputStream();
        ObjectOutputStream socketObjectOutput = new ObjectOutputStream(socket.getOutputStream());

        socketOutput.write(4);
        int durchschnittsBrutto = socketInput.read();
        System.out.println("DurchschnittsBrutto: " + durchschnittsBrutto);

        socket.close();
    }
}
