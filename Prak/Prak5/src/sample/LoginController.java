package sample;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    public void initialize(MainApplication app){
        System.out.println("LoginController initialize");
        mainApp_ref = app;
    }

    MainApplication mainApp_ref;


    @FXML
    public CheckBox neuAnmeldungCheckBox;
    private boolean neuAnmeldung = false;
    public TextField userIdTextField;
    public PasswordField passwordTextField;

    @FXML
    public void neuAnmeldungCheckBoxAction(ActionEvent e){
        neuAnmeldung = neuAnmeldungCheckBox.isSelected();
        //System.out.println("Neu Anmeldung: " + neuAnmeldung);
    }

    public void ausfuehrenButton(ActionEvent e){
        System.out.println("In Ausfuehren");
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
