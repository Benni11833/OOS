package sample;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    LoginController(MainApplication mainApp){
        MainApplication mainApllication_ref = mainApp;
    }

    @FXML
    public CheckBox neuAnmeldungCheckBox;
    private boolean neuAnmeldung = false;
    public TextField userIdTextField;
    public PasswordField passwordTextField;

    @FXML
    public void neuAnmeldungCheckBoxAction(ActionEvent e){
        neuAnmeldung = neuAnmeldungCheckBox.isSelected();
        System.out.println("Neu Anmeldung: " + neuAnmeldung);
    }

    public void ausfuehrenButton(ActionEvent e){
        Benutzer user = new Benutzer(userIdTextField.getText(), passwordTextField.getText().toCharArray());
        System.out.println(user);
        Stage stage = (Stage) neuAnmeldungCheckBox.getScene().getWindow();
        stage.close();
    }
}
