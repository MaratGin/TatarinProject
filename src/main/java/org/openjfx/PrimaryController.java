package org.openjfx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PrimaryController {

    public Text codeLabel;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void switchToThird(ActionEvent actionEvent) throws IOException {
        App.setRoot("third");

    }

    public void switchToEndController(ActionEvent actionEvent) throws IOException {
        App.setRoot("endScreen");
    }

    public void goToChat(ActionEvent actionEvent) throws IOException {
        App.setRoot("chat");
    }
}

