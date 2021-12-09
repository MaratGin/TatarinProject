package org.openjfx.chat.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Message implements Serializable {
    public int maxLength = 50;
    private MessageType messageType;
    private String text;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
//public class Message {
//
//    private Map<String, String> headers;
//    private MessageType type;
//    private String body;
//
//    public Message() {
//        this.headers = new HashMap<>();
//    }
//
//    public void addHeader(String type, String header) {
//        headers.put(type, header);
//    }
//
//    public Map<String, String> getHeaders() {
//        return headers;
//    }
//
//    public void setHeaders(Map<String, String> headers) {
//        this.headers = headers;
//    }
//
//    public MessageType getType() {
//        return type;
//    }
//
//    public void setType(MessageType type) {
//        this.type = type;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//}

//public enum Message {
//    DATE,
//    USERNAME
//
//}
