package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {
 //opoppopo
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        System.out.println("here");
        URL xmlURL = getClass().getResource("/org/openjfx/primary.fxml");
        fxmlLoader.setLocation(xmlURL);
        System.out.println("here");
        Parent root = fxmlLoader.load();

        scene = new Scene(root, 1440, 820);
        Font.loadFont(
                App.class.getResource("/fonts/HelveticaNeueCyr/helveticaneuecyr_black.otf").toExternalForm(),
                10
        );
        scene.getStylesheets().addAll(this.getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}