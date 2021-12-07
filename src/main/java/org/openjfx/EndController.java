package org.openjfx;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EndController {

    public void goMainScene(MouseEvent mouseEvent) throws IOException {
        App.setRoot("primary");
    }
}
