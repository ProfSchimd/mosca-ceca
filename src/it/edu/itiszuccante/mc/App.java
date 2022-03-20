package it.edu.itiszuccante.mc;

import it.edu.itiszuccante.mc.view.Finestra;

/**
 * Semplice classe per contenere il main che avvia la finestra principale
 * del gioco. Il resto della logica del programma viene 
 * 
 * @author Dotoli Francesco
 * @author Schimd Michele
 */
public class App {
    public static void main(String[] args) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Finestra();
            }
        });
    }
}