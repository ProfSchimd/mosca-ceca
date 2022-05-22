package it.edu.itiszuccante.mc;
import java.io.*;
public class Server extends Thread{

    private File fileserver= new File("fileserver.csv");
    private int porta;
    private boolean accessibility;
    private int max;
    private int rate;

    public Server(int porta) {

    }

    /**
     *metodo della classe Thread che viene eseguito nel momento dell'apertura della connessione
     */
    @Override
    public void run(){

    }

    /**
     *salva i file di log del gioco, se il file non esiste viene creato
     */
    public synchronized void saveGameData(){

    }

    /**
     *mette in pausa il gioco per un tempo prestabilito
     */
    public void pauseGame(int ms){

    }

    /**
     *termina il gioco arrestando il server
     */
    public void terminateGame(){

    }

    /**
     *setta accesibilità del server pubblica o privata
     * @param accessibility
     */
    public void setAccesibility(boolean accessibility){
      this.accessibility=accessibility;
    }

    /**
     *setta il numero massimo di giocatori che possono accedere
     * @param max
     */
    public void setMaxPlayers(int max){
      this.max=max;
    }

    /**
     *setta il numero di caselle della mappa contenenti risorse
     * @param rate
     */
    public void setResourceRate(int rate){
      this.rate=rate;
    }
}