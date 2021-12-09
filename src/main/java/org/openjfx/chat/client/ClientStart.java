package org.openjfx.chat.client;
import java.util.Scanner;

public class ClientStart {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocketClient client = new SocketClient();
        client.startConnection("127.0.0.1", 8200);
        System.out.println("Добро пожаловать! Введите свой ник с помощью команды -nick");
        String message = scanner.nextLine();
        client.sendMessage(message);
        System.out.println("Выберите комнату: 1)Флудилка \n 2)Чат группы \n 3)Общий чат \n  Введите название комнаты с помощью команды -room");
        message = scanner.nextLine();
        client.sendMessage(message);
        while (true) {
            message = scanner.nextLine();
            client.sendMessage(message);
        }
    }


}
