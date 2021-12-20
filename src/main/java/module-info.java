/**
 *
 */
module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
    exports org.openjfx.controller;
    opens org.openjfx.controller to javafx.fxml;
}
