package it.edu.itiszuccante.mc.thread;

import it.edu.itiszuccante.mc.control.IAgente;

public class ThreadAgente extends Thread {
    private IAgente agente;

    public ThreadAgente(String name, IAgente agente) {
        super(name);
        this.agente = agente;
    }

    @Override
    public void run() {
        
    }
}
