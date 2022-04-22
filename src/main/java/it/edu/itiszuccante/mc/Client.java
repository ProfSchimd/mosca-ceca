package it.edu.itiszuccante.mc;

import it.edu.itiszuccante.mc.control.Agente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static final int SERVER_LISTEN_PORT = 41041;
    static Agente ag;
    static Socket client;
    static BufferedReader in;
    static PrintWriter out;
    public static void main(String[] args) {
        String hostName = "127.0.0.1";
        try {
            boolean exit = false;
            client = new Socket(hostName, SERVER_LISTEN_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("join" + ag.getName());
            while(true) {
                if (exit){break;}
                String line = null;
                try {
                    line = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] elm = line.split(" ");
                switch (elm[0]){
                    case "move":
                        out.println(ag.getMove());
                        break;
                    case "end" :
                        exit = true;
                        close();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Chiede lo stato del gioco al server
     * @return turni rimanenti
     */
    public static int getStatus(){
        out.println("status");
        String line = null;
        try {
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(line);
    }

    /**
     * Chiede info sulla scacchiera al server e aggiorna l'agente locale
     */
    public static void getBoard(){
        out.println("board");
        String line = null;
        try {
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] elm = line.split(";");
        ag.setX(Integer.parseInt(elm[0]));
        ag.setY(Integer.parseInt(elm[1]));
    }


    /**
     * Termina la comunicazione
     */
    public static void close(){
        try {
            out.close();
            in.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
