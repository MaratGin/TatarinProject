package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ThirdController {



    public void goBack(MouseEvent mouseEvent) throws IOException {
        App.setRoot("primary");
    }

    public void goPlay(ActionEvent actionEvent) throws IOException {
        App.setRoot("gameField");
    }

}

