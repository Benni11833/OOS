import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    Client() throws IOException{
        Socket server = new Socket("localhost", 4711);
        InputStream in = server.getInputStream();
        OutputStream out = server.getOutputStream();

        System.out.println("Zahlen(kleiner 256) zum summieren eingeben. Mit \'0\' beenden.");
        Scanner cli_input = new Scanner(System.in);
        int readInput = 0;
        do{
            readInput = cli_input.nextInt();
            out.write(readInput);
        }while(readInput != 0);

        System.out.println("resultat: " + in.read());
        server.close();
    }

    public static void main(String []args){
        try {
            Client client = new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
