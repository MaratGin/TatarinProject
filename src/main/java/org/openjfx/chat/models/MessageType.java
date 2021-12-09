package org.openjfx.chat.models;

import java.io.Serializable;

public enum MessageType implements Serializable {
    NICKNAME,
    ROOM,
    MESSAGE,
    CONNECTION,
    ERROR
}
//public enum MessageType {
//    CONNECT("connect", "Подключение к серверу"),
//    ACTION("action", "Действие игрока"),
//    CHAT("chat", "Сообщение другим пользователям");
//
//    private final String title;
//    private final String description;
//
//    MessageType(String title, String description) {
//        this.title = title;
//        this.description = description;
//    }
//
////    public String getTitle() {
////        return title;
////    }
////
////    public String getDescription() {
////        return description;
////    }
//
//    @Override
//    public String toString() {
//        return "MessageType{" +
//                "title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
//}
