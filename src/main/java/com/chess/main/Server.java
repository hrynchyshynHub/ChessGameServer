package com.chess.main;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ivan.hrynchyshyn on 15.11.2017.
 */
public class Server {
    private static ServerSocket socket;
    private int port;
    private Socket clientSocket;
    private List<ClientHandler> clients;
    private ClientHandler clienthandler;
    private AtomicInteger connectionCount;
    private static final Logger logger = Logger.getLogger(Server.class);

    public Server(int port) {
        this.port = port;
        clients = Collections.synchronizedList(new ArrayList<>());
    }

    public Server() {
        try {
            socket = new ServerSocket(5556, 0, InetAddress.getByName("localhost"));
            clients = Collections.synchronizedList(new ArrayList<>());
        } catch (IOException e) {
            logger.warn(e);
        }
    }
    public void start() throws IOException{
        logger.info("Server starting.....");
        socket = new ServerSocket(port);
    }

    public void handle(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                Socket clientSocket = socket.accept();
                clienthandler = new ClientHandler(clientSocket, clients);
                new Thread(clienthandler).start();
                clients.add(clienthandler);
                System.out.println("Connection " + connectionCount.incrementAndGet());
            } catch (IOException e) {
                logger.warn(e);
            }

        }
    }

    public void end() {
        try {
            socket.close();
            logger.info("Server ended");
        } catch (IOException e) {
            logger.warn(e);
        }
    }

}
