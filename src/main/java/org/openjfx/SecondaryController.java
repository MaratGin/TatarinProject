package org.openjfx;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SecondaryController {
    @FXML
    public Text codeLabel;

    @FXML
    private void switchToPrimary(Stage stage) throws IOException {

    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        App.setRoot("primary");
    }


//    public void onDragDetected(MouseEvent mouseEvent) {
//           codeLabel.setFill(Color.WHITE);
//
//    }
}