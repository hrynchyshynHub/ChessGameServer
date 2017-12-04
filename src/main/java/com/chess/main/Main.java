package com.chess.main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Server server = new Server(5556);
        server.start();
        server.handle();
        server.end();
    }
}
