package it.edu.itiszuccante.mc.thread;

import it.edu.itiszuccante.mc.control.Agente;
import it.edu.itiszuccante.mc.control.Gioco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    public Agente ag;
    private Gioco g;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    /**
     * Costruttore
     * @param socket socket
     * @param g oggetto Gioco
     * @throws IOException
     */
    public ServerThread(Socket socket, Gioco g) throws IOException {
        this.socket = socket;
        this.g = g;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    /**
     * Metodo run che si mette in attesa dei comandi dal client
     */
    @Override
    public void run() {
        while(true){
            String line = null;
            try {
                line = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] elm = line.split(" ");
            switch (elm[0]){
                case "join":
                    ag.setName(elm[1]);
                    g.addAgent(this);
                    break;
                case "status" :
                    out.println(g.getTurniRimasti());
                    break;
                case "board":
                    out.println(ag.getX()+";"+ag.getY()+";"+g.scacchiera.getNeighborhood(ag.getX(), ag.getY()));
                    break;
            }
        }
    }

    /**
     * Chiede la mossa al client e muove l'agente
     */
    public void askMove(){
        out.println("move");
        String line = null;
        try {
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ag.setMove(Integer.parseInt(line));  //setto la mossa con quello che mi risponde il client
    }

    /**
     * Termina la comunicazione
     */
    public void end(){
        out.println("end");
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
