package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*primaryStage.setTitle("Benutzerverwaltung");

        //showAnwendungsScene(primaryStage);
        //showLoginScene(primaryStage);
        showAnmeldungsScene(primaryStage);
        primaryStage.show();*/

        BenutzerVerwaltungAdmin bva = new BenutzerVerwaltungAdmin();
        BufferedReader din = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("Soll die DB-initialiert werden(1, 0): ");
        if( Integer.parseInt(din.readLine()) != 0)
            bva.dbInitialisieren();
        
    }

    public void showAnwendungsScene(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/anwendung.fxml"));
        primaryStage.setScene(new Scene(root, 400, 150));
    }

    public void showLoginScene(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/login.fxml"));
        primaryStage.setScene(new Scene(root, 400, 300));
    }

    public void showAnmeldungsScene(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/anmeldung.fxml"));
        primaryStage.setScene(new Scene(root, 400, 300));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
