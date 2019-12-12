package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication extends Application {
    private Stage stage;
    private BenutzerVerwaltungAdmin bva;

    private LoginController loginController;
    private AnmeldungsController anmeldungsController;
    private AnwendungsController anwendungsController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setTitle("Benutzerverwaltung");

        bva = new BenutzerVerwaltungAdmin();
        bva.dbInitialisieren();

        /*BufferedReader din = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("Soll die DB-initialiert werden(1, 0): ");
        din.readLine();
        if( Integer.parseInt(din.readLine()) != 0)
            bva.dbInitialisieren();*/

        showLoginScene();
        stage.show();
    }



    public void neuAnmeldung() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/anmeldung.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 400, 300));
        anmeldungsController = loader.getController();
        anmeldungsController.initialize(this);
    }

    public void neuerBenutzer(Benutzer user){
        try {
            bva.benutzerEintragen(user);
            showLoginScene();
        } catch (NutzerVerwaltungException e) {
            //e.printStackTrace();
            anmeldungsController.getTextField().setText("Fehler bein Registrieren des Benutzers: " + user);
        }

    }

    public void benutzerLogin(Benutzer user) {
        if(bva.benutzerOk(user)) {
            showAnmeldungsScene();
        }else {
            loginController.getTextField().setText("Fehler bein einloggen des Benutzers: " + user);
        }
    }

    private void showLoginScene() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/login.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 400, 300));
        loginController = loader.getController();
        loginController.initialize(this);
    }

    private void showAnmeldungsScene(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/anwendung.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 400, 150));
        anwendungsController = loader.getController();
        anwendungsController.initialize(this);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
