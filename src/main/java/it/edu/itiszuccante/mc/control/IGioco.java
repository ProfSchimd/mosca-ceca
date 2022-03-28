package it.edu.itiszuccante.mc.control;

import it.edu.itiszuccante.mc.model.IScacchiera;

public interface IGioco {
    /**
     * Restituisce un oggetto di tipi IScacchiera che contiene il campo
     * di gioco attuale.
     * 
     * @return la scacchiera di gioco corrente
     */
    IScacchiera getScacchiera();
}