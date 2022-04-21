package it.edu.itiszuccante.mc.thread;

import it.edu.itiszuccante.mc.control.Agente;
import it.edu.itiszuccante.mc.control.Gioco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.google.gson.Gson;

public class ServerITP extends Thread{
    public Agente ag;
    private Gioco g;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerITP(Socket socket, Gioco g) throws IOException {
        this.socket = socket;
        this.g = g;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        //logica
    }

    public void askMove(){
        out.write("move");
        out.newLine();
        out.flush();

        ag.setMossa();  //setto la mossa con quello che mi risponde il client
    }

    private void end(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
