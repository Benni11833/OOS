package sample;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnmeldungsController {
    @FXML
    public TextField userIdTextField;
    public PasswordField passwordTextField;
    public PasswordField passwordTextField_wiederholung;

    @FXML
    public void validatePassword(ActionEvent e) {
        if (passwordTextField.getText().equals(passwordTextField_wiederholung.getText())) {
            System.out.println("Passwörter stimmen überein");
            Benutzer user = new Benutzer(userIdTextField.getText(), passwordTextField.getText().toCharArray());
            System.out.println(user);
            Stage stage = (Stage) userIdTextField.getScene().getWindow();
            stage.close();
        } else {
            System.out.println("Passwörter stimme nicht überein");
            userIdTextField.setText("Passwort != Wiederholung");
        }
    }
}
