package it.edu.itiszuccante.mc.control;

import it.edu.itiszuccante.mc.model.IScacchiera;
import it.edu.itiszuccante.mc.model.Scacchiera;

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
    
}
