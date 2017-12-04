package com.chess.main;

import com.chess.util.Move;
import com.chess.util.Player;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Move move;
    private List<ClientHandler> clients;
    private static final Logger logger = Logger.getLogger(Server.class);


    public ClientHandler(Socket clientSocket, List<ClientHandler> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients;
        try {
            oos = new ObjectOutputStream(this.clientSocket.getOutputStream());
            ois = new ObjectInputStream(this.clientSocket.getInputStream());
        } catch (IOException e) {
            logger.warn(e);
        }

    }
    private void readData(){
        try {
            if (ois.available() <= 0){
               move  = (Move) ois.readObject();
            }
        } catch (IOException e) {
           logger.warn(e);
        } catch (ClassNotFoundException e) {
            logger.warn(e);
        }
    }

    private void writeData(Move move){
        try {
            oos.writeObject(move);
            oos.flush();
        } catch (IOException e) {
            logger.warn(e);
        }
    }
    private void writeToAll(){
        clients.forEach( client -> {
            client.writeData(move);
        });

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            readData();
            writeToAll();
        }
    }

}

