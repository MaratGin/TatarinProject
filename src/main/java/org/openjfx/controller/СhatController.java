package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.openjfx.enums.Action;
import org.openjfx.protocol.Message;
import org.openjfx.protocol.MessageType;
import org.openjfx.sockets.ClientSocket;

import java.net.URL;
import java.util.ResourceBundle;

public class СhatController implements Initializable {

    @FXML
    private VBox messages;

    @FXML
    private TextField messageText;

    @FXML
    private ImageView imageview;

    @FXML
    ScrollPane messageView;


    private ClientSocket clientSocket;

    public void initialize(URL location, ResourceBundle resources){


    }

    private Message createActionMessage(Action action) {
        Message message = new Message();
        message.setType(MessageType.ACTION);
        message.setBody(action.getTitle());
        return message;
    }

    private Message createChatMessage(String text) {
        Message message = new Message();
        message.setType(MessageType.CHAT);
        message.setBody(text);

        return message;
    }

    private void sendMessage() {
        System.out.println(messageText.getText());
        Label messageLabel = new Label();
        messageLabel.setText("Я: " + messageText.getText());
        messages.getChildren().add(messageLabel);

        clientSocket.sendMessage(createChatMessage(messageText.getText()));

        messageText.clear();
    }

    public VBox getMessages() {
        return messages;
    }
}
