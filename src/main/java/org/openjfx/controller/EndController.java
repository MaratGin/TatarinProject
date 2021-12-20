package org.openjfx.controller;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EndController {

    public void goMainScene(MouseEvent mouseEvent) throws IOException {
        App.setRoot("primary");
    }
}
