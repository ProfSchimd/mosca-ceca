package it.edu.itiszuccante.mc.model;

public class CasellaRisorsa extends Casella {
    private IRisorsa risorsa;

    public CasellaRisorsa(IRisorsa risorsa) {
        this.risorsa = risorsa;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + risorsa.getName();
    }
}
