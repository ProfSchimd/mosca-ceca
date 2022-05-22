package it.edu.itiszuccante.mc;

public class main {
    public static void main(String[] args) {
        Server t1=new Server(81);
        t1.setAccesibility(true);
        t1.setMaxPlayers(10);
        t1.setResourceRate(20);
        t1.start();
    }
}
