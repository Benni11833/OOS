package sample;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import prak4client.ClientOrb;
import prak4gemklassen.Benutzer;

public class LoginController {

    public void initialize(MainApplication app){
        System.out.println("LoginController initialize");
        mainApp_ref = app;
    }

    MainApplication mainApp_ref;


    @FXML
    public CheckBox neuAnmeldungCheckBox;
    public CheckBox lokaleVerwaltungCheckbox;
    private boolean neuAnmeldung = false;
    public TextField userIdTextField;
    public PasswordField passwordTextField;

    @FXML
    public void neuAnmeldungCheckBoxAction(ActionEvent e){
        neuAnmeldung = neuAnmeldungCheckBox.isSelected();
        //System.out.println("Neu Anmeldung: " + neuAnmeldung);
    }

    public void ausfuehrenButton(ActionEvent e){

        if(lokaleVerwaltungCheckbox.isSelected())
            mainApp_ref.local();
        else
            mainApp_ref.remote();

        Benutzer user = new Benutzer(userIdTextField.getText(), passwordTextField.getText().toCharArray());

        if(neuAnmeldung){
            mainApp_ref.neuAnmeldung();
        }else{
            mainApp_ref.benutzerLogin(user);
        }

    }

    public TextField getTextField(){
        return userIdTextField;
    }
}
