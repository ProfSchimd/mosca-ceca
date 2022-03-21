package it.edu.itiszuccante.mc.thread;

import it.edu.itiszuccante.mc.model.Seta;

public class ThreadSeta extends Thread {
    public Seta seta;

    public ThreadSeta(String name, Seta seta) {
        super(name);
        this.seta = seta;
    }

    @Override
    public void run() {
        
    }
}
