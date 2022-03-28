package it.edu.itiszuccante.mc.model;

import it.edu.itiszuccante.mc.control.IAgente;

public class CasellaBandiera extends Casella {

    private IAgente agente;

    public CasellaBandiera(IAgente agente) {
        this.agente = agente;
    }
    
    @Override
    public String toString() {
        return super.toString() + ";" + agente.toString();
    }
}
