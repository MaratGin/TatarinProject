package org.openjfx.chat;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.openjfx.chat.client.SocketClient;
import org.openjfx.chat.models.Message;
import org.openjfx.chat.models.MessageType;

import java.net.URL;
import java.util.ResourceBundle;

public class Chat implements Initializable {

    private SocketClient socketClient;

    @FXML
    public AnchorPane chatPane;
    @FXML
    public TextField name;
    @FXML
    public Button connectButton;
    @FXML
    public Label helloLabel;
    @FXML
    public ScrollPane messagesArea;
    @FXML
    public VBox messages;
    @FXML
    public VBox messageControl;
    @FXML
    public TextField messageText;
    @FXML
    public Button sendMessageButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        socketClient = new SocketClient();
        socketClient.startConnection("127.0.0.1",8200);
    }

    private void sendMessage() {
        String chatText = messageText.getText();
        messageText.clear();
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE);
        message.setText(chatText);
        socketClient.sendMessage(message.getText());
        Label label = new Label();
        //label.setStyle("-fx-font: Corier new");
        label.setText("Я: " + chatText);
        messages.getChildren().add(label);
    }
}
