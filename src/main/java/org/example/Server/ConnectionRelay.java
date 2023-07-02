package org.example.Server;
import org.example.Server.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionRelay {
    public ConnectionRelay(int port) {
        System.out.println("strongHold server started.");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                Connection connection = new Connection(socket);
                connection.start();
            }
        } catch (IOException e) {
        }
    }
}