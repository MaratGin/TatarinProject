package org.openjfx.controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class PrimaryController {

//    private void switchToSecondary(ActionEvent actionEvent) throws IOException {
//        App.setRoot("secondary");
//    }

    public void switchToThird(ActionEvent actionEvent) throws IOException {
        App.setRoot("third");

    }

    public void switchToEndController(ActionEvent actionEvent) throws IOException {
        App.setRoot("endScreen");
    }

    public void goToChat(ActionEvent actionEvent) throws IOException {
        App.setRoot("chat");
    }

    public void switchToSecondary(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
}

