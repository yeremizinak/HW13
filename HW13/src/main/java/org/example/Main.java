package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Parse.sendPOST();
        Parse.sendUPDATE();
        Parse.sendDELETE();
        Parse.sendGET();
        Parse.sendGetID(2);
        Parse.sendGetUserName("Brit");
    }
}