package sample;

import javafx.fxml.FXML;

import java.awt.*;

public class myController {
    @FXML
    protected Button runbutton;

    @FXML
    protected void buttonPressed()
    {
        System.out.println("DING DING");
    }
}
