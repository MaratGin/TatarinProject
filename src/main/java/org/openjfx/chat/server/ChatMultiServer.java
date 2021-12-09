package org.openjfx.chat.server;

import org.openjfx.chat.models.Message;
import org.openjfx.chat.models.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatMultiServer {
    // список клиентов
    private List<ClientHandler> clients;
    private Map<Integer,List<Message>> history;
    private  List<Message> firstRoomHistory = new ArrayList<>();
    private  List<Message> secondRoomHistory;
    private  List<Message> thirdRoomHistory;


    ChatMultiServer(){
        Message msg = new Message();
        msg.setText("Hi!");
        msg.setMessageType(MessageType.MESSAGE);
        clients = new CopyOnWriteArrayList<>();
        firstRoomHistory = new ArrayList<>();
        secondRoomHistory = new ArrayList<>();
        thirdRoomHistory = new ArrayList<>();
        firstRoomHistory.add(msg);
        secondRoomHistory.add(msg);
        thirdRoomHistory.add(msg);

        history.put(1,firstRoomHistory);
        history.put(2,secondRoomHistory);
        history.put(3,thirdRoomHistory);
    }

    public void start(int port) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // запускаем бесконечный цикл
        while (true) {
            try {
                // запускаем обработчик сообщений для каждого подключаемого клиента
                new ChatMultiServer.ClientHandler(serverSocket.accept()).start();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }


    private class ClientHandler extends Thread {
        // связь с одним клиентом
        private Socket clientSocket;
        private String name;
        private int room;
        private BufferedReader in;

        ClientHandler(Socket socket) {
            this.clientSocket = socket;
            // добавляем текущее подключение в список
            clients.add(this);
            System.out.println("New client " + socket.getPort());
        }

        @Override
        public void run() {
            // получем входной поток для конкретного клиента
            try {
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while (true) {
                    inputLine = in.readLine();
                    Message message = createMessage(inputLine);
                    if (message.getMessageType() == MessageType.ERROR) {
                        System.out.println("Некорректное сообщение! Напишите что-то другое");
                    } else if (message.getMessageType() == MessageType.NICKNAME) {
                        this.name = message.getText();
                        for (ClientHandler client : clients) {
                            if (client.clientSocket.getPort() == this.clientSocket.getPort()) {
//                                System.out.println("Имя создано успешно! Приветствую, "+ message.getText());
                                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.println("Имя создано успешно! Приветствую, "+ message.getText());
                            }
                        }
                    } else if(message.getMessageType() == MessageType.CONNECTION) {
                        this.room = Integer.parseInt(message.getText());
                        System.out.println("room name:" + this.room);
                        clients.add(this);
                        Message msg = new Message();
                        msg.setMessageType(MessageType.MESSAGE);
                        msg.setText("New roommate joined:" + this.name);
                        history.get(this.room).add(msg);

                        for (ClientHandler client : clients) {
                            if (client.room == this.room) {
                                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.println("New roommate joined:" + this.name);
                            }
                        }
                        for (ClientHandler client : clients) {
                            if (client.name == this.name) {
                                int k = 0;
                                for (Message m: history.get(this.room)) {
                                    if (k<100){
                                        PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                        out.println(m.getText());
                                    }

                                }
                                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.println("New roommate joined:" + this.name);
                            }
                        }

                    } else if (message.getMessageType() == MessageType.MESSAGE) {
                        System.out.println("receive msg from " + name);

                        for (ClientHandler client : clients) {
                            if (client.room == this.room) {
                                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.println(this.name + "said :" + message.getText());
                            }
                        }
                        history.get(this.room).add(message);

                    }


                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            super.run();
        }

        public Message createMessage(String message) {
            Message message1 = new Message();
            if (message.length() > message1.maxLength ) {
                message1.setMessageType(MessageType.ERROR);
                return message1;
            }
            if (message.startsWith("-room")) {
                char[] charArray = message.toCharArray();
                for (char c: charArray) {
                    if (c == '1'|| c == '2'|| c =='3'){

                        message1.setText(String.valueOf(c));
                        message1.setMessageType(MessageType.ROOM);
                        return message1;
                    }
                }
            } else if (message.startsWith("-nick")) {
                String[] stringArray = message.split("-nick ");
                message1.setText(stringArray[0]);
                message1.setMessageType(MessageType.NICKNAME);
                return message1;
            }
            message1.setMessageType(MessageType.ERROR);
            return message1;
        }

    }

}