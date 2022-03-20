package it.edu.itiszuccante.mc.model;

public class Seta extends Risorsa {

    private static final String SETA_NOME = "Seta";

    
    // public void ricarica(int q) {
    //     int tmp = getQuantita() + q;
    //     setQuantita(tmp);
    // }

    public void consuma(int q) {
        if (this.quantita < q) {
            throw new IllegalArgumentException("Tentativo di consumare più risorse di quelle disponibili");
        }
        this.quantita -= q;
    }

    @Override
    public String getName() {
        return SETA_NOME;
    }
    
}
