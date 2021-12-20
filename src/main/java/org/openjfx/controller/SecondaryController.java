package org.openjfx.controller;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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

    public int generatePort(){
        Random random=new Random();
        int rage=9999;
        int generator=1000+random.nextInt(rage-1000);
        String port = String.valueOf(generator);
        code.setText(port);
        System.out.println(port);
        return generator;
    }

//    public void onDragDetected(MouseEvent mouseEvent) {
//           codeLabel.setFill(Color.WHITE);
//
//    }
}