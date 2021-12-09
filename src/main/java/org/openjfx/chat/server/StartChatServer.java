package org.openjfx.chat.server;

public class StartChatServer {
    public static void main(String[] args) {
        ChatMultiServer server = new ChatMultiServer();
        server.start(8200);
    }
}
