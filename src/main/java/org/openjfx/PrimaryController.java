package org.openjfx;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        public void goWinning(MouseEvent mouseEvent) throws IOException {
            App.setRoot("gameField");
        }
    }

