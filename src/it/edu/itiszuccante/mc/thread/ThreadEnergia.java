package it.edu.itiszuccante.mc.thread;

import it.edu.itiszuccante.mc.model.Energia;

public class ThreadEnergia extends Thread {
    private Energia energia;

    public ThreadEnergia(String name, Energia energia) {
        super(name);
        this.energia = energia;
    }

    @Override
    public void run() {
        
    }
}
