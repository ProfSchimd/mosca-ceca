package it.edu.itiszuccante.mc.model;

import it.edu.itiszuccante.mc.control.IAgente;

public class CasellaOccupata extends Casella{

    private IAgente agente;
    
    public CasellaOccupata(IAgente agente) {
        this.agente = agente;
    }

    @Override
    public String toString() {
        return "occupata;" + agente.getName();
    }
    
}
