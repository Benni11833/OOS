package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import prak4client.ClientOrb;
import prak4gemklassen.Benutzer;
import prak4gemklassen.NutzerVerwaltungException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication extends Application {
    private Stage stage;

    private LoginController loginController;
    private AnmeldungsController anmeldungsController;
    private AnwendungsController anwendungsController;
    private ClientOrb clientOrb;
    private BenutzerVerwaltungAdmin localVerwaltung = null;

    public void launchApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        stage.setTitle("Benutzerverwaltung");

        showLoginScene();
        stage.show();
    }

    public void local(){
        if(localVerwaltung != null)
            return;
        System.out.println("Locale");
        localVerwaltung = new BenutzerVerwaltungAdmin(true);
        //localVerwaltung.dbInitialisieren();
        return;
    }

    public void remote(){
        if(this.clientOrb != null)
            return;
        System.out.println("Remote");
        this.clientOrb = new ClientOrb();
        return;
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
            if(loginController.lokaleVerwaltungCheckbox.isSelected())
                localVerwaltung.benutzerEintragen(user);
            else
                this.clientOrb.benutzerEintragen(user);
            showLoginScene();
        } catch (NutzerVerwaltungException e) {
            //e.printStackTrace();
            anmeldungsController.getTextField().setText("Fehler bein Registrieren des Benutzers: " + user);
        }

    }

    public void benutzerLogin(Benutzer user) {
        try {
            if(loginController.lokaleVerwaltungCheckbox.isSelected()) {
                if (localVerwaltung.benutzerOk(user)) {
                    showAnmeldungsScene();
                } else {
                    loginController.getTextField().setText("Fehler beim lokalen einloggen des Benutzers: " + user);
                }
            }else{
                if (this.clientOrb.benutzerOk(user)) {
                    showAnmeldungsScene();
                } else {
                    loginController.getTextField().setText("Fehler beim remote einloggen des Benutzers: " + user);
                }
            }
        } catch (NutzerVerwaltungException e) {
            loginController.getTextField().setText("Fehler bein einloggen des Benutzers: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
