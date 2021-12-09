package org.openjfx.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) {

    }
    public void startConnection(String ip, int port){
        try {
            // создаем подключение
            clientSocket = new Socket(ip, port);
            // получили выходной поток
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            // входной поток
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // запустили слушателя сообщений
            new Thread(receiverMessagesTask).start();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

    public void sendMessage(String message) {
        out.println(message);
    }

    private  Runnable receiverMessagesTask = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    String response = in.readLine();
                    if (response != null) {
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    };

    public void stopConnection(){
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


}
