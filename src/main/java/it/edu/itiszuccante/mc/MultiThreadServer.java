package it.edu.itiszuccante.mc;

import it.edu.itiszuccante.mc.thread.ServerThread;
import it.edu.itiszuccante.mc.control.Gioco;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
    public static final int SERVER_LISTEN_PORT = 41041;
    private static Gioco g;
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVER_LISTEN_PORT);
            while(true) {
                Socket socket = server.accept();
                Thread t = new ServerThread(socket, g);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setG(Gioco g) {
        MultiThreadServer.g = g;
    }
}
