import java.net.*;
import java.io.*;

public class Server {
    Server() throws IOException{
        ServerSocket server = new ServerSocket(4711);
        while( true ){
            Socket client = server.accept();
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            int resultat = 0, input = 0;
            do{
                input = in.read();
                resultat += input;
            }while(input != 0);
            out.write(resultat);
        }
    }

    public static void main(String[] args){
        try {
            Server server = new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
