package sample;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import prak4gemklassen.Benutzer;

public class AnmeldungsController {
    public void initialize(MainApplication mainApplication) {
        System.out.println("AnmeldungsControlleri initialize");
        mainApp_ref = mainApplication;
    }

    MainApplication mainApp_ref;

    @FXML
    public TextField userIdTextField;
    public PasswordField passwordTextField;
    public PasswordField passwordTextField_wiederholung;

    @FXML
    public void validatePassword(ActionEvent e) {
        if (passwordTextField.getText().equals(passwordTextField_wiederholung.getText())) {
            /*System.out.println("Passwörter stimmen überein");
            Benutzer user = new Benutzer(userIdTextField.getText(), passwordTextField.getText().toCharArray());
            System.out.println(user);
            Stage stage = (Stage) userIdTextField.getScene().getWindow();
            stage.close();*/

            try {
                Benutzer user = new Benutzer(userIdTextField.getText(), passwordTextField.getText().toCharArray());
                mainApp_ref.neuerBenutzer(user);
            } catch (Exception ex) {
                userIdTextField.setText("Fehler beim Registrieren des Benutzers");
                //ex.printStackTrace();
            }

        } else {
            //System.out.println("Passwörter stimme nicht überein");
            userIdTextField.setText("Passwort != Wiederholung");
        }
    }

    public TextField getTextField(){
        return userIdTextField;
    }

}
