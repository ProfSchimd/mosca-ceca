package it.edu.itiszuccante.mc.control;

import java.util.ArrayList;

import it.edu.itiszuccante.mc.model.Energia;
import it.edu.itiszuccante.mc.model.ICasella;
import it.edu.itiszuccante.mc.model.IScacchiera;
import it.edu.itiszuccante.mc.model.Seta;

/**
 * @author Dotoli Francesco
 * @author Schimd Michele
 */
public class Agente implements IAgente {

    private int x;
    private int y;
    private String name;
    private Energia eng;
    private Seta seta;
    private int bandierine;
    private IScacchiera sca;
    private int mossa;

    public synchronized void pianta() {
        if ((sca.pianta(this.x, this.y, this)) && (bandierine > 0)) {
            bandierine--;
        }
    }

    public int craftBandiera() {
        if (seta.getQuantita() < 4) {
            System.out.println("Non hai abbastanza seta");
            return -2;
        }
        while (seta.getQuantita() >= 4) {
            this.bandierine++;
            seta.consuma(4);
        }
        return 0;
    }

    public synchronized ArrayList<ICasella> allFree() {
        ArrayList<ICasella> tmp = new ArrayList<>();
        ICasella neig[] = sca.getNeighborhood(this.x, this.y);
        for (ICasella cas : neig) {
            if (cas.toString().contains("vuota")) {
                tmp.add(cas);
            }
        }
        return tmp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Energia getEng() {
        return eng;
    }

    public void setEng(Energia eng) {
        this.eng = eng;
    }

    public Seta getSeta() {
        return seta;
    }

    public void setSeta(Seta seta) {
        this.seta = seta;
    }

    public IScacchiera getSca() {
        return sca;
    }

    public void setSca(IScacchiera sca) {
        this.sca = sca;
    }

    public int getMossa() {
        return mossa;
    }

    public void setMossa(int mossa) {
        this.mossa = mossa;
    }
}
