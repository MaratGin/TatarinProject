package org.openjfx;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SecondaryController {
    @FXML
    public Label code;

    @FXML
    private void switchToPrimary(Stage stage) throws IOException {

    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        App.setRoot("primary");
    }

    public void generatePort(){
        Random random=new Random();
        int rage=9999;
        int generator=1000+random.nextInt(rage-1000);

        String port = String.valueOf(generator);
        code.setText(port);

    }

//    public void onDragDetected(MouseEvent mouseEvent) {
//           codeLabel.setFill(Color.WHITE);
//
//    }
}