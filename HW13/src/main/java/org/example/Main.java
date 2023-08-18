package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Task1.sendPOST();
        Task1.sendUPDATE();
        Task1.sendDELETE();
        Task1.sendGET();
        Task1.sendGetID(2);
        Task1.sendGetUserName("Brit");

        Task2.comments(1);

        Task3.toDo(1);
    }
}