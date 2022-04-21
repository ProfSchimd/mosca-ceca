package it.edu.itiszuccante.mc.control;

import it.edu.itiszuccante.mc.model.IScacchiera;
import it.edu.itiszuccante.mc.model.Scacchiera;
import it.edu.itiszuccante.mc.thread.ServerITP;

import java.util.ArrayList;

/**
 * Classe <em>singleton</em>
 */
public class Gioco implements IGioco {

    private static Gioco giocoCorrente = null;
    /**
     * 
     * @return Il gioco corrente
     */
    public static Gioco getGiocoCorrente() {
        if (giocoCorrente == null) {
            giocoCorrente = new Gioco();
        }
        return giocoCorrente;
    }

    private IScacchiera scacchiera;

    private Gioco() {
        scacchiera = new Scacchiera();
    }

    @Override
    public IScacchiera getScacchiera() {
        return scacchiera;
    }

    ArrayList<ServerITP> clients = new ArrayList<>();
    ArrayList<Agente> playerList = new ArrayList<>(); //Lista dei giocatori

    /**
     * Metodo che aggiunge un player
     * @param o agente da aggiungere
     */
    private void addAgent(ServerITP o){
        playerList.add(o.ag);
        clients.add(o);
    }

    /**
     * Metodo che elimina un player
     * @param name nome dell'agente da eliminare dalla lista dei players
     */
    private void deleteAgente(String name){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).ag.getName().equals(name)){
                playerList.remove(i);
                clients.remove(i);
                break;
            }
        }
    }

    /**
     * Chiede la mossa all'agente
     * @param ag agente a cui chiedere la mossa
     */
    private void askMove(Agente ag){
        for(ServerITP i : clients){
            if(i.ag.equals(ag)){
                i.askMove();
            }
        }
    }

}
